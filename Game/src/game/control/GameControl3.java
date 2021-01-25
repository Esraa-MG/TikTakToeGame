/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.control;

import game.model.GameModel;
import game.view.GameUi;
import gameDB.GameDao;
import gameDB.GameRecord;
import java.sql.SQLException;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 *
 * @author ESRAA
 */
public class GameControl3 {

    public GameUi gameUi = new GameUi();
    GameModel GameMod = new GameModel();
    public GameRecord gameRecord;
    GameDao gameDao;

    char symbol;
    public boolean stopGame = false;
    String result;

    public int[] scoreArr = new int[2];
    public char[] SymbolArr = new char[2];
    public String[] playersArr;
    public boolean recordFlag = true;

    public GameControl3() {
        scoreArr[0] = 0;
        scoreArr[1] = 0;

        SymbolArr[0] = 'X';
        SymbolArr[1] = 'O';

        playersArr = new String[2];
        playersArr[0] = new String("Player1");
        playersArr[1] = new String("Player2");

        gameRecord = new GameRecord();
        gameDao = new GameDao();
    }

    int[] buttonPressed = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    ImageView[] img = {gameUi.r1c1, gameUi.r2c1, gameUi.r3c1,
        gameUi.r1c2, gameUi.r2c2, gameUi.r3c2, gameUi.r1c3, gameUi.r2c3, gameUi.r3c3};

    int i;

    public void controlGame() {
        symbol = 'X';

        for (i = 0; i < 9; i++) {
            final int index = i;
            img[i].addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                if (buttonPressed[index] == 0) {
                    if (!stopGame) {
                        if (symbol == 'X') {
                            img[index].setImage(new Image(getClass().getClassLoader().getResource("game/pic/x.jpg").toExternalForm()));
                            gameRecord.addGameMove(index + 1, 'X');
                        } else {
                            img[index].setImage(new Image(getClass().getClassLoader().getResource("game/pic/o.png").toExternalForm()));
                            gameRecord.addGameMove(index + 1, 'O');
                        }

                        result = GameMod.selectCell(index + 1, symbol);
                        System.out.println(result);
                        if (result == "Xwin" || result == "Owin" || result == "draw") {
                            showScore();
                            stopGame = true;
                            gameUi.record.setVisible(true);
                        }
                        winAnimation();
                        changeSymbol();
                    }
                }

                buttonPressed[index] = 1;
            });
        }

        //reset control
        gameUi.reset.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            symbol = 'X';
            Reset();
            gameRecord = new GameRecord();
            recordFlag = true;
        });

        gameUi.record.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if (recordFlag) {
                if (SymbolArr[0] == 'X') {
                    try {
                        gameDao.insertGame(playersArr[0], playersArr[1], gameRecord);
                        recordFlag = false;
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        dataBaseConnectionAlert();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                        dataBaseConnectionAlert();
                    }
                } else {
                    try {
                        gameDao.insertGame(playersArr[1], playersArr[0], gameRecord);
                        recordFlag = false;
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        dataBaseConnectionAlert();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                        dataBaseConnectionAlert();
                    }
                }
                gameUi.record.setVisible(false);
            }
        });

    }

    void dataBaseConnectionAlert() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("DataBase Connection Failed");
        alert.setHeaderText("Please connect to database");
        alert.setContentText("Ooops, there was an error in database connection!");
        alert.showAndWait();
    }

    public void Reset() {
        for (int i = 0; i < 9; i++) {
            img[i].setImage(null);
        }
        GameMod.resetGame();
        stopGame = false;
        gameUi.draw.setVisible(false);
        gameUi.clap.setVisible(false);
        for (int i = 0; i < 9; i++) {
            buttonPressed[i] = 0;
        }
    }

    public void changeSymbol() {
        if (symbol == 'X') {
            symbol = 'O';
        } else {
            symbol = 'X';
        }
    }

    public void showScore() {
        if (result == "Xwin") {
            for (int i = 0; i < 2; i++) {
                if (SymbolArr[i] == 'X') {
                    scoreArr[i]++;
                    gameUi.player1score.setText(String.valueOf(scoreArr[0]));
                    gameUi.player2score.setText(String.valueOf(scoreArr[1]));
                }
            }
        } else if (result == "Owin") {
            for (int i = 0; i < 2; i++) {
                if (SymbolArr[i] == 'O') {
                    scoreArr[i]++;
                    gameUi.player1score.setText(String.valueOf(scoreArr[0]));
                    gameUi.player2score.setText(String.valueOf(scoreArr[1]));
                }
            }
        }
    }

    public void xwinAnimation() {
        //psition 
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(4));
        transition.setNode(gameUi.xwins);
        transition.setToY(-300);
        //scale
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(3), gameUi.xwins);
        scaleTransition.setByX(2);
        scaleTransition.setByY(2);
        //rotation
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(3), gameUi.xwins);
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(360);

        transition.setCycleCount(2);
        scaleTransition.setCycleCount(2);
        rotateTransition.setCycleCount(2);
        transition.setAutoReverse(true);
        scaleTransition.setAutoReverse(true);
        rotateTransition.setAutoReverse(true);

        transition.play();
        scaleTransition.play();
        rotateTransition.play();

        scaleTransition.setOnFinished((e) -> {
            if (stopGame) {
                gameUi.clap.setVisible(true);
            }
            gameUi.xwins.setVisible(false);

        });
    }

    public void owinAnimation() {
        //psition 
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(4));
        transition.setNode(gameUi.owins);
        transition.setToY(-300);
        //scale
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(3), gameUi.owins);
        scaleTransition.setByX(2);
        scaleTransition.setByY(2);
        //rotation
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(3), gameUi.owins);
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(360);

        transition.setCycleCount(2);
        scaleTransition.setCycleCount(2);
        rotateTransition.setCycleCount(2);
        transition.setAutoReverse(true);
        scaleTransition.setAutoReverse(true);
        rotateTransition.setAutoReverse(true);

        transition.play();
        scaleTransition.play();
        rotateTransition.play();

        scaleTransition.setOnFinished((e) -> {
            if (stopGame) {
                gameUi.clap.setVisible(true);
            }
            gameUi.owins.setVisible(false);
        });
    }

    public void drawAnimation() {
        //psition 
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(4));
        transition.setNode(gameUi.draw);
        transition.setToY(-300);
        //scale
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(3), gameUi.draw);
        scaleTransition.setByX(2);
        scaleTransition.setByY(2);
        //rotation
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(3), gameUi.draw);
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(360);

        transition.setCycleCount(2);
        scaleTransition.setCycleCount(2);
        rotateTransition.setCycleCount(2);
        transition.setAutoReverse(true);
        scaleTransition.setAutoReverse(true);
        rotateTransition.setAutoReverse(true);

        transition.play();
        scaleTransition.play();
        rotateTransition.play();

    }

    public void winAnimation() {
        if (result == "Xwin") {
            gameUi.xwins.setVisible(true);
            xwinAnimation();

        } else if (result == "Owin") {
            gameUi.owins.setVisible(true);
            owinAnimation();

        } else if (result == "draw") {
            gameUi.draw.setVisible(true);
            drawAnimation();
        }
    }

}
