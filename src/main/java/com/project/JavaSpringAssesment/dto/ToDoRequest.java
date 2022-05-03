package com.project.JavaSpringAssesment.dto;


public class ToDoRequest {

    private String title;

    public ToDoRequest() {
    }

    public ToDoRequest(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
