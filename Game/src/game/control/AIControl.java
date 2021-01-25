/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.control;

import game.model.Model;
import game.model.SETVIEW;
import game.view.GameUi;
import java.util.Timer;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 *
 * @author ESRAA
 */
public class AIControl implements SETVIEW {

    public GameUi gameUi = new GameUi();
    public Model mod = new Model();
    Timer timer = new Timer();

    int i;
    public int[] scoreArr = new int[2];

    public AIControl() {
        scoreArr[0] = 0;
        scoreArr[1] = 0;
    }

    ImageView[] img = {gameUi.r1c1, gameUi.r2c1, gameUi.r3c1,
        gameUi.r1c2, gameUi.r2c2, gameUi.r3c2, gameUi.r1c3, gameUi.r2c3, gameUi.r3c3};

    @Override
    public void setView(int at, char mark) {

        switch (at) {
            case 1:
                if (mark == 'X') {
                    gameUi.r1c1.setImage(new Image(getClass().
                            getClassLoader().getResource("game/pic/x.jpg").toExternalForm()));
                } else {
                    
                    gameUi.r1c1.setImage(new Image(getClass()
                            .getClassLoader().getResource("game/pic/o.png").toExternalForm()));
                }

                break;

            case 2:
                if (mark == 'X') {
                    gameUi.r2c1.setImage(new Image(getClass().
                            getClassLoader().getResource("game/pic/x.jpg").toExternalForm()));
                } else {
                    gameUi.r2c1.setImage(new Image(getClass()
                            .getClassLoader().getResource("game/pic/o.png").toExternalForm()));
                }
                break;
            case 3:
                if (mark == 'X') {
                    gameUi.r3c1.setImage(new Image(getClass().
                            getClassLoader().getResource("game/pic/x.jpg").toExternalForm()));
                } else {
                    gameUi.r3c1.setImage(new Image(getClass()
                            .getClassLoader().getResource("game/pic/o.png").toExternalForm()));
                }
                break;
            case 4:
                if (mark == 'X') {
                    gameUi.r1c2.setImage(new Image(getClass().
                            getClassLoader().getResource("game/pic/x.jpg").toExternalForm()));
                } else {
                    gameUi.r1c2.setImage(new Image(getClass()
                            .getClassLoader().getResource("game/pic/o.png").toExternalForm()));
                }
                break;
            case 5:
                if (mark == 'X') {
                    gameUi.r2c2.setImage(new Image(getClass().
                            getClassLoader().getResource("game/pic/x.jpg").toExternalForm()));
                } else {
                    gameUi.r2c2.setImage(new Image(getClass()
                            .getClassLoader().getResource("game/pic/o.png").toExternalForm()));
                }
                break;
            case 6:
                if (mark == 'X') {
                    gameUi.r3c2.setImage(new Image(getClass().
                            getClassLoader().getResource("game/pic/x.jpg").toExternalForm()));
                } else {
                    gameUi.r3c2.setImage(new Image(getClass()
                            .getClassLoader().getResource("game/pic/o.png").toExternalForm()));
                }
                break;
            case 7:
                if (mark == 'X') {
                    gameUi.r1c3.setImage(new Image(getClass().
                            getClassLoader().getResource("game/pic/x.jpg").toExternalForm()));
                } else {
                    gameUi.r1c3.setImage(new Image(getClass()
                            .getClassLoader().getResource("game/pic/o.png").toExternalForm()));
                }
                break;
            case 8:
                if (mark == 'X') {
                    gameUi.r2c3.setImage(new Image(getClass().
                            getClassLoader().getResource("game/pic/x.jpg").toExternalForm()));
                } else {
                    gameUi.r2c3.setImage(new Image(getClass()
                            .getClassLoader().getResource("game/pic/o.png").toExternalForm()));
                }
                break;
            case 9:
                if (mark == 'X') {
                    gameUi.r3c3.setImage(new Image(getClass().
                            getClassLoader().getResource("game/pic/x.jpg").toExternalForm()));
                } else {
                    gameUi.r3c3.setImage(new Image(getClass()
                            .getClassLoader().getResource("game/pic/o.png").toExternalForm()));
                }
                break;
            default:
                break;
        }

    }

    @Override
    public void resetScreen() {
        for (i = 0; i < 9; i++) {
            img[i].setImage(null);
        }
        gameUi.record.setVisible(false);
    }

    @Override
    public void runWinnigAnimation(String name) {
        gameUi.dance.setImage(new Image(getClass().getClassLoader()
                .getResource("game/pic/win1.gif").toExternalForm()));
        gameUi.dance.setVisible(true);

        scoreArr[0]++;
        gameUi.player1score.setText(String.valueOf(scoreArr[0]));
        gameUi.record.setVisible(true);
    }

    @Override
    public void runLosingAnimation(String name) {

        gameUi.cry.setImage(new Image(getClass()
                .getClassLoader().getResource("game/pic/source.gif").toExternalForm()));
        gameUi.cry.setVisible(true);
        scoreArr[1]++;
        gameUi.player2score.setText(String.valueOf(scoreArr[1]));
        gameUi.record.setVisible(true);
    }

    @Override
    public void runDrawAnimation() {
        gameUi.draw.setVisible(true);
        drawAnimation();
        gameUi.record.setVisible(true);
    }

    @Override
    public void isMyTurn() {
        gameUi.player1label1.setVisible(true);
        gameUi.player1label1.setText("Your Turn");
    }

    @Override
    public void isNotMyTurn() {
        gameUi.player1label1.setVisible(true);
        gameUi.player1label1.setText("Waiting");
    }

    public void controlGame() {
        for (i = 0; i < 9; i++) {
            final int index = i;
            img[index].addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                mod.AI_playerSelectedCell(index + 1);
            });
        }

        gameUi.reset.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            // resetScreen();
            mod.AI_resetGame();

            gameUi.cry.setVisible(false);
            gameUi.dance.setVisible(false);
            gameUi.draw.setVisible(false);

        });
        
         gameUi.record.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
           mod.AI_saveGame();
           gameUi.record.setVisible(false);
            
        });
    }

    public void drawAnimation() {
        //game time animation
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

}
