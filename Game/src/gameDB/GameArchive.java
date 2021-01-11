/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameDB;

/**
 *
 * @author Kirolos
 */
public class GameArchive {

    private int id;
    private String date;
    private String playerX;
    private String playerO;

    public GameArchive(int id, String date, String playerX, String playerO) {
        this.id = id;
        this.date = date;
        this.playerX = playerX;
        this.playerO = playerO;
    }
    
    public GameArchive(String playerX, String playerO) {
        this.playerX = playerX;
        this.playerO = playerO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public String getPlayerX() {
        return playerX;
    }

    public void setPlayerX(String playerX) {
        this.playerX = playerX;
    }

    public String getPlayerO() {
        return playerO;
    }

    public void setPlayerO(String playerO) {
        this.playerO = playerO;
    }

}
