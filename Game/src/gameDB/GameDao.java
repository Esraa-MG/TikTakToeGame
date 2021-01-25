/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameDB;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kirolos
 */
public class GameDao {

    public ArrayList<GameArchive> selectAllGameArchive() {

        GameArchiveDao gameArchiveDao = new GameArchiveDao();
        ArrayList<GameArchive> gameArchives = null;
        try {
            gameArchives = gameArchiveDao.selectGameArchive();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
        return gameArchives;
    }

    public void insertGame(String playerX, String playerO, GameRecord gameRecord)
            throws SQLException, ClassNotFoundException {

        GameArchiveDao gameArchiveDao = new GameArchiveDao();
        GameArchive gameArchive = new GameArchive(playerX, playerO);
        GameMoveDao gameMoveDao = new GameMoveDao();

        int idGame = gameArchiveDao.insertGameArchive(gameArchive);
        gameRecord.setId(idGame);
        gameMoveDao.insertGameMove(gameRecord);
    }

    public GameRecord selectGameRecord(int idGame) {

        GameMoveDao gameMoveDao = new GameMoveDao();
        GameRecord gameRecord = null;
        try {
            gameRecord = gameMoveDao.selectGameMove(idGame);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
        return gameRecord;
    }

}
