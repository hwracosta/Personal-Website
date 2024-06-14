package com.example.personalwebsite.repository;

import com.example.personalwebsite.entity.Song;
import com.example.personalwebsite.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing Song entities.
 * Extends JpaRepository to provide CRUD operations.
 */
@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    /**
     * Finds all songs associated with a given team member.
     *
     * @param teamMember the team member whose songs are to be found
     * @return a list of songs associated with the given team member
     */
    List<Song> findByTeamMember(TeamMember teamMember);
}
