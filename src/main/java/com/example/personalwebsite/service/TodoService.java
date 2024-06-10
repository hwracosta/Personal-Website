package com.example.personalwebsite.service;

import com.example.personalwebsite.entity.Todo;
import com.example.personalwebsite.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll().stream().filter(todo -> !todo.isCompleted()).toList();
    }

    public List<Todo> getCompletedTodos() {
        return todoRepository.findAll().stream().filter(Todo::isCompleted).toList();
    }

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

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    public Todo completeTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.setCompleted(true);
        return todoRepository.save(todo);
    }

    public Todo incompleteTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.setCompleted(false);
        return todoRepository.save(todo);
    }

    public void deleteCompletedTodo(Long id) {
        todoRepository.deleteById(id);
    }

    public List<Todo> filterByLabel(String label) {
        if (label == null || label.isEmpty()) {
            return todoRepository.findAll().stream().filter(todo -> !todo.isCompleted()).toList();
        } else {
            return todoRepository.findByLabel(label).stream().filter(todo -> !todo.isCompleted()).toList();
        }
    }

    public List<String> getAllLabels() {
        return todoRepository.findAll().stream().map(Todo::getLabel).distinct().toList();
    }
}
