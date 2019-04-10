package com.databases.dao;

import com.databases.models.Team;
import com.databases.services.SqlConnectionService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Data implements Idata {
    public ObservableList<Team> getAllData() {
        Connection connection = SqlConnectionService.getConnection();
        ObservableList<Team> team = FXCollections.observableArrayList();


        Statement statement = null;
        String query = "SELECT * FROM table_1";
        try{
            PreparedStatement preparedStatement;
            preparedStatement = SqlConnectionService.prepareAStatement(connection, query, null);

            ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()) {
                    team.add(new Team(resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getInt(3)));
                }


        }catch (Exception exp){
            exp.printStackTrace();
        }finally {
            SqlConnectionService.closeConnection(connection);
        }
        return team;
    }

    @Override
    public void addData(Team team) {
        Connection connection =SqlConnectionService.getConnection();


        try{
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO table_1(id, name, rollno) "
                    + "VALUES( "+team.getId()+", '" + team.getName() + "',"+team.getAmount()
                    +")";
            int num = statement.executeUpdate(SQL);
            System.out.println(num + " Rows updated. ");
        }catch (Exception exp){
            exp.printStackTrace();
        }finally {
            SqlConnectionService.closeConnection(connection);
        }
    }
}
