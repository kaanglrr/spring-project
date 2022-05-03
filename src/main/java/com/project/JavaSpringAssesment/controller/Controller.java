package com.project.JavaSpringAssesment.controller;

import com.project.JavaSpringAssesment.dto.IsitDoneRequest;
import com.project.JavaSpringAssesment.dto.PersonRequest;
import com.project.JavaSpringAssesment.dto.ToDoRequest;
import com.project.JavaSpringAssesment.dto.ToDoDto;
import com.project.JavaSpringAssesment.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/")
public class Controller {

    private final PersonService personService;

    public Controller(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(value = "/register")
    public PersonRequest save(@RequestBody PersonRequest personRequest) {
        return personService.savePerson(personRequest);
    }

    @PostMapping(value = "/login")
    public List<ToDoDto> login(@RequestBody PersonRequest personRequest) {
        return personService.loginPerson(personRequest);
    }

    @PostMapping(value = "/login/{username}/{password}/addtodo")
    public void addTodo(@PathVariable String username, @PathVariable String password, @RequestBody ToDoRequest toDoRequest) {
        personService.addTodo(username, password, toDoRequest);
    }

    @PutMapping(value = "/login/{username}/{password}/{todoindex}/changetodo")
    public void updateTodo(@PathVariable String username, @PathVariable String password, @PathVariable int todoindex, @RequestBody ToDoRequest toDoRequest) {
        personService.changeTodo(username, password, todoindex, toDoRequest);
    }

    @PutMapping(value = "/login/{username}/{password}/{todoindex}/changetodo/isitdone")
    public void updateDoneTodo(@PathVariable String username, @PathVariable String password, @PathVariable int todoindex, @RequestBody IsitDoneRequest isitDoneRequest) {
        personService.isitDone(username, password, todoindex, isitDoneRequest);
    }

    @DeleteMapping(value = "/login/{username}/{password}/deletetodo/{todoindex}")
    void delete(@PathVariable String username, @PathVariable String password, @PathVariable int todoindex) {
        personService.deleteTodo(username, password, todoindex);
    }

    @DeleteMapping(value = "/login/{username}/{password}/deletealltodo")
    void deleteAll(@PathVariable String username, @PathVariable String password) {
        personService.deleteAllTodos(username, password);
    }
}
