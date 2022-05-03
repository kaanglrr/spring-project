package com.project.JavaSpringAssesment.repository;

import com.project.JavaSpringAssesment.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Long> {

    Person findByUsernameAndPassword(String username, String password);

    Person findByUsername(String username);

}
