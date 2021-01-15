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
/*public class TikGameServer{
    
    ServerSocket serverSocket;
    
    public TikGameServer()
    {
        try {
            serverSocket = new ServerSocket(13135);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        while(true)
        {
            try {
                Socket s = serverSocket.accept();
                new PlayerSocket(s);
                System.out.println("ACCEPTED");
                
            } catch (IOException ex) {
                Logger.getLogger(TikGameServer.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    }

    public static void main(String[] args) {
        new TikGameServer();
    }
    
}


class PlayerSocket extends Thread
{
    BufferedReader br;
    PrintStream ps;
    
    boolean reset;
    
    boolean allowChoice = true;
    String mark ;
    boolean alive = true;
    
    //static ArrayList<PlayerSocket> players = new ArrayList<PlayerSocket>();
    static GameSockets players = new GameSockets();
    
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
            System.out.println("player1 connected");
            send(mark);
            start();
        }else if(players.player2 == null)
        {
            players.player2 = this;
            players.player2.mark = "O";
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
                //sendToAll(str);
                
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
            case "setX":
                //setPlayerWith('x');
                break;
                
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
    
    private synchronized void setPlayerWith(char ch)
    {
        if(allowChoice)
        {
            mark = ch;
        }
    }
    
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
}*/

