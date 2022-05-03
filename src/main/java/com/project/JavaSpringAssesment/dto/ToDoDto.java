package com.project.JavaSpringAssesment.dto;

public class ToDoDto {

    private String title;

    private boolean done;

    public ToDoDto() {
    }

    public ToDoDto(String title, boolean done) {
        this.title = title;
        this.done = done;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "ToDoDto{" +
                "title='" + title + '\'' +
                ", done=" + done +
                '}';
    }
}
