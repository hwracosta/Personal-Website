package com.example.personalwebsite.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Represents a to-do item entity with attributes such as description, completion status, and label.
 */
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private boolean completed;
    private String label;

    // Getters and Setters

    /**
     * Gets the ID of the to-do item.
     *
     * @return the ID of the to-do item
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the to-do item.
     *
     * @param id the new ID of the to-do item
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the description of the to-do item.
     *
     * @return the description of the to-do item
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the to-do item.
     *
     * @param description the new description of the to-do item
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Checks if the to-do item is completed.
     *
     * @return true if the to-do item is completed, false otherwise
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Sets the completion status of the to-do item.
     *
     * @param completed the new completion status of the to-do item
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * Gets the label of the to-do item.
     *
     * @return the label of the to-do item
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the label of the to-do item.
     *
     * @param label the new label of the to-do item
     */
    public void setLabel(String label) {
        this.label = label;
    }
}
