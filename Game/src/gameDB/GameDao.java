/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameDB;

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
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return gameArchives;
    }

    public boolean insertGame(String playerX, String playerO, GameRecord gameRecord) {

        GameArchiveDao gameArchiveDao = new GameArchiveDao();
        GameArchive gameArchive = new GameArchive("mo3taz", "kirolos");
        GameMoveDao gameMoveDao = new GameMoveDao();
        try {
            int idGame = gameArchiveDao.insertGameArchive(gameArchive);
            gameRecord.setId(idGame);
            gameMoveDao.insertGameMove(gameRecord);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }

    public GameRecord selectGameRecord(int idGame) {

        GameMoveDao gameMoveDao = new GameMoveDao();
        GameRecord gameRecord = null;
        try {
            gameRecord = gameMoveDao.selectGameMove(idGame);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return gameRecord;
    }

}
