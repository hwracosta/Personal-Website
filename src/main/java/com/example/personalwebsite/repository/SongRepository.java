package com.example.personalwebsite.repository;

import com.example.personalwebsite.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
