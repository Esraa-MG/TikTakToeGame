/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameDB;

import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Kirolos
 */

public class GameArchiveDao {

    public ArrayList<GameArchive> selectGameArchive() throws SQLException, ClassNotFoundException {

        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection();
        String sql = "select id, playerX, playerO, gameDateTime  from gamearchive;";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        ArrayList<GameArchive> gameArchives = null;
        
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            gameArchives = new ArrayList<>();
            while (resultSet.next()) {
                Timestamp timestamp = resultSet.getTimestamp("gameDateTime");
                DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy HH:mm:ss");
                String dateToString = dateFormat.format(timestamp);
                gameArchives.add(new GameArchive(resultSet.getInt("id"),
                        dateToString,
                        resultSet.getString("playerX"),
                        resultSet.getString("playerO")
                )
                );
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            connectionManager.closeConnection(preparedStatement, resultSet, connection);
        }
        
        return gameArchives;
    }

    public int insertGameArchive(GameArchive gameArchive) throws SQLException, ClassNotFoundException {

        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection();
        String sql = "insert into gamearchive (gameDateTime, playerX, playerO)"
                + " values(current_timestamp, ?, ?)";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, gameArchive.getPlayerX());
            preparedStatement.setString(2, gameArchive.getPlayerO());
            preparedStatement.executeUpdate();
            ResultSet ResultSet = preparedStatement.getGeneratedKeys();

            if (ResultSet.next()) {
                return (ResultSet.getInt(1));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            connectionManager.closeConnection(preparedStatement, resultSet, connection);
        }
        return 0;
    }

}

