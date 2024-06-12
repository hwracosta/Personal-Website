package com.example.personalwebsite.controller;

import com.example.personalwebsite.entity.Song;
import com.example.personalwebsite.entity.TeamMember;
import com.example.personalwebsite.service.SongService;
import com.example.personalwebsite.service.TeamMemberService;
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

    @Autowired
    private TeamMemberService teamMemberService;

    @GetMapping
    public String getAllSongs(Model model) {
        List<Song> songs = songService.getAllSongs();
        List<TeamMember> teamMembers = teamMemberService.getAllTeamMembers();
        model.addAttribute("songs", songs);
        model.addAttribute("teamMembers", teamMembers);
        model.addAttribute("song", new Song());
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
