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
    private boolean connectionStatus;
   

    
    //handling network mode
    // functions of network mode.    
    public void startNeworkGame(SETVIEW delegate)
    {
        player = new Player(delegate);
         
    }
    
    public String getPlayerName()
    {
        if (connectionStatus)
        {
            return player.getPlayerName();
        }
        else
        {
            return " ";
        }
    }
    
    public String getOponentName()
    {
        if (connectionStatus)
        {
            return player.getOponentName();
        }
        else
        {
            return " ";
        }
    }
    
    public boolean connectToIP(String ip)
    {
        connectionStatus = player.connectToIP(ip);
        return connectionStatus;  
    }
    
    public void openChannel()
    {
        if(connectionStatus)
        {
            player.fireThread();
        }
    }
    
    public void allowClientToSave()
    {
        if(player != null)
        {
            player.allowSave();
        }
    }
    
    public void disableSave()
    {
        if(connectionStatus)
        {
            player.disableSave();
        }
    }
    
    public void setPlayerName(String name)
    {
        player.setPlayerName(name);
    }
    
    public void closeSocket()
    {
        if(connectionStatus)
        {
            player.exitNetwork();
            player.closeSocket();
        }
            
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
        if(connectionStatus)
        {
            player.exitNetwork();
        }
        connectionStatus = false;
        player = null;
    }
    
    public boolean isNetworkOn()
    {
        if(player != null)
        {
            return true;
        }else
        {
            return false;
        }
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
        if(server != null)
        {
            server.shutDown();
            System.out.println("trying to shut server down");
        }
        server = null;
    }
 //-------------------------------------------------------------------
}

