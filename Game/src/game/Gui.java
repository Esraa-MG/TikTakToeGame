/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.control.GameControl3;
import game.view.GameChoicePage;
import game.control.OnlineControl;
import game.view.PalyersConfig;
import game.view.SelectModeXO;
import game.view.StartPage;
import game.model.SETVIEW;
import game.view.AIConfig;
import game.view.EasyHardConfig;
import game.view.NetworkJoin;
import javafx.util.Duration;
import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author ESRAA
 */
public class Gui extends Application {

    StartPage start;
    GameChoicePage gameChoice;
    SelectModeXO startXO;
    PalyersConfig playCon;
    OnlineControl onlineControl;
    EasyHardConfig easyHardConfig;
    AIConfig aiConfig;


    GameControl3 gameCon3;

    String[] playersArr;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Game Time");

        playersArr = new String[2];
        playersArr[0] = new String("Player1");
        playersArr[1] = new String("Player2");

        start = new StartPage();
        gameChoice = new GameChoicePage();
        startXO = new SelectModeXO();
        playCon = new PalyersConfig();
        easyHardConfig = new EasyHardConfig() ;
        aiConfig = new  AIConfig();

        onlineControl = new OnlineControl();

       

        gameCon3 = new GameControl3();

        Scene startScene = new Scene(start);
        Scene gameChoiceScene = new Scene(gameChoice);
       
        Scene startXOScene = new Scene(startXO);
        Scene playConScene = new Scene(playCon);
        Scene AIConfigScene = new Scene(aiConfig);
        Scene easyHardScene = new Scene(easyHardConfig);
       
        Scene networkJoinScene = new Scene(onlineControl.networkJoin);
     
        Scene gameScene = new Scene(gameCon3.gameUi);

