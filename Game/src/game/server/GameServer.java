/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moutaz hegazy
 */
public class GameServer {
        private ServerSocket serverSocket;
        private volatile boolean isOn = true;
        private volatile int connected = 0;
        
    
    public GameServer()
    {
        try {
            serverSocket = new ServerSocket(13135);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        new Thread(()->{
            System.out.println("server on");
            while(this.connected < 2 && this.isOn)
            {
                try {
                    Socket s = serverSocket.accept();
                    new PlayerSocket(s);
                    this.connected++;
                    System.out.println("ACCEPTED");
                
                } catch (IOException ex) {
                    Logger.getLogger(GameServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("server down");
        }).start();
    }
    
    public void shutDown()
    {
        this.isOn = false;
    }
}

class PlayerSocket extends Thread
{
    private BufferedReader br;
    private PrintStream ps;
    
    private boolean reset;
    
    private boolean isFirst;
    private String mark ;
    private volatile boolean alive = true;
    
    //static ArrayList<PlayerSocket> players = new ArrayList<PlayerSocket>();
    private static GameSockets players = new GameSockets();
    
    public PlayerSocket(Socket s)
    {
        
        try {
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            ps = new PrintStream(s.getOutputStream());
            
            
        } catch (IOException ex) {
            Logger.getLogger(PlayerSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(players.player1 == null)
        {
            players.player1 = this;
            players.player1.mark = "X";
            players.player1.isFirst = true;
            System.out.println("player1 connected");
            send(mark);
            start();
        }else if(players.player2 == null)
        {
            players.player2 = this;
            players.player2.mark = "O";
            players.player2.isFirst = false;
            System.out.println("player2 connected");
            send(mark);
            players.player1.send("startToken");
            start();
        }else{}
        
    }
    
    public void run()
    {
        while(alive)
        {
            try {
                String str = br.readLine();
                System.out.println(str);
                checkMsg(str);
                
            } catch (IOException ex) {
                Logger.getLogger(PlayerSocket.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        System.out.println("out of while");
    }
    
    private void checkMsg(String str)
    {
        switch (str)
        {
                
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                sendToAll(str+":"+mark);
                break;
                
            case "reset" :
                reset = true;
                if(players.player1.reset && players.player2.reset)
                {
                    players.player1.isFirst = !players.player1.isFirst;
                    players.player2.isFirst = !players.player2.isFirst;
                    if( players.player1.isFirst)
                    {
                        players.player1.send("startToken");
                        players.player2.send("playSecond");
                    }else
                    {
                        players.player2.send("startToken");
                        players.player1.send("playSecond");
                    }
                    sendToAll("doReset");
                    players.player1.reset = false;
                    players.player2.reset = false;
                }else if(players.player1.reset){
                    players.player2.send("askReset");
                }else{
                    players.player1.send("askReset");
                }
                break;
            
            case "closeChannel":
                if(players.player1 == this)
                {
                    players.player1.send("closeGame");
                    this.alive = false;
                    players.player1 = null;
                }else{
                    players.player2.send("closeGame");
                    this.alive = false;
                    players.player2 = null;
                }
                break;
                
            default:
                break;
        }
    }
    
    /*private synchronized void setPlayerWith(char ch)
    {
        if(allowChoice)
        {
            mark = ch;
        }
    }*/
    
    private void sendToAll(String str)
    {
        if(players.player1 != null)
        {
            players.player1.send(str);
        }
        if(players.player2 != null)
        {
            players.player2.send(str);
        }
    }
    
    private synchronized void send(String msg)
    {
        this.ps.println(msg);
    }
}

class GameSockets
{
    PlayerSocket player1;
    PlayerSocket player2;
}
