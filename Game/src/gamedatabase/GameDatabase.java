/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedatabase;

import java.util.ArrayList;
import gameDB.GameArchive;
import gameDB.GameDao;
import gameDB.GameRecord;

/**
 *
 * @author Kirolos
 */
public class GameDatabase {

    public static void main(String[] args) {

        GameDao gameDao = new GameDao();

        //1 select all from table game archive 
        ArrayList<GameArchive> gameArchives = gameDao.selectAllGameArchive();
        System.out.println(gameArchives.get(0).getId());
        System.out.println(gameArchives.get(0).getDate());
        System.out.println(gameArchives.get(0).getPlayerX());
        System.out.println(gameArchives.get(0).getPlayerO());

        //2 insert into table archive with table gamemove
//        GameRecord gameRecord = new GameRecord();
//        gameRecord.addGameMove(9, 'X');
//        gameRecord.addGameMove(8, 'O');
//        gameRecord.addGameMove(7, 'X');
//        gameRecord.addGameMove(4, 'O');
//        gameRecord.addGameMove(5, 'X');
//        gameDao.insertGame("nameX", "nameO", gameRecord);

        //3 select from table gamemove idgame = 9 
        GameRecord gameRecord_2 = gameDao.selectGameRecord(6);
        System.out.println(gameRecord_2.getGameMove()[3].getCellOrder());
        System.out.println(gameRecord_2.getGameMove()[3].getCellNumber());
        System.out.println(gameRecord_2.getGameMove()[3].getCellType());
    }

}
