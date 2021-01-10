/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.model.GameModel;
import javafx.scene.control.Button;

/**
 *
 * @author ESRAA
 */
public class GameControl3 {

    public GameControl3( ) {
       scoreArr[0] = 0;
       scoreArr[1] = 0;
        
       SymbolArr[0] = 'X';
       SymbolArr[1] = 'O';
    }
    
    GameUI GameUi = new GameUI();
    GameModel GameMod = new GameModel();
     
    char symbol;
    boolean stopGame = false;
    String result;
     
    int[] scoreArr = new int[2];
    char[] SymbolArr = new char[2];
    
    Button [] buttonArr = {GameUi.button,GameUi.button0,GameUi.button1,GameUi.button2,GameUi.button3,GameUi.button4,GameUi.button5,GameUi.button6,GameUi.button7};

    int[] buttonPressed = {0,0,0,0,0,0,0,0,0};
        
    
    void controlGame()
    {
        symbol = 'X';
    
        GameUi.button.setOnAction(((event) -> {
           if (buttonPressed[0] == 0)
           {
               if(!stopGame)
                {
                    GameUi.button.setText(new Character(symbol).toString());
                    result = GameMod.selectCell(1, symbol);
                    System.out.println(result);
                    if(result == "Xwin" || result == "Owin" || result == "draw")
                    {
                        showScore();
                        stopGame = true;
                    }
                    changeSymbol();
                }
           }
            
            buttonPressed[0] = 1;
        }));
        
        GameUi.button0.setOnAction((event)->{
            if (buttonPressed[1] == 0)
            {
                if(!stopGame)
                {
                    GameUi.button0.setText(new Character(symbol).toString());
                    result = GameMod.selectCell(2, symbol);
                    System.out.println(result);
                    GameMod.printGame();
                    if(result == "Xwin" || result == "Owin" || result == "draw")
                    {
                        showScore();
                        stopGame = true;
                    }
                    changeSymbol();
                }
            }
            buttonPressed[1] = 1;
        });
        
        GameUi.button1.setOnAction((event)->{
            if (buttonPressed[2] == 0)
            {
                if(!stopGame)
                {
                    GameUi.button1.setText(new Character(symbol).toString());
                    result = GameMod.selectCell(3, symbol);
                    System.out.println(result);
                    GameMod.printGame();
                    if(result == "Xwin" || result == "Owin" || result == "draw")
                    {
                        showScore();
                        stopGame = true;
                    }
                    changeSymbol();
                }
            }
            buttonPressed[2] = 1;
        });
        
        GameUi.button2.setOnAction((event)->{
            if (buttonPressed[3] == 0)
            {
                if(!stopGame)
                {
                    GameUi.button2.setText(new Character(symbol).toString());
                    result = GameMod.selectCell(4, symbol);
                    System.out.println(result);
                    GameMod.printGame();
                    if(result == "Xwin" || result == "Owin" || result == "draw")
                    {
                        showScore();
                        stopGame = true;
                    }
                    changeSymbol();
                }
            }
            buttonPressed[3] = 1;
        });
        
        GameUi.button3.setOnAction((event)->{
            if (buttonPressed[4] == 0)
            {
                if(!stopGame)
                {
                    GameUi.button3.setText(new Character(symbol).toString());
                    result = GameMod.selectCell(5, symbol);
                    System.out.println(result);
                    GameMod.printGame();
                    if(result == "Xwin" || result == "Owin" || result == "draw")
                    {
                        showScore();
                        stopGame = true;
                    }
                    changeSymbol();
                }
            }
            buttonPressed[4] = 1;
        });
        
        GameUi.button4.setOnAction((event)->{
            if (buttonPressed[5] == 0)
            {
                if(!stopGame)
                {
                    GameUi.button4.setText(new Character(symbol).toString());
                    result = GameMod.selectCell(6, symbol);
                    System.out.println(result);
                    GameMod.printGame();
                    if(result == "Xwin" || result == "Owin" || result == "draw")
                    {
                        showScore();
                        stopGame = true;
                    }
                    changeSymbol();
                }
            }
            buttonPressed[5] = 1;
         });
        
        GameUi.button5.setOnAction((event)->{
            if (buttonPressed[6] == 0)
            {
                if(!stopGame)
                {
                    GameUi.button5.setText(new Character(symbol).toString());
                    result = GameMod.selectCell(7, symbol);
                    System.out.println(result);
                    GameMod.printGame();
                    if(result == "Xwin" || result == "Owin" || result == "draw")
                    {
                        showScore();
                        stopGame = true;
                    }
                    changeSymbol();
                }
            }
            buttonPressed[6] = 1;
        });
        
        GameUi.button6.setOnAction((event)->{
            if (buttonPressed[7] == 0)
            {
                if(!stopGame)
                {
                    GameUi.button6.setText(new Character(symbol).toString());
                    result = GameMod.selectCell(8, symbol);
                    System.out.println(result);
                    GameMod.printGame();
                    if(result == "Xwin" || result == "Owin" || result == "draw")
                    {
                        showScore();
                        stopGame = true;
                    }
                    changeSymbol();
                }
            }
            buttonPressed[7] = 1;
        });
        
        GameUi.button7.setOnAction((event)->{
            if (buttonPressed[8] == 0)
            {
                if(!stopGame)
                {
                    GameUi.button7.setText(new Character(symbol).toString());
                    result = GameMod.selectCell(9, symbol);
                    System.out.println(result);
                    GameMod.printGame();
                    if(result == "Xwin" || result == "Owin" || result == "draw")
                    {  
                        showScore();
                        stopGame = true;
                    }
                    changeSymbol();
                }
            }
            buttonPressed[8] = 1;
        });
        
        
       
        //restart control
        GameUi.reset.setOnAction((event)->{
               GameMod.resetGame();
               stopGame = false;
               symbol ='X';
              for (int i =0; i<9; i++)
               {
                   buttonArr[i].setText(" ");
               }
              for (int i =0; i<9; i++)
              {
                buttonPressed[i] = 0;
              }
         });
    }
    
    public void Reset()
    {
        for (int i =0; i<9; i++)
        {
            buttonArr[i].setText(" ");
        }
        for (int i =0; i<9; i++)
        {
          buttonPressed[i] = 0;
        }
        
    }
    
    
    
    public void changeSymbol()
    {
        if(symbol == 'X')
            {
                symbol ='O';
            }else{
                symbol = 'X';
            }
    }
    
    
     public void showScore() {
        
        if (result == "Xwin")
        {    
            for (int i=0; i<2; i++)
            {
                if( SymbolArr[i] =='X')
                {
                    scoreArr[i] ++;
                    GameUi.label0.setText(String.valueOf(scoreArr[0]));
                    GameUi.label2.setText(String.valueOf(scoreArr[1]));
                }
            }
        }
        else if (result == "Owin")
        {
            for (int i=0; i<2; i++)
            {
                if( SymbolArr[i] =='O')
                {
                    scoreArr[i] ++;
                    GameUi.label0.setText(String.valueOf(scoreArr[0]));
                    GameUi.label2.setText(String.valueOf(scoreArr[1]));
                }
            }
        }
    }
    
}
