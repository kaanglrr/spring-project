package com.project.JavaSpringAssesment.repository;

import com.project.JavaSpringAssesment.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


public interface TodoRepo extends JpaRepository<Todo, Long> {

    @Transactional
    @Modifying
    @Query("delete from Todo t where t.personid=:personid")
    void deleteTodos(@Param("personid") Long personid);

}
