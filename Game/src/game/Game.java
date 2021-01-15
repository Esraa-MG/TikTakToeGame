/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;



import game.model.SETVIEW;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ESRAA
 */
public class Game extends Application{
    
    StartUI StrUi;
    SecondPage ScndUi;
    Page3UI Page3Ui;
    GameControl3 GameCon3;
    
 
    String[] playersArr;

    
    GameUI GameUi;

    boolean stopGame = false;
    String result;
    
    int mode = 0;

    @Override
    public void start(Stage stage) throws Exception {
        
      
        StrUi = new StartUI();
        ScndUi = new SecondPage();
        Page3Ui = new Page3UI();
        GameCon3 = new GameControl3();
        
        GameUi = new GameUI();
        
        
        
        playersArr = new String[2];
        playersArr[0] = new String("Player1");
        playersArr[1] = new String("Player2");
        
        
        
        Scene start = new Scene(StrUi);
        Scene second = new Scene(ScndUi);
        Scene third = new Scene(Page3Ui);
        Scene Game = new Scene(GameCon3.GameUi);
        
        
        
        
        stage.setScene(start);
        
        //start page contol
        
        //single mode button
        StrUi.Single.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                    stage.setScene(second);
            }
        });
        
        //two players mode button
         StrUi.Two.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                    stage.setScene(third);
                    mode = 3;
                     //GameUI control
                    GameCon3.controlGame();
            }
        });
         
          //online mode button
         StrUi.Online.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                    stage.setScene(third);
     
            }
        });
        
        
        //second page control
        
        //back button
        ScndUi.Back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                    stage.setScene(start);
            }
        });
        
        
        //third page control
        
        
        //back button
        Page3Ui.Back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                    stage.setScene(start);
                    Page3Ui.player2o.setDisable(false);
                    Page3Ui.player1o.setDisable(false);
                    Page3Ui.player2x.setDisable(false);
                    Page3Ui.player1x.setDisable(false);
                    Page3Ui.player2o.setSelected(false);
                    Page3Ui.player1o.setSelected(false);
                    Page3Ui.player2x.setSelected(false);
                    Page3Ui.player1x.setSelected(false);
            }
        });
        
        //start button
        Page3Ui.Start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                
                   playersArr[0] = Page3Ui.player1.getText();
                   playersArr[1] = Page3Ui.player2.getText();
             
                if (Page3Ui.player1x.isDisable())
                {
                    GameCon3.SymbolArr[0] = 'O';
                    GameCon3.SymbolArr[1] = 'X';
                }
                if (Page3Ui.player1o.isDisable())
                {
                    GameCon3.SymbolArr[0] = 'X';
                    GameCon3.SymbolArr[1] = 'O';
                }
                if (Page3Ui.player2x.isDisable())
                {
                    GameCon3.SymbolArr[0] = 'X';
                    GameCon3.SymbolArr[1] = 'O';
                }
                if (Page3Ui.player2o.isDisable())
                {
                    GameCon3.SymbolArr[0] = 'O';
                    GameCon3.SymbolArr[1] = 'X';
                } 
                
                if (mode == 3)
                {
                    stage.setScene(Game);
                }
                
                GameCon3.GameUi.label.setText(playersArr[0]);
                GameCon3.GameUi.label1.setText(playersArr[1]);
                GameCon3.GameUi.label0.setText(String.valueOf(GameCon3.scoreArr[0]));
                GameCon3.GameUi.label2.setText(String.valueOf(GameCon3.scoreArr[1]));
                
                GameCon3.Reset();  
                
                
                
            }
        });
        
        //radionbuttons control
        Page3Ui.player1x.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Page3Ui.player2x.setDisable(true);
                Page3Ui.player2o.setDisable(false);
            }
        });
        Page3Ui.player1o.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Page3Ui.player2o.setDisable(true);
                Page3Ui.player2x.setDisable(false);
            }
        });
        
        Page3Ui.player2x.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Page3Ui.player1x.setDisable(true);
                Page3Ui.player1o.setDisable(false);
            }
        });
        Page3Ui.player2o.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Page3Ui.player1o.setDisable(true);
                Page3Ui.player1x.setDisable(false);
            }
        });
       
       
  
        //back control
         GameCon3.GameUi.Back.setOnAction((event)->{
             stage.setScene(third);
             GameCon3.scoreArr[0]=0;
             GameCon3.scoreArr[1]=0;  
         });
         
         

        stage.show();  
       
    }
    
    
   
    
 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args); 
    }
  
}
