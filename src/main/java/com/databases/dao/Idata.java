package com.databases.dao;

import com.databases.models.Team;
import javafx.collections.ObservableList;

public interface Idata {
    public ObservableList<Team> getAllData();
    public void addData(Team team);
}
