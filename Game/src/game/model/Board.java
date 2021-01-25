/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model;

import gameDB.GameDao;
import gameDB.GameRecord;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Alert;

/**
 *
 * @author Hamada Sabry
 */
class PointAndScore {

    int score;
    Point point;

    PointAndScore(int score, Point point) {
        this.score = score;
        this.point = point;
    }
}

public class Board {

    private boolean playGame = true;
    private static final int NO_PLAYER = 0;
    private static final int PLAYER_X = 1;
    private static final int PLAYER_O = 2;
    private final GameDao gameDao = new GameDao();
    private GameRecord gameRecord = new GameRecord();

    //---------------------------------
    private GameModel myModel;
    private SETVIEW viewDelegate;
    private Timer timer = new Timer();
    private boolean isPlayerTurn = true;

    public Board(SETVIEW delegate) {
        viewDelegate = delegate;
        myModel = new GameModel();
    }
    //---------------------------------

    private static int[][] board = new int[3][3];
    private Point computerMove;
    private String playerName;

    public void setPlayerName(String name) {
        playerName = name;
    }

    public void saveGame() {
        try {
            gameDao.insertGame(playerName, "Robot", gameRecord);
        } catch (SQLException ex) {
            ex.printStackTrace();
            dataBaseConnectionAlert();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            dataBaseConnectionAlert();
        }
    }

    private boolean isGameOver() {
        return hasPlayerWon(PLAYER_X) || hasPlayerWon(PLAYER_O) || getAvailabelCells().isEmpty();
    }