        //game time animation
        //psition 
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(3));
        transition.setNode(start.gameTime);
        transition.setToY(-320);
        transition.setToX(-125);
        //scale
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(2), start.gameTime);
        scaleTransition.setByX(2);
        scaleTransition.setByY(2);
        //rotation
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(2), start.gameTime);
        rotateTransition.setFromAngle(45);
        rotateTransition.setToAngle(360);

        //moving image
        TranslateTransition movingTransition = new TranslateTransition();
        movingTransition.setDuration(Duration.seconds(2));
        movingTransition.setNode(start.moving);
        movingTransition.setByX(500);

        transition.play();
        scaleTransition.play();
        rotateTransition.play();

        rotateTransition.setOnFinished((e) -> {
            movingTransition.play();

        });

        movingTransition.setOnFinished((e) -> {
            start.start.setVisible(true);
        });

        start.start.setOnAction(((event) -> {

            stage.setScene(gameChoiceScene);

        }));

        //game choice page control
        gameChoice.snake.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
           
        });

        gameChoice.xo.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            stage.setScene(startXOScene);
        });

        //start page of XO control
        startXO.back.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            stage.setScene(gameChoiceScene);

        });

        startXO.online.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            stage.setScene(networkJoinScene);
        });

        startXO.single.setOnAction(((event) -> {
            stage.setScene(AIConfigScene);
        }));

        startXO.twoplayer.setOnAction(((event) -> {

            stage.setScene(playConScene);

        }));
        
         aiConfig.start.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            stage.setScene(easyHardScene);
        });
         aiConfig.back.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            stage.setScene(startXOScene);
        });
         
         easyHardConfig.back.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            stage.setScene(AIConfigScene);
        });

        //create button
        onlineControl.networkJoin.create.setOnAction(((event) -> {
            onlineControl.mod.startServer();

            onlineControl.mod.startNeworkGame(onlineControl);
            boolean status = onlineControl.mod.connectToIP(onlineControl.localIP);
            if (status) {
                onlineControl.mod.allowClientToSave();
                onlineControl.mod.setPlayerName(onlineControl.networkJoin.player.getText());
                onlineControl.networkJoin.hostip.setText(onlineControl.mod.getHostIP());
                onlineControl.networkJoin.create.setDisable(true);

            }
        }));
        //join button
        onlineControl.networkJoin.join.setOnAction(((event) -> {
            if (onlineControl.mod.isNetworkOn()) {
                //mod.exitNetworkMode();
                onlineControl.mod.closeSocket();
                onlineControl.mod.closeServer();
                onlineControl.mod.disableSave();
            }
            onlineControl.mod.startNeworkGame(onlineControl);
            onlineControl.mod.connectToIP(onlineControl.networkJoin.ip.getText());
            onlineControl.mod.setPlayerName(onlineControl.networkJoin.player.getText());
            onlineControl.networkJoin.create.setDisable(false);

        }));
        //start game
            onlineControl.networkJoin.start.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            onlineControl.gameUi.player1label.setText(onlineControl.mod.getPlayerName());
            onlineControl.gameUi.player2label.setText(onlineControl.mod.getOponentName());
            System.out.println("game1 " + onlineControl.mod.getPlayerName());
            System.out.println("game1 " + onlineControl.mod.getOponentName());
            Scene onlineGameScene = new Scene(onlineControl.gameUi);
            stage.setScene(onlineGameScene);
            onlineControl.controlGame();

        });
           onlineControl.gameUi.back.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> { 
               stage.setScene(networkJoinScene);
           });

        //players config scene control
        playCon.back.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            stage.setScene(startXOScene);
            playCon.palyer2o.setDisable(false);
            playCon.palyer1o.setDisable(false);
            playCon.palyer2x.setDisable(false);
            playCon.palyer1x.setDisable(false);
            playCon.palyer2o.setSelected(false);
            playCon.palyer1o.setSelected(false);
            playCon.palyer2x.setSelected(false);
            playCon.palyer1x.setSelected(false);

        });

        playCon.start.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            playersArr[0] = playCon.player1text.getText();
            playersArr[1] = playCon.player2text.getText();
            if (playCon.palyer1x.isDisable()) {
                gameCon3.SymbolArr[0] = 'O';
                gameCon3.SymbolArr[1] = 'X';
            }
            if (playCon.palyer1o.isDisable()) {
                gameCon3.SymbolArr[0] = 'X';
                gameCon3.SymbolArr[1] = 'O';
            }
            if (playCon.palyer2x.isDisable()) {
                gameCon3.SymbolArr[0] = 'X';
                gameCon3.SymbolArr[1] = 'O';
            }
            if (playCon.palyer2o.isDisable()) {
                gameCon3.SymbolArr[0] = 'O';
                gameCon3.SymbolArr[1] = 'X';
            }

            gameCon3.controlGame();
            stage.setScene(gameScene);

            gameCon3.gameUi.player1label.setText(playersArr[0]);
            gameCon3.gameUi.player2label.setText(playersArr[1]);
            gameCon3.gameUi.player1score.setText(String.valueOf(gameCon3.scoreArr[0]));
            gameCon3.gameUi.player2score.setText(String.valueOf(gameCon3.scoreArr[1]));

            gameCon3.Reset();

        }
        );

        //radionbuttons control
        playCon.palyer1x.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                playCon.palyer2x.setDisable(true);
                playCon.palyer2o.setDisable(false);
            }
        });
        playCon.palyer1o.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                playCon.palyer2o.setDisable(true);
                playCon.palyer2x.setDisable(false);
            }
        });

        playCon.palyer2x.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                playCon.palyer1x.setDisable(true);
                playCon.palyer1o.setDisable(false);
            }
        });
        playCon.palyer2o.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                playCon.palyer1o.setDisable(true);
                playCon.palyer1x.setDisable(false);
            }
        });

        //back button control 
        gameCon3.gameUi.back.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            stage.setScene(playConScene);
            gameCon3.scoreArr[0] = 0;
            gameCon3.scoreArr[1] = 0;
            gameCon3.Reset();
        });

        //easy hard config scene control
//        easyHardConfig.back.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
//            stage.setScene(startXOScene);
//
//        });

        stage.setScene(startScene);

        stage.setResizable(false);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
