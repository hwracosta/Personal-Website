package com.example.personalwebsite.service;

import com.example.personalwebsite.entity.Song;
import com.example.personalwebsite.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing Song entities.
 * Provides methods to interact with the SongRepository.
 */
@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    /**
     * Retrieves all songs from the repository.
     *
     * @return a list of all songs
     */
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }
}
