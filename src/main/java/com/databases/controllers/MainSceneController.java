package com.databases.controllers;

import com.databases.dao.Data;
import com.databases.models.Team;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable {
    @FXML
    private TableView<Team> table;
    @FXML
    private TableColumn<Team,Integer> col1;
    @FXML
    private TableColumn<Team,String> col2;
    @FXML
    private TableColumn<Team,Integer> col3;
    @FXML
    private TextField idfield;
    @FXML
    private TextField namefield;
    @FXML
    private TextField amountfield;
    @FXML
    private Button button;

    Data data = new Data();

    public void getData(){
        col1.setCellValueFactory(new PropertyValueFactory<Team,Integer>("id"));
        col2.setCellValueFactory(new PropertyValueFactory<Team,String>("name"));
        col3.setCellValueFactory(new PropertyValueFactory<Team,Integer>("amount"));
    }
    public void addData(){
        Team team = new Team(Integer.parseInt(idfield.getText()),namefield.getText(),Integer.parseInt(amountfield.getText()));
        data.addData(team);
        idfield.clear();
        namefield.clear();
        amountfield.clear();
        table.getItems().add(team);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Values inserted Successfully");

        alert.showAndWait();
    }
    public void initialize(URL location, ResourceBundle resources) {
        getData();
        table.setItems(data.getAllData());
    }
}
