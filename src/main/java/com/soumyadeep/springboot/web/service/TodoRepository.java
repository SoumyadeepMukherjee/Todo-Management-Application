package com.soumyadeep.springboot.web.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soumyadeep.springboot.web.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findByUser(String user);
}