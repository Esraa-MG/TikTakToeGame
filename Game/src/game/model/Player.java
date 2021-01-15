/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Platform;




/**
 *
 * @author moutaz hegazy
 */
public class Player {
    
    private String playMark;
    
    private Socket pSocket;
    private BufferedReader br;
    private boolean gameOn;
    private GameModel model;
    private PrintStream ps;
    private Thread th; 
    private SETVIEW delegate;
    private String tryPattern = "[1-9]:[XO]";
    private Pattern prn = Pattern.compile(tryPattern);
    private boolean inTurn;
                        
    
    public Player(SETVIEW set)
    {
        gameOn = true;
        delegate = set;
        try {
            pSocket = new Socket("127.0.0.1",13135);
            ps = new PrintStream(pSocket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(pSocket.getInputStream()));
            model = new GameModel();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
       th = new Thread(()->{
           boolean thContinue = true;
            while(thContinue)
            {
                try {
                    String msg = br.readLine();
                    //System.out.println(msg);
                    Matcher match = prn.matcher(msg);
                    if(match.matches())
                    {
                        if(gameOn)
                        {
                            Components c = parseString(msg);
                            System.out.println(c.i+ ":"+ c.ch);
                            String ret = model.selectCell(c.i, c.ch);  
                            if(ret != "isMarked")
                            {
                                Platform.runLater(()->{
                                    delegate.setView(c.i, c.ch);
                                });
                                inTurn = !inTurn;
                                checkGame(ret);
                            }
                        }
                    }else{
                        switch(msg)
                        {
                            case "askReset" :
                                sendMsg("reset");
                                break;
                            case "doReset" :
                                doResetGame();
                                break;
                            case "closeGame" :
                                thContinue = false;
                                br = null;
                                ps = null;
                                pSocket = null;
                                break;
                            case "startToken" :
                                inTurn = true;
                                playMark = "X";
                                break;
                                
                            case "playSecond" :
                                inTurn = false;
                                playMark = "O";
                                break;    
                                
                            default : 
                                break;
                        }
                    }
                    
                } catch (IOException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("out of while");
        });
       th.start();
    }
    
    // cell : int from(1-9) marks the cell number pressed on ui.
    public void markCell(int cell)
    {
        if(cell>0 && cell<10 && inTurn)
        {
            sendMsg(new Integer(cell).toString());
        }
    }
    
    public void askResetGame()
    {
        sendMsg("reset");
    }
    
    public void exitNetwork()
    {
        sendMsg("closeChannel");
        
    }
    
    private void doResetGame()
    {
        model.resetGame();
        Platform.runLater(()->{
            delegate.resetScreen();
        });
        gameOn = true;
    }
    private void sendMsg(String msg)
    {
        ps.println(msg);
    }
    
    private void checkGame(String str)
    {
        switch(str)
        {
            case "none" :
                break;
            case "Xwin" :
                gameOn = false;
                if(playMark == "X")
                {
                    System.out.println("I Win");
                }else{
                    System.out.println("I Lose");
                }
                break;
            case "Owin" :
                gameOn = false;
                if(playMark == "O")
                {
                    System.out.println("I Win");
                }else{
                    System.out.println("I Lose");
                }
                break;
            case "draw" :
                gameOn = false;
                break;
            default:
                break;
        }
    }
    
    public String getIP()
    {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "notFound";
    }
    
    private Components parseString(String str)
    {
        Components c = new Components();
        char arr[] = str.toCharArray();
        c.i = arr[0] - 48;
        c.ch = arr[2];
        return c;
    }
    
    public String getPlayerMark()
    {
        return playMark;
    }
    
    private class Components
    {
        int i;
        char ch;
    }
}

