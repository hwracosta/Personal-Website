package com.example.personalwebsite.controller;

import com.example.personalwebsite.entity.Song;
import com.example.personalwebsite.entity.TeamMember;
import com.example.personalwebsite.repository.SongRepository;
import com.example.personalwebsite.repository.TeamMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @GetMapping("/songs")
    public String getSongsPage(Model model) {
        TeamMember jaydee = teamMemberRepository.findByName("Jaydee");
        TeamMember harry = teamMemberRepository.findByName("Harry");

        List<Song> jaydeeSongs = songRepository.findByTeamMember(jaydee);
        List<Song> harrySongs = songRepository.findByTeamMember(harry);

        model.addAttribute("jaydeeSongs", jaydeeSongs);
        model.addAttribute("harrySongs", harrySongs);

        return "songs";
    }
}
