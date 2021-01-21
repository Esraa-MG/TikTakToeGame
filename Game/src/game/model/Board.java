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

    public static final int NO_PLAYER = 0;
    public static final int PLAYER_X = 1;
    public static final int PLAYER_O = 2;
    public final GameDao gameDao = new GameDao();
    public GameRecord gameRecord = new GameRecord();

    public static int[][] board = new int[3][3];
    public Point computerMove;

    public boolean isGameOver() {
        return hasPlayerWon(PLAYER_X) || hasPlayerWon(PLAYER_O) || getAvailabelCells().isEmpty();
    }

    public boolean hasPlayerWon(int player) {
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

    public List<Point> getAvailabelCells() {
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

    public boolean PlaceMove(Point point, int player) {
        if (board[point.x][point.y] != NO_PLAYER) {
            return false;
        }
        board[point.x][point.y] = player;
        return true;
    }

    public int SetVal(Point point) {
        int num = 0;
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

    }

    public Point ReverseSetVal(int n) {
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

    public void displayBoard() {
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

    public int minimax(int depth, int turn) {
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
     
      public int CompMove(){
             
            int numOfCompCell;
            displayBoard(); 
            minimax(0, Board.PLAYER_X);
            System.out.println("computer choose position : "+computerMove);
            System.out.println(computerMove);
            PlaceMove(computerMove, Board.PLAYER_O);
            System.out.print(SetVal(computerMove));//to get the number of computer cell
            displayBoard();
            numOfCompCell=SetVal(computerMove);
            return numOfCompCell;
            
    }
     
     
//computer hard game
    public int CompMove2(int m) {
        int numOfCell = 0;
        //Point userMove = new Point(x, y);
        PlaceMove(ReverseSetVal(m), Board.PLAYER_O);
        //System.out.println(b.SetVal(userMove));

        minimax(0, Board.PLAYER_X);
        System.out.println("computer choose position : " + computerMove);

        System.out.println(computerMove);
        PlaceMove(computerMove, Board.PLAYER_X);
        numOfCell = SetVal(computerMove);
        System.out.print(SetVal(computerMove));//to get the number of computer cell
        displayBoard();

        return numOfCell;
    }

}
