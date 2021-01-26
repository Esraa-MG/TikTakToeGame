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
            this.isOn = true;
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
                    ex.printStackTrace();
                }
            }
            connected = 0;
            try {
                serverSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println("server down");
        }).start();
    }
    
    public void shutDown()
    {
        this.isOn = false;
        try{
            if(serverSocket != null)
            {
                serverSocket.close();
            }
            serverSocket = null;
            System.out.println("serverSocket out");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class PlayerSocket extends Thread
{
    private BufferedReader br;
    private PrintStream ps;
    
    private boolean reset;
    private String playerName;
    
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
            players.player1.send("getName1");
            players.player2.send("getName2");
            players.player2.isFirst = false;
            //players.player1.send("allowSave");
            System.out.println("player2 connected");
            players.player1.send("enterGame");
            players.player2.send("enterGame");
            send(mark);
            players.player1.send("startToken");
            players.player2.send("playSecond");
            start();
        }else{}
        if(players.player1 != null)
        {
            System.out.println("first Hand:"+players.player1.playerName);
        }
        if(players.player2 != null)
        System.out.println("second Hand:"+players.player2.playerName);
        
    }
    
    public void run()
    {
        while(alive)
        {
            try {
                String str = br.readLine();
                //System.out.println(str);
                if(str != null)
                {
                    checkMsg(str);
                }
                
            } catch (IOException ex) {
                System.out.println("client alive exception");
                ex.printStackTrace();
                break;
            } 
        }
        System.out.println(this.playerName+".client :<<<< out of while");
        if(players.player1 == this)
        {
            try {
                players.player1.br.close();
                players.player1.ps.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            players.player1 = null;
        }else{
            try {
                players.player2.br.close();
                players.player2.ps.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            players.player2 = null;
        }
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
            
            case "reqSave" :
                sendToAll("save");
                break;
            
            case "reset" :
                reset = true;
                if(players.player1.reset && players.player2.reset)
                {
                    players.player1.isFirst = !players.player1.isFirst;
                    players.player2.isFirst = !players.player2.isFirst;
                    if( players.player1.isFirst)
                    {
                        players.player1.mark = "X";
                        players.player2.mark = "O";   
                        players.player1.send("startToken");
                        players.player2.send("playSecond");
                    }else
                    {
                        players.player1.mark = "O";
                        players.player2.mark = "X";
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
               // if(players.player1 == this)
                //{
                players.player1.send("closeGame");
                players.player2.send("closeGame");
                players.player1.alive = false;
                players.player2.alive = false;
                //players.player1 = null;
                //players.player2 = null;
                System.out.println("server channel out");
                /*}else{
                    players.player2.send("closeGame");
                    this.alive = false;
                    players.player2 = null;
                }*/
                break;

                
            default:
                if(str.contains("Name1"))
                { 
                    players.player1.playerName = str.substring(6,str.length());
                    
                    sendToAll("Name:"+ players.player1.playerName);
                    
                }else if(str.contains("Name2"))
                {
                    players.player2.playerName = str.substring(6,str.length());
                    sendToAll("Name:"+ players.player2.playerName);
                }
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
