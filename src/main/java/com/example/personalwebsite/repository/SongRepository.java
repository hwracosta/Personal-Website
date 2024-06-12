package com.example.personalwebsite.repository;

import com.example.personalwebsite.entity.Song;
import com.example.personalwebsite.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findByTeamMember(TeamMember teamMember);
}
