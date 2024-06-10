package com.example.personalwebsite.controller;

import com.example.personalwebsite.entity.Song;
import com.example.personalwebsite.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping
    public String getAllSongs(Model model) {
        List<Song> songs = songService.getAllSongs();
        model.addAttribute("songs", songs);
        return "songs";
    }

    @PostMapping
    public String addSong(@ModelAttribute Song song) {
        songService.addSong(song);
        return "redirect:/songs";
    }

    @GetMapping("/{id}/delete")
    public String deleteSong(@PathVariable Long id) {
        songService.deleteSong(id);
        return "redirect:/songs";
    }
}
