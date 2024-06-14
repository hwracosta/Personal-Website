package com.example.personalwebsite.entity;

import jakarta.persistence.*;

/**
 * Represents a song entity with attributes such as title, artist, album artwork URL, and associated team member.
 */
@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String artist;
    private String albumArtworkUrl;

    @ManyToOne
    @JoinColumn(name = "team_member_id")
    private TeamMember teamMember;

    // Getters and setters

    /**
     * Gets the ID of the song.
     *
     * @return the ID of the song
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the song.
     *
     * @param id the new ID of the song
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the title of the song.
     *
     * @return the title of the song
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the song.
     *
     * @param title the new title of the song
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the artist of the song.
     *
     * @return the artist of the song
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Sets the artist of the song.
     *
     * @param artist the new artist of the song
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * Gets the album artwork URL of the song.
     *
     * @return the album artwork URL of the song
     */
    public String getAlbumArtworkUrl() {
        return albumArtworkUrl;
    }

    /**
     * Sets the album artwork URL of the song.
     *
     * @param albumArtworkUrl the new album artwork URL of the song
     */
    public void setAlbumArtworkUrl(String albumArtworkUrl) {
        this.albumArtworkUrl = albumArtworkUrl;
    }

    /**
     * Gets the associated team member for the song.
     *
     * @return the associated team member
     */
    public TeamMember getTeamMember() {
        return teamMember;
    }

    /**
     * Sets the associated team member for the song.
     *
     * @param teamMember the new associated team member
     */
    public void setTeamMember(TeamMember teamMember) {
        this.teamMember = teamMember;
    }
}