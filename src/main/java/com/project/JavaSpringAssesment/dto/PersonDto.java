package com.project.JavaSpringAssesment.dto;


import java.util.List;

public class PersonDto {

    private String username;

    private List<ToDoDto> toDoDtoList;

    public PersonDto() {
    }

    public PersonDto(String username, List<ToDoDto> toDoDtoList) {
        this.username = username;
        this.toDoDtoList = toDoDtoList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<ToDoDto> getToDoDtoList() {
        return toDoDtoList;
    }

    public void setToDoDtoList(List<ToDoDto> toDoDtoList) {
        this.toDoDtoList = toDoDtoList;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "username='" + username + '\'' +
                ", toDoDtoList=" + toDoDtoList +
                '}';
    }
}
