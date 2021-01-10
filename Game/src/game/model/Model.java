/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model;

/**
 *
 * @author moutaz hegazy
 */
public class Model {
    
    Player player;

    
    //handling network mode
    // functions of network mode.    
    public void startNeworkGame(SETVIEW delegate)
    {
        player = new Player(delegate);
    }
    
    public String getPlayerMark()
    {
        if(player != null)
        {
            return player.getPlayerMark();
        }
        return "";
    }
    
    public void markCell(int cellNumber)
    {
        if(player != null)
        {
            player.markCell(cellNumber);
        }
    }
    
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
}

// end of network mode functions 
//------------------------------------------------------------------
