package com.example.vish.mvvmtest.service.model;

import java.util.List;

public class Result {
    public List<Details> rows;
    public String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Details> getRows() {
        return rows;
    }

}
