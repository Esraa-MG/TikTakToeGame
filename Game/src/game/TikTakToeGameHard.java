/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import game.model.Board;
import game.model.GameModel;
import game.model.Point;

/**
 *
 * @author Hamada Sabry
 */
public class TikTakToeGameHard extends Application {

    GameModel gm;
    GameUI gui;
    int game = 1;
    Board b;
    Point p;
    char ch;
    String result;

    boolean stopGame = false;
    ArrayList<Button> box;

    public void init() {

        b = new Board();
        gm = new GameModel();
    }

    @Override
    public void start(Stage stage) throws Exception {

        box = new ArrayList<>();
        gui = new GameUI();
        box.add(gui.button);
        box.add(gui.button0);
        box.add(gui.button1);
        box.add(gui.button2);
        box.add(gui.button3);
        box.add(gui.button4);
        box.add(gui.button5);
        box.add(gui.button6);
        box.add(gui.button7);

        Scene scene = new Scene(gui);
        

        
       ch='O';
       for(Button l:box){
           
           
          l.setOnAction((event) -> {
              if(l.getText()==""){
              if(game==1) {
             l.setText(new Character(ch).toString());
               
            int i=box.indexOf(l);
            int n1,n2;
            int x=0;
            int y=0;
            Point userMove=null;
            if(i==0){
             userMove = new Point(0,0);
             n1=0;
             n2=0;
              y = b.SetVal(userMove);
              x= b.CompMove2(y);
            }else if(i==1){
                userMove = new Point(0,1);
                 n1=0;
                 n2=1;
                  y = b.SetVal(userMove);
                  x= b.CompMove2(y);
            }else if(i==2){
                userMove = new Point(0,2);
                n1=0;
                 n2=2;
                  y = b.SetVal(userMove);
                 x= b.CompMove2(y);
            }
            else if(i==3){
                 userMove = new Point(1,0);
                 n1=1;
                 n2=0;
                  y = b.SetVal(userMove);
                 x= b.CompMove2(y);
            } else if(i==4){
                userMove = new Point(1,1);
                n1=1;
                 n2=1;
                  y = b.SetVal(userMove);
                  x= b.CompMove2(y);
            } 
            else if(i==5){
                userMove = new Point(1,2);
                n1=1;
                 n2=2;
                 y = b.SetVal(userMove);
                 x= b.CompMove2(y);
            }
            else if(i==6){
                 userMove = new Point(2,0);
                 n1=2;
                 n2=0;
                 y = b.SetVal(userMove);
                 x= b.CompMove2(y);
            }
            else if(i==7){
                  userMove = new Point(2,1);
                  n1=2;
                 n2=1;
                 y = b.SetVal(userMove);
                 x= b.CompMove2(y);
            }
            else if(i==8){
               
                  userMove = new Point(2,2);
                  n1=2;
                 n2=2;
                 y = b.SetVal(userMove);
                  x= b.CompMove2(y);
            }
            b.PlaceMove(userMove , Board.PLAYER_X);//for back end
            
           //  try {
            //          TimeUnit.SECONDS.sleep(1);        
             //     } catch (InterruptedException ex) {
             //         Logger.getLogger(TikTakToeGame3.class.getName()).log(Level.SEVERE, null, ex);
            //      }
            
           
            setSwitch2(x); 
                  
         
           if(b.hasPlayerWon(Board.PLAYER_O))
            {
                System.out.println("You Won");
                game=-10;
               
            }
           
            
        else if(b.hasPlayerWon(Board.PLAYER_X))
        {
            System.out.println("You Lost");
            game=-10;
            
        }
            
        else if(b.isGameOver())
        {
            System.out.println("Draw!");
            game=-10;
            
        }
              }
              }
        
           });
       
       }
         
        
       /* 
        ch = 'X';
        for (Button l : box) {

            l.setOnAction((event) -> {
                if (l.getText() == "") {
                    if (game == 1) {
                        l.setText(new Character(ch).toString());

                        int i = box.indexOf(l);
                        int n1, n2;
                        int x = 0;
                        int y=0;
                        Point userMove = null;
                        if (i == 0) {
                            userMove = new Point(0, 0);
                            n1 = 0;
                            n2 = 0;
                            y = b.SetVal(userMove);
                            x = b.CompMove2(y);
                        } else if (i == 1) {
                            userMove = new Point(0, 1);
                            n1 = 0;
                            n2 = 1;
                            y = b.SetVal(userMove);
                            x = b.CompMove2(y);
                        } else if (i == 2) {
                            userMove = new Point(0, 2);
                            n1 = 0;
                            n2 = 2;
                            y = b.SetVal(userMove);
                            x = b.CompMove2(y);
                        } else if (i == 3) {
                            userMove = new Point(1, 0);
                            n1 = 1;
                            n2 = 0;
                            y = b.SetVal(userMove);
                            x = b.CompMove2(y);
                        } else if (i == 4) {
                            userMove = new Point(1, 1);
                            n1 = 1;
                            n2 = 1;
                            y = b.SetVal(userMove);
                            x = b.CompMove2(y);
                        } else if (i == 5) {
                            userMove = new Point(1, 2);
                            n1 = 1;
                            n2 = 2;
                            y = b.SetVal(userMove);
                            x = b.CompMove2(y);
                        } else if (i == 6) {
                            userMove = new Point(2, 0);
                            n1 = 2;
                            n2 = 0;
                            y = b.SetVal(userMove);
                            x = b.CompMove2(y);
                        } else if (i == 7) {
                            userMove = new Point(2, 1);
                            n1 = 2;
                            n2 = 1;
                            y = b.SetVal(userMove);
                            x = b.CompMove2(y);
                        } else if (i == 8) {

                            userMove = new Point(2, 2);
                            n1 = 2;
                            n2 = 2;
                            y = b.SetVal(userMove);
                            x = b.CompMove2(y);
                        }
                        b.PlaceMove(userMove, Board.PLAYER_X);//for back end

                        //  try {
                        //          TimeUnit.SECONDS.sleep(1);        
                        //     } catch (InterruptedException ex) {
                        //         Logger.getLogger(TikTakToeGame3.class.getName()).log(Level.SEVERE, null, ex);
                        //      }
                        setSwitch(x);

                        if (b.hasPlayerWon(Board.PLAYER_X)) {
                            System.out.println("You lost");
                            game = -10;

                        } else if (b.hasPlayerWon(Board.PLAYER_O)) {
                            System.out.println("You Won");
                            game = -10;

                        } else if (b.isGameOver()) {
                            System.out.println("Draw!");
                            game = -10;

                        }
                    }
                }

            });

        }
        */

        gui.reset.setOnAction((event) -> {
            game = 1;
            Board.board = new int[3][3];
            b.displayBoard();
            gm.resetGame();
            stopGame = false;
            gui.button.setText("");
            gui.button0.setText("");
            gui.button1.setText("");
            gui.button2.setText("");
            gui.button3.setText("");
            gui.button4.setText("");
            gui.button5.setText("");
            gui.button6.setText("");
            gui.button7.setText("");
        });

        stage.setScene(scene);
        stage.show();
    }
    

