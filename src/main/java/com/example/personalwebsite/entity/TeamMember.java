package com.example.personalwebsite.entity;

import jakarta.persistence.*;
import java.util.List;

/**
 * Represents a team member entity with attributes such as name and associated songs.
 */
@Entity
public class TeamMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "teamMember")
    private List<Song> songs;

    // Getters and setters

    /**
     * Gets the ID of the team member.
     *
     * @return the ID of the team member
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the team member.
     *
     * @param id the new ID of the team member
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the team member.
     *
     * @return the name of the team member
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the team member.
     *
     * @param name the new name of the team member
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the list of songs associated with the team member.
     *
     * @return the list of songs
     */
    public List<Song> getSongs() {
        return songs;
    }

    /**
     * Sets the list of songs associated with the team member.
     *
     * @param songs the new list of songs
     */
    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
