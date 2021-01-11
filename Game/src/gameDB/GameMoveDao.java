/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Kirolos
 */

public class GameMoveDao {

    public GameRecord selectGameMove(int idGame) throws SQLException, ClassNotFoundException {

        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection();
        String sql = "select * from gamemove where idGame = ? ;";
        PreparedStatement statement = null;
        ResultSet resultset = null;
        GameRecord gameRecord = null;

        try {
            gameRecord = new GameRecord(idGame);
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idGame);
            resultset = statement.executeQuery();
            while (resultset.next()) {

                gameRecord.addGameMove(
                        new GameMove(
                                resultset.getInt("cellNumber"),
                                resultset.getInt("cellOrder"),
                                resultset.getString("cellType").toCharArray()[0]));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            connectionManager.closeConnection(statement, resultset, connection);
        }

        return gameRecord;
    }

    public void insertGameMove(GameRecord gameRecord) throws SQLException, ClassNotFoundException {

        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection();
        connection.setAutoCommit(false);
        String sql = "insert into gamemove(idGame,cellOrder,cellNumber,cellType) values(?,?,?,?)";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < gameRecord.getI(); i++) {
                preparedStatement.setInt(1, gameRecord.getId());
                preparedStatement.setInt(2, gameRecord.getGameMove()[i].getCellOrder());
                preparedStatement.setInt(3, gameRecord.getGameMove()[i].getCellNumber());
                preparedStatement.setString(4, String.valueOf(gameRecord.getGameMove()[i].getCellType()));
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();
            connection.commit();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            connectionManager.closeConnection(preparedStatement, resultSet, connection);
        }
    }

}
