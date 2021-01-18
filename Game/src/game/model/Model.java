/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model;

import game.server.GameServer;

/**
 *
 * @author moutaz hegazy
 */
public class Model {
    
    private Player player;
    private GameServer server;
   

    
    //handling network mode
    // functions of network mode.    
    public void startNeworkGame(SETVIEW delegate,String ip)
    {
        player = new Player(delegate,ip);
    }
    
    public void setPlayerName(String name)
    {
        player.setPlayerName(name);
    }
    
    public String getPlayerMark()
    {
        if(player != null)
        {
            return player.getPlayerMark();
        }
        return "";
    }
    
    public void resetGame()
    {
        player.askResetGame();
    }
    
    public void markCell(int cellNumber)
    {
        if(player != null)
        {
            player.markCell(cellNumber);
        }
    }
    
    public String getHostIP()
    {
        return player.getIP();
    }
    
    // exit network
    public void exitNetworkMode()
    {
        if(player!=null)
        {
            player.exitNetwork();
        }
        player = null;
    }
    
    public void askResetGame()
    {
        if(player != null)
        {
            player.askResetGame();
        }
    }
    // end of network mode functions 
//------------------------------------------------------------------
    
    
    // server configuration methods.
    public void startServer()
    {
        server = new GameServer();
    }
    
    public void closeServer()
    {
        server.shutDown();
        server = null;
    }
 //-------------------------------------------------------------------
}

