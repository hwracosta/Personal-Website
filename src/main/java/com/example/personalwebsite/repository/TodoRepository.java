package com.example.personalwebsite.repository;

import com.example.personalwebsite.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing Todo entities.
 * Extends JpaRepository to provide CRUD operations.
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    /**
     * Finds todos by their label.
     *
     * @param label the label of the todos to find
     * @return a list of todos with the specified label
     */
    List<Todo> findByLabel(String label);
}
