/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;



import game.model.GameModel;
import game.model.Model;
import game.model.SETVIEW;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ESRAA
 */
public class Game extends Application implements SETVIEW{
    
    StartUI StrUi;
    SecondPage ScndUi;
    Page3UI Page3Ui;
    GameControl3 GameCon3;
    ConnectNetwork ConnNet;
    Model mod;
    GameUI networkGame;
    private String localIP = "127.0.0.1";

    
    
 
    String[] playersArr;

    
    GameUI GameUi;

    boolean stopGame = false;
    String result;
    
    int mode = 0;
    
    public void init()
    {
        mod = new Model();
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        networkGame = new GameUI();
        StrUi = new StartUI();
        ScndUi = new SecondPage();
        Page3Ui = new Page3UI();
        ConnNet = new ConnectNetwork();
        GameCon3 = new GameControl3();
        
        GameUi = new GameUI();
        
        
        
        playersArr = new String[2];
        playersArr[0] = new String("Player1");
        playersArr[1] = new String("Player2");
        
        
        
        Scene start = new Scene(StrUi);
        Scene second = new Scene(ScndUi);
        Scene third = new Scene(Page3Ui);
        Scene thirdOnline = new Scene(ConnNet);
        Scene Game = new Scene(GameCon3.GameUi);
        
        
        
       
        
        if(mode ==1)
        {
            stage.setScene(Game);
        }else{
            stage.setScene(start);
        }
        
        ConnNet.button0.setOnAction(((event) -> {
           
              mod.startServer();
              mod.startNeworkGame(this, localIP);
              mod.setPlayerName(ConnNet.textField.getText());
              ConnNet.label0.setText(mod.getHostIP());
              ConnNet.button0.setDisable(true);
              //stage.setScene(Game);
              
          
        }));
        
        ConnNet.button1.setOnAction(((event) -> {
           
              
              mod.startNeworkGame(this, ConnNet.textField0.getText());
              mod.setPlayerName(ConnNet.textField.getText());
              ConnNet.button0.setDisable(true);
               //stage.setScene(Game);
          
        }));
        
        ConnNet.enterButton.setOnAction((event)->{
            
            Scene ntScene = new Scene(networkGame);
            stage.setScene(ntScene);
        });
       
        networkGame.button.setOnAction(((event) -> {  
              mod.markCell(1);
        }));
        networkGame.button0.setOnAction(((event) -> {  
              mod.markCell(2);
        }));
        networkGame.button1.setOnAction(((event) -> {  
              mod.markCell(3);
        }));
        networkGame.button2.setOnAction(((event) -> {  
              mod.markCell(4);
        }));
        networkGame.button3.setOnAction(((event) -> {  
              mod.markCell(5);
        }));
        networkGame.button4.setOnAction(((event) -> {  
              mod.markCell(6);
        }));
        networkGame.button5.setOnAction(((event) -> {  
              mod.markCell(7);
        }));
        networkGame.button6.setOnAction(((event) -> {  
              mod.markCell(8);
        }));
        networkGame.button7.setOnAction(((event) -> {  
              mod.markCell(9);
        }));
        networkGame.reset.setOnAction((value)->{
            mod.resetGame();
        });
        
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
                    stage.setScene(thirdOnline);
     
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
        
        
        //online page control
        
    
        /*ConnNet.button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                
                   playersArr[0] = Page3Ui.player1.getText();
                   playersArr[1] = Page3Ui.player2.getText();
             
                    stage.setScene(Game);
                
                
            }
        });*/
        
        
        
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
        //Model model = new Model();
        //model.startServer();
        
    }

    @Override
    public void setView(int at, char mark) {
        String tryMark = new Character(mark).toString();
        switch (at)
        {
            case 1:
                networkGame.button.setText(tryMark);
                break;
            
            case 2:
                networkGame.button0.setText(tryMark);
                break;
            case 3:
                networkGame.button1.setText(tryMark);
                break;
            case 4:
                networkGame.button2.setText(tryMark);
                break;
            case 5:
                networkGame.button3.setText(tryMark);
                break;
             case 6:
                networkGame.button4.setText(tryMark);
                break;
            case 7:
                networkGame.button5.setText(tryMark);
                break;
            case 8:
                networkGame.button6.setText(tryMark);
                break;
            case 9:
                networkGame.button7.setText(tryMark);
                break;  
            default:break;
        }
    }

    @Override
    public void resetScreen() {
        networkGame.button.setText(" ");
        networkGame.button0.setText(" ");
        networkGame.button1.setText(" ");
        networkGame.button2.setText(" ");
        networkGame.button3.setText(" ");
        networkGame.button4.setText(" ");
        networkGame.button5.setText(" ");
        networkGame.button6.setText(" ");
        networkGame.button7.setText(" ");  
    }
    
    @Override
    public void enterGame()
    {
        
        ConnNet.enterButton.setDisable(false);
          
    }
  
}
