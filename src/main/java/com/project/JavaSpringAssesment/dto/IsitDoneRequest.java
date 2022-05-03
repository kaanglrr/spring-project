package com.project.JavaSpringAssesment.dto;

public class IsitDoneRequest {

    private boolean done;

    public IsitDoneRequest() {
    }

    public IsitDoneRequest(boolean done) {
        this.done = done;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