    private boolean hasPlayerWon(int player) {
        if ((board[0][0] == board[1][1]
                && board[0][0] == board[2][2]
                && board[0][0] == player)
                || (board[0][2] == board[1][1]
                && board[0][2] == board[2][0]
                && board[0][2] == player)) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == board[i][1]
                    && board[i][0] == board[i][2]
                    && board[i][0] == player)
                    || (board[0][i] == board[1][i]
                    && board[0][i] == board[2][i]
                    && board[0][i] == player)) {
                return true;
            }
        }
        return false;
    }

    private List<Point> getAvailabelCells() {
        List<Point> availableCells = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == NO_PLAYER) {
                    availableCells.add(new Point(i, j));
                }
            }
        }
        return availableCells;
    }

    private boolean PlaceMove(Point point, int player) {
        if (board[point.x][point.y] != NO_PLAYER) {
            return false;
        }
        board[point.x][point.y] = player;
        return true;
    }

    public void playerMove(int cell) {
        if (playGame && isPlayerTurn) {
            String status = myModel.selectCell(cell, 'X');
            switch (status) {
                case "Xwin":
                case "Owin":
                    gameRecord.addGameMove(cell, 'X');
                    Platform.runLater(() -> {
                        viewDelegate.setView(cell, 'X');
                        //win Animation.
                        viewDelegate.runWinnigAnimation("You");
                    });
                    playGame = false;
                    break;

                case "draw":
                    gameRecord.addGameMove(cell, 'X');
                    Platform.runLater(() -> {
                        viewDelegate.setView(cell, 'X');
                        //draw Animation.
                        viewDelegate.runDrawAnimation();
                    });
                    playGame = false;
                    break;

                case "none":
                    gameRecord.addGameMove(cell, 'X');
                    Platform.runLater(() -> {
                        viewDelegate.setView(cell, 'X');
                    });
                    Point playPoint = ReverseSetVal(cell);
                    PlaceMove(playPoint, PLAYER_X);
                    isPlayerTurn = false;
                    CompMove();
                    break;

                case "isMarked":
                    break;

                default:
                    break;
            }
        }
    }

    private int SetVal(Point point) {
        int num = 0;
        if (point != null) {
            if (point.x == 0 && point.y == 0) {
                return num = 1;
            } else if (point.x == 0 && point.y == 1) {
                return num = 2;
            } else if (point.x == 0 && point.y == 2) {
                return num = 3;
            } else if (point.x == 1 && point.y == 0) {
                return num = 4;
            } else if (point.x == 1 && point.y == 1) {
                return num = 5;
            } else if (point.x == 1 && point.y == 2) {
                return num = 6;
            } else if (point.x == 2 && point.y == 0) {
                return num = 7;
            } else if (point.x == 2 && point.y == 1) {
                return num = 8;
            } else if (point.x == 2 && point.y == 2) {
                return num = 9;
            }
            return num;
        } else {
            return 0;
        }

    }

    private Point ReverseSetVal(int n) {
        Point p = null;
        switch (n) {
            case 1:
                p = new Point(0, 0);
                break;

            case 2:
                p = new Point(0, 1);
                break;

            case 3:
                p = new Point(0, 2);
                break;

            case 4:
                p = new Point(1, 0);
                break;

            case 5:
                p = new Point(1, 1);
                break;

            case 6:
                p = new Point(1, 2);
                break;

            case 7:
                p = new Point(2, 0);
                break;

            case 8:
                p = new Point(2, 1);
                break;

            case 9:
                p = new Point(2, 2);
                break;

        }
        return p;
    }

    private void displayBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String value = "";
                if (board[i][j] == NO_PLAYER) {
                    value = "?";
                }
                if (board[i][j] == PLAYER_X) {
                    value = "X";
                } else if (board[i][j] == PLAYER_O) {
                    value = "O";
                }
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private int minimax(int depth, int turn) {
        if (hasPlayerWon(PLAYER_X)) {
            return 1;
        }
        if (hasPlayerWon(PLAYER_O)) {
            return -1;
        }

        List<Point> availableCells = getAvailabelCells();
        if (availableCells.isEmpty()) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < availableCells.size(); i++) {
            Point point = availableCells.get(i);

            if (turn == PLAYER_X) {
                PlaceMove(point, PLAYER_X);
                int currentScore = minimax(depth + 1, PLAYER_O);
                max = Math.max(currentScore, max);

                if (depth == 0) {
                    System.out.println("Computer score position" + point + "=" + currentScore);
                }
                if (currentScore >= 0) {
                    if (depth == 0) {
                        computerMove = point;
                    }
                }
                SetVal(point);//to get cell of computer

                if (currentScore == 1) {
                    board[point.x][point.y] = NO_PLAYER;
                    break;
                }
                if (i == availableCells.size() - 1 && max < 0) {
                    if (depth == 0) {
                        computerMove = point;
                    }
                }
                // SetVal(point);//to get cell of computer
            } else if (turn == PLAYER_O) {
                PlaceMove(point, PLAYER_O);
                int currentScore = minimax(depth + 1, PLAYER_X);
                min = Math.min(currentScore, min);

                if (min == -1) {
                    board[point.x][point.y] = NO_PLAYER;
                    break;
                }
            }
            board[point.x][point.y] = NO_PLAYER;
        }
        return turn == PLAYER_X ? max : min;
    }

    /*
    public int CompMove(int x, int y) {
        int z = 0;

        Point userMove = new Point(x, y);
        PlaceMove(userMove, Board.PLAYER_O);
        //System.out.println(b.SetVal(userMove));

        minimax(0, Board.PLAYER_X);
        System.out.println("computer choose position : " + computerMove);

        System.out.println(computerMove);
        PlaceMove(computerMove, Board.PLAYER_X);
        z = SetVal(computerMove);
        System.out.print(SetVal(computerMove));//to get the number of computer cell
        displayBoard();

        return z;
    }
     */
    //computer to easy game
    private void CompMove() {
        //displayBoard(); 
        minimax(0, Board.PLAYER_X);
        //System.out.println("computer choose position : "+computerMove);
        //System.out.println(computerMove);
        int cell = SetVal(computerMove);
        String status = myModel.selectCell(cell, 'O');

//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
//            }
        switch (status) {
            case "Xwin":
            case "Owin":
                gameRecord.addGameMove(cell, 'O');
                Platform.runLater(() -> {
                    // Your database code here
                    viewDelegate.setView(cell, 'O');
                    viewDelegate.runLosingAnimation("You");
                    isPlayerTurn = true;

                });

                playGame = false;
                break;

            case "draw":
                gameRecord.addGameMove(cell, 'O');
                Platform.runLater(() -> {

                    // Your database code here
                    viewDelegate.setView(cell, 'O');
                    //draw Animation.
                    viewDelegate.runDrawAnimation();
                    isPlayerTurn = true;

                });
                playGame = false;
                break;

            case "none":
                gameRecord.addGameMove(cell, 'O');
                Platform.runLater(() -> {
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            // Your database code here
                            viewDelegate.setView(cell, 'O');
                            isPlayerTurn = true;
                        }
                    }, 1000);

                });
                PlaceMove(computerMove, PLAYER_O);
                break;

            case "isMarked":
                break;

            default:
                break;
        }

