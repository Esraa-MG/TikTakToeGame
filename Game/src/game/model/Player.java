/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model;

import gameDB.GameDao;
import gameDB.GameRecord;
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
    
    private String playerName;
    
    private Socket pSocket;
    private BufferedReader br;
    private boolean gameOn;
    private GameModel model;
    private PrintStream ps;
    private Thread th; 
    private SETVIEW delegate;
    private final String tryPattern = "[1-9]:[XO]";
    private Pattern prn = Pattern.compile(tryPattern);
    private boolean inTurn;
    private boolean allowSave;
    private String opName;
 
    private GameRecord gameRec;
    private GameDao gameDao;
                        
    
    public Player(SETVIEW set)
    {
        gameOn = true;
        delegate = set;
        model = new GameModel();
    }
    
    
    public boolean connectToIP(String ip)
    {
        try {
            pSocket = new Socket(ip,13135);
            System.out.println(ip);
            ps = new PrintStream(pSocket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(pSocket.getInputStream()));
            this.fireThread();
            return true;
            
        } catch (IOException ex) {
            System.out.println("IN THE CATCH");
            br = null;
            ps = null;
            //pSocket.close();
            pSocket = null;
            return false;
            //ex.printStackTrace();
        }
    }
    
    
    public void closeSocket()
    {
        br = null;
        ps = null;
        try {
            pSocket.close();
            pSocket = null;
            System.out.println("socket closed");
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fireThread()
    {
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
                                if(allowSave)
                                {
                                    gameRec.addGameMove(c.i, c.ch);
                                }
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
                                pSocket.close();
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
                             
                            case "getName1"    :
                                sendMsg("Name1:"+playerName);
                                break;
                            case "getName2"    :
                                sendMsg("Name2:"+playerName);
                                break;   
                            
                            case "allowSave"    :
                                //allowSave = true;
                                break;
                                
                            case "save"    :
                                if(allowSave)
                                {
                                    //saving logic.
                                    if(playMark == "X")
                                    {
                                        gameDao.insertGame(playerName,opName , gameRec);
                                    }else{
                                        gameDao.insertGame(opName,playerName , gameRec);
                                    }    
                                }
                                break;
                                
                            case "enterGame" :
                                Platform.runLater(()->{
                                    delegate.enterGame();
                                });
                                System.out.println(playerName + ": should enter");
                                break;
                                
                            default : 
                                if(msg.contains("Name"))
                                {
                                    String name = msg.substring(5,msg.length());
                                    //System.out.println("opName: "+ name + "plyaerName" + playerName);
                                    if(!name.equalsIgnoreCase(playerName))
                                    {
                                        opName = name;
                                        System.out.println("opName: "+ opName);
                                    }
                                }
                                break;
                        }
                    }
                    
                } catch (IOException ex) {
                    //Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    break;
                }
            }
            System.out.println(playerName+".player : out of while");
        });
       th.start();
    }
    
    public void allowSave()
    {
        allowSave = true;
        gameRec = new GameRecord();
        gameDao = new GameDao();
    }
    
    public void disableSave()
    {
        allowSave = false;
        gameRec = null;
        gameDao = null;
    }
    
    public String getOponentName()
    {
        return opName;
    }
    
    public void setPlayerName(String str)
    {
        playerName = str;
        System.out.println("NAME :"+this.playerName);
    }
    
    public String getPlayerName()
    {
        return playerName ;
    }
    // cell : int from(1-9) marks the cell number pressed on ui.
    public void markCell(int cell)
    {
        if(cell>0 && cell<10 && inTurn)
        {
            sendMsg(new Integer(cell).toString());
        }
    }
    
    public void requestSave()
    {
        sendMsg("reqSave");
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
                    Platform.runLater(() -> {
                        delegate.runWinnigAnimation();
                    });
                    System.out.println("I Win");
                }else{
                    Platform.runLater(() -> {
                        delegate.runLosingAnimation();
                    });
                    System.out.println("I Lose");
                }
                break;
            case "Owin" :
                gameOn = false;
                if(playMark == "O")
                {
                    Platform.runLater(() -> {
                        delegate.runWinnigAnimation();
                    });
                    System.out.println("I Win");
                }else{
                    Platform.runLater(() -> {
                        delegate.runLosingAnimation();
                    });
                    System.out.println("I Lose");
                }
                break;
            case "draw" :
                Platform.runLater(() -> {
                        delegate.runDrawAnimation();
                    });
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

