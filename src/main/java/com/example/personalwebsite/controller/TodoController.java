package com.example.personalwebsite.controller;

import com.example.personalwebsite.entity.Todo;
import com.example.personalwebsite.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling HTTP requests related to Todo entities.
 * Provides endpoints for displaying, adding, completing, and deleting todo items.
 */
@Controller
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    /**
     * Handles GET requests to "/todos".
     * Retrieves all active and completed todos, as well as all unique labels.
     * Adds the retrieved data to the model for rendering the "todo" view.
     *
     * @param model the model to add attributes to
     * @return the name of the view to render
     */
    @GetMapping
    public String getAllTodos(Model model) {
        List<Todo> todos = todoService.getAllTodos();
        List<Todo> completedTodos = todoService.getCompletedTodos();
        List<String> labels = todoService.getAllLabels();
        model.addAttribute("todos", todos);
        model.addAttribute("completedTodos", completedTodos);
        model.addAttribute("labels", labels);
        model.addAttribute("todo", new Todo());
        return "todo";
    }

    /**
     * Handles POST requests to "/todos".
     * Adds a new todo using the provided form data.
     *
     * @param todo the todo to add
     * @return a redirect to the "/todos" page
     */
    @PostMapping
    public String addTodo(@ModelAttribute Todo todo) {
        todoService.addTodo(todo);
        return "redirect:/todos";
    }

    /**
     * Handles GET requests to "/todos/{id}/complete".
     * Marks the todo with the specified ID as completed.
     *
     * @param id the ID of the todo to complete
     * @return a redirect to the "/todos" page
     */
    @GetMapping("/{id}/complete")
    public String completeTodo(@PathVariable Long id) {
        todoService.completeTodo(id);
        return "redirect:/todos";
    }

    /**
     * Handles GET requests to "/todos/{id}/incomplete".
     * Marks the todo with the specified ID as incomplete.
     *
     * @param id the ID of the todo to mark as incomplete
     * @return a redirect to the "/todos" page
     */
    @GetMapping("/{id}/incomplete")
    public String incompleteTodo(@PathVariable Long id) {
        todoService.incompleteTodo(id);
        return "redirect:/todos";
    }

    /**
     * Handles GET requests to "/todos/{id}/delete".
     * Deletes the todo with the specified ID.
     *
     * @param id the ID of the todo to delete
     * @return a redirect to the "/todos" page
     */
    @GetMapping("/{id}/delete")
    public String deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return "redirect:/todos";
    }

    /**
     * Handles GET requests to "/todos/{id}/delete-completed".
     * Deletes the completed todo with the specified ID.
     *
     * @param id the ID of the completed todo to delete
     * @return a redirect to the "/todos" page
     */
    @GetMapping("/{id}/delete-completed")
    public String deleteCompletedTodo(@PathVariable Long id) {
        todoService.deleteCompletedTodo(id);
        return "redirect:/todos";
    }

    /**
     * Handles GET requests to "/todos/filter".
     * Filters todos by the specified label and updates the model with the filtered results.
     *
     * @param label the label to filter todos by
     * @param model the model to add attributes to
     * @return the name of the view to render
     */
    @GetMapping("/filter")
    public String filterTodos(@RequestParam String label, Model model) {
        List<Todo> todos = todoService.filterByLabel(label).stream().filter(todo -> !todo.isCompleted()).toList();
        List<Todo> completedTodos = todoService.filterByLabel(label).stream().filter(Todo::isCompleted).toList();
        List<String> labels = todoService.getAllLabels();
        model.addAttribute("todos", todos);
        model.addAttribute("completedTodos", completedTodos);
        model.addAttribute("labels", labels);
        model.addAttribute("todo", new Todo());
        return "todo";
    }
}