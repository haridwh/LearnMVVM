package com.skday.learnmvvm.model;

/**
 * Created by skday on 12/22/16.
 */

public class Task {
    private String title;
    private String detail;

    public Task(String title, String detail) {
        this.title = title;
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