    public static void main(String[] args) {
        launch(args);

    }
    
/*
    public int CompMove(int x, int y) {
        int z = 0;

        Point userMove = new Point(x, y);
        b.PlaceMove(userMove, Board.PLAYER_O);
        //System.out.println(b.SetVal(userMove));

        b.minimax(0, Board.PLAYER_X);
        System.out.println("computer choose position : " + b.computerMove);

        System.out.println(b.computerMove);
        b.PlaceMove(b.computerMove, Board.PLAYER_X);
        z = b.SetVal(b.computerMove);
        System.out.print(b.SetVal(b.computerMove));//to get the number of computer cell
        b.displayBoard();

        return z;
    }

    public int CompMove2(int x, int y) {
        int z = 0;

        Point userMove = new Point(x, y);
        b.PlaceMove(userMove, Board.PLAYER_O);
        //System.out.println(b.SetVal(userMove));

        b.minimax(0, Board.PLAYER_X);
        System.out.println("computer choose position : " + b.computerMove);

        System.out.println(b.computerMove);
        b.PlaceMove(b.computerMove, Board.PLAYER_X);
        z = b.SetVal(b.computerMove);
        System.out.print(b.SetVal(b.computerMove));//to get the number of computer cell
        b.displayBoard();

        return z;
    }
    
    */

    public void setSwitch(int x) {
        switch (x) {
            case 1:
                gui.button.setText("O");
                break;
            case 2:
                gui.button0.setText("O");
                break;
            case 3:
                gui.button1.setText("O");
                break;
            case 4:
                gui.button2.setText("O");
                break;
            case 5:
                gui.button3.setText("O");
                break;
            case 6:
                gui.button4.setText("O");
                break;
            case 7:
                gui.button5.setText("O");
                break;
            case 8:
                gui.button6.setText("O");
                break;
            case 9:
                gui.button7.setText("O");
                break;
        }
    }
    

    public void setSwitch2(int x) {
        switch (x) {
            case 1:
                gui.button.setText("X");
                break;
            case 2:
                gui.button0.setText("X");
                break;
            case 3:
                gui.button1.setText("X");
                break;
            case 4:
                gui.button2.setText("X");
                break;
            case 5:
                gui.button3.setText("X");
                break;
            case 6:
                gui.button4.setText("X");
                break;
            case 7:
                gui.button5.setText("X");
                break;
            case 8:
                gui.button6.setText("X");
                break;
            case 9:
                gui.button7.setText("X");
                break;
        }
    }

}
