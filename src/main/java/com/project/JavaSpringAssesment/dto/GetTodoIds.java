package com.project.JavaSpringAssesment.dto;

import com.project.JavaSpringAssesment.entity.Todo;

import java.util.ArrayList;
import java.util.List;

public class GetTodoIds {

    private List<Long> longList = new ArrayList<>();

    public GetTodoIds() {
    }

    public GetTodoIds(List<Long> longList) {
        this.longList = longList;
    }

    public List<Long> getLongList() {
        return longList;
    }

    public void setLongList(List<Long> longList) {
        this.longList = longList;
    }

    public List<Long> getTurnedList(List<Todo> todoList){
        int i;
        for (i = 0; i < todoList.size()-1 ; i++){
            longList.add(todoList.get(i).getId());
        }
        return this.longList;
    }
}
