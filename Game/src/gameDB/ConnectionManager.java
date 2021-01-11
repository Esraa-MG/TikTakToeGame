/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Kirolos
 */

public class ConnectionManager {

    public Connection getConnection() throws SQLException , ClassNotFoundException {
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictactoe", "root", "root");
        
        return connection;
    }

    public void closeConnection(Statement statement, ResultSet resultSet, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
            resultSet = null;
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
            statement = null;
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
            connection = null;
        }
    }
}
