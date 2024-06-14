package com.example.personalwebsite.service;

import com.example.personalwebsite.entity.Todo;
import com.example.personalwebsite.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing Todo entities.
 * Provides methods to interact with the TodoRepository.
 */
@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    /**
     * Retrieves all active todos from the repository.
     *
     * @return a list of all active todos
     */
    public List<Todo> getAllTodos() {
        return todoRepository.findAll().stream().filter(todo -> !todo.isCompleted()).toList();
    }

    /**
     * Retrieves all completed todos from the repository.
     *
     * @return a list of all completed todos
     */
    public List<Todo> getCompletedTodos() {
        return todoRepository.findAll().stream().filter(Todo::isCompleted).toList();
    }

    /**
     * Adds a new todo to the repository.
     * Parses the description to separate the label and description.
     *
     * @param todo the todo to be added
     * @return the saved todo
     */
    public Todo addTodo(Todo todo) {
        // Parse the description to separate label and description
        if (todo.getDescription().contains("#")) {
            String[] parts = todo.getDescription().split(" ", 2);
            todo.setLabel(parts[0].trim().substring(1)); // Remove the '#' from the label
            todo.setDescription(parts[1].trim());
        } else {
            todo.setLabel(""); // Set label to empty if not present
        }
        return todoRepository.save(todo);
    }

    /**
     * Deletes a todo by its ID.
     *
     * @param id the ID of the todo to be deleted
     */
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    /**
     * Marks a todo as completed.
     *
     * @param id the ID of the todo to be completed
     * @return the updated todo
     */
    public Todo completeTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.setCompleted(true);
        return todoRepository.save(todo);
    }

    /**
     * Marks a todo as incomplete.
     *
     * @param id the ID of the todo to be marked as incomplete
     * @return the updated todo
     */
    public Todo incompleteTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.setCompleted(false);
        return todoRepository.save(todo);
    }

    /**
     * Deletes a completed todo by its ID.
     *
     * @param id the ID of the completed todo to be deleted
     */
    public void deleteCompletedTodo(Long id) {
        todoRepository.deleteById(id);
    }

    /**
     * Filters todos by label.
     *
     * @param label the label to filter by
     * @return a list of todos with the specified label
     */
    public List<Todo> filterByLabel(String label) {
        if (label == null || label.isEmpty()) {
            return todoRepository.findAll();
        } else {
            return todoRepository.findByLabel(label);
        }
    }

    /**
     * Retrieves all distinct labels from the repository.
     *
     * @return a list of all distinct labels
     */
    public List<String> getAllLabels() {
        return todoRepository.findAll().stream().map(Todo::getLabel).distinct().toList();
    }
}
