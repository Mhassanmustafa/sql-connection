package com.databases.services;

import com.databases.config.Config;

import java.sql.*;
import java.util.HashMap;

public class SqlConnectionService {
    public static Connection getConnection() {
        String connectionString = String.format(
                "jdbc:sqlserver://%s:1433;"
                        + "database=%s;"
                        + "user=%s;"
                        + "password={%s};"
                , Config.DB_ADDRESS, Config.DB_NAME, Config.DB_USERNAME, Config.DB_PASSWORD);
        try {
            return DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static PreparedStatement prepareAStatement(Connection connection, String query, HashMap<Integer, Object> params) {

    /* TODO: if the same method executes multiple queries, we don't need to
    initialize all this stuff again, but i don't think we need these here since all of
    these operations could be done in just one query. some other time. */

        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            // insert parameters in the query;
            if (params != null) {
                params.forEach((key, value) -> {
                    try {
                        if (value instanceof Integer) {
                            // TODO: support for more datatype
                            preparedStatement.setInt(key, (Integer) value);
                        } else if (value instanceof String) {
                            preparedStatement.setString(key, (String) value);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                });
            }

            return preparedStatement;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
