package com.project.JavaSpringAssesment.service;

import com.project.JavaSpringAssesment.dto.GetTodoIds;
import com.project.JavaSpringAssesment.dto.IsitDoneRequest;
import com.project.JavaSpringAssesment.dto.PersonRequest;
import com.project.JavaSpringAssesment.dto.ToDoRequest;
import com.project.JavaSpringAssesment.entity.Person;
import com.project.JavaSpringAssesment.dto.ToDoDto;
import com.project.JavaSpringAssesment.entity.Todo;
import com.project.JavaSpringAssesment.repository.PersonRepo;
import com.project.JavaSpringAssesment.repository.TodoRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Service
public class PersonService {

    private final PersonRepo personRepo;

    private final TodoRepo todoRepo;

    private final ModelMapper modelMapper;

    public PersonService(PersonRepo personRepo, TodoRepo todoRepo, ModelMapper modelMapper) {
        this.personRepo = personRepo;
        this.todoRepo = todoRepo;
        this.modelMapper = modelMapper;
    }

    public PersonRequest savePerson(PersonRequest personRequest){
        if (personRepo.findByUsername(personRequest.getUsername()) != null){
            throw new EntityExistsException("This person already exists!");
        }else
        {
            Person person = modelMapper.map(personRequest, Person.class);
            personRepo.save(person);
            return personRequest;
        }
    }

    public List<ToDoDto> loginPerson(PersonRequest personRequest){
        Person person = personRepo.findByUsernameAndPassword(personRequest.getUsername(), personRequest.getPassword());
        if (person != null){
            List<Todo> todoList = person.getTodoList();
            List<ToDoDto> toDoDtoList = todoList.stream().map(todo -> modelMapper.map(todo, ToDoDto.class)).collect(Collectors.toList());
            return toDoDtoList;
        }else {
            throw new NoSuchElementException("Wrong username and password!");
        }
    }

    public void addTodo(String username, String password,ToDoRequest toDoRequest){

        Person person = personRepo.findByUsernameAndPassword(username, password);
        if(person != null){
            Todo todo = new Todo();
            todo.setTitle(toDoRequest.getTitle());
            todo.setPersonid(person.getId());
            person.getTodoList().add(todo);
            todoRepo.save(todo);
            personRepo.save(person);
        }else {
            throw new NoSuchElementException("Wrong username and password!");
        }

    }

    public void changeTodo(String username, String password, int todoindex,ToDoRequest toDoRequest){

        Person person = personRepo.findByUsernameAndPassword(username, password);
        if(person != null){
            Todo todo = person.getTodoList().get(todoindex);
            todo.setTitle(toDoRequest.getTitle());
            todoRepo.save(todo);
            personRepo.save(person);
        }else {
            throw new NoSuchElementException("Wrong username and password!");
        }
    }

    public void isitDone(String username, String password, int todoindex, IsitDoneRequest isitDoneRequest){

        Person person = personRepo.findByUsernameAndPassword(username, password);
        if(person != null){
            Todo todo = person.getTodoList().get(todoindex);
            todo.setDone(isitDoneRequest.isDone());
            todoRepo.save(todo);
            personRepo.save(person);
        }else {
            throw new NoSuchElementException("Wrong username and password!");
        }
    }

    public void deleteTodo(String username, String password, int todoindex){

        Person person = personRepo.findByUsernameAndPassword(username, password);

        if(person != null && person.getTodoList().get(todoindex) != null){

            Todo todo = person.getTodoList().get(todoindex);
            person.getTodoList().remove(todo);
            todoRepo.delete(todo);

        }else{
            throw new NoSuchElementException("Wrong username and password or this todo doesn't exists!");
        }
    }

    public void deleteAllTodos(String username, String password) {

        Person person = personRepo.findByUsernameAndPassword(username, password);

        if (person != null && person.getTodoList() != null) {

            List<Todo> todoList = person.getTodoList();
            GetTodoIds getTodoIds = new GetTodoIds();
            person.getTodoList().clear();
            todoRepo.deleteAllById(getTodoIds.getTurnedList(todoList));
            todoRepo.deleteTodos(person.getId());

        }
        else {
            throw new NoSuchElementException("Wrong username and password!");
        }
    }
}

