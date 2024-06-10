package com.example.personalwebsite.controller;

import com.example.personalwebsite.entity.Todo;
import com.example.personalwebsite.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

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

    @PostMapping
    public String addTodo(@ModelAttribute Todo todo) {
        todoService.addTodo(todo);
        return "redirect:/todos";
    }

    @GetMapping("/{id}/complete")
    public String completeTodo(@PathVariable Long id) {
        todoService.completeTodo(id);
        return "redirect:/todos";
    }

    @GetMapping("/{id}/incomplete")
    public String incompleteTodo(@PathVariable Long id) {
        todoService.incompleteTodo(id);
        return "redirect:/todos";
    }

    @GetMapping("/{id}/delete")
    public String deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return "redirect:/todos";
    }

    @GetMapping("/{id}/delete-completed")
    public String deleteCompletedTodo(@PathVariable Long id) {
        todoService.deleteCompletedTodo(id);
        return "redirect:/todos";
    }

    @GetMapping("/filter")
    public String filterTodos(@RequestParam String label, Model model) {
        List<Todo> todos = todoService.filterByLabel(label);
        List<Todo> completedTodos = todoService.getCompletedTodos();
        List<String> labels = todoService.getAllLabels();
        model.addAttribute("todos", todos);
        model.addAttribute("completedTodos", completedTodos);
        model.addAttribute("labels", labels);
        model.addAttribute("todo", new Todo());
        return "todo";
    }
}
