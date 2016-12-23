package com.skday.learnmvvm.dao;

import com.skday.learnmvvm.model.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skday on 12/23/16.
 */

public class DaoTask {
    private List<Task> listTask;

    public List<Task> getListTask() {
        return listTask;
    }

    public void setListTask(List<Task> listTask) {
        this.listTask = listTask;
    }
}