//            PlaceMove(computerMove, Board.PLAYER_O);
        //System.out.print(SetVal(computerMove));//to get the number of computer cell
        displayBoard();
        //numOfCompCell=SetVal(computerMove);
        //return numOfCompCell;

    }

    public void resetGame() {
        myModel.resetGame();
        board = new int[3][3];
        playGame = true;
        Platform.runLater(() -> {
            viewDelegate.resetScreen();
        });
    }

//computer hard game
    public void CompMove2(int m) {
        //int numOfCell = 0;
        int x = (m - 1) / 3;
        int y = (m - 1) % 3;
        String status;
        boolean allowAI = true;

        if (playGame && isPlayerTurn) {
            Point userMove = new Point(x, y);

            status = myModel.selectCell(m, 'X');

            switch (status) {
                case "Xwin":
                case "Owin":
                    gameRecord.addGameMove(m, 'X');
                    Platform.runLater(() -> {
                        viewDelegate.setView(m, 'X');
                        //win code
                        viewDelegate.runWinnigAnimation("You");
                    });
                    System.out.println("player win");
                    playGame = false;
                    allowAI = false;
                    break;

                case "draw":
                    gameRecord.addGameMove(m, 'X');
                    //draw code.
                    Platform.runLater(() -> {
                        viewDelegate.setView(m, 'X');
                        viewDelegate.runDrawAnimation();
                    });
                    playGame = false;
                    allowAI = false;
                    break;

                case "none":
                    gameRecord.addGameMove(m, 'X');
                    Platform.runLater(() -> {
                        viewDelegate.setView(m, 'X');
                    });
                    allowAI = true;
                    isPlayerTurn = false;
                    PlaceMove(userMove, Board.PLAYER_O);
                    break;

                case "isMarked":
                    allowAI = false;
                    break;

                default:
                    break;
            }

            //PlaceMove(userMove, Board.PLAYER_O);
            //System.out.println(b.SetVal(userMove));
            if (allowAI) {
                minimax(0, Board.PLAYER_X);
                System.out.println("computer choose position : " + computerMove);
                int numOfCell = SetVal(computerMove);
                status = myModel.selectCell(numOfCell, 'O');
                switch (status) {
                    case "Xwin":
                    case "Owin":
                        gameRecord.addGameMove(m, 'O');
                        Platform.runLater(() -> {

                            viewDelegate.setView(numOfCell, 'O');
                            viewDelegate.runLosingAnimation("You");
                            isPlayerTurn = true;
                        });

                        System.out.println("AI win");
                        playGame = false;
                        break;

                    case "draw":
                        gameRecord.addGameMove(m, 'O');
                        //draw code.
                        Platform.runLater(() -> {

                            viewDelegate.setView(numOfCell, 'O');
                            viewDelegate.runDrawAnimation();
                            isPlayerTurn = true;

                        });
                        playGame = false;
                        break;

                    case "none":
                        gameRecord.addGameMove(m, 'O');
                        Platform.runLater(() -> {
                            timer.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    viewDelegate.setView(numOfCell, 'O');
                                    isPlayerTurn = true;
                                }

                            }, 1000);

                        });
                        PlaceMove(computerMove, Board.PLAYER_X);
                        break;

                    case "isMarked":
                        break;

                    default:
                        break;
                }

                System.out.println(computerMove);
                //PlaceMove(computerMove, Board.PLAYER_X);

                System.out.print(SetVal(computerMove));//to get the number of computer cell

            }
            displayBoard();
            //return numOfCell;
        }
        //return -1;
    }
    
    void dataBaseConnectionAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("DataBase Connection Failed");
        alert.setHeaderText("Please connect to database");
        alert.setContentText("Ooops, there was an error in database connection!");
        alert.showAndWait();
    }

}
