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

/**
 * SongController is responsible for handling HTTP GET requests for the songs page
 * and providing the necessary data to the view.
 */
@Controller
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    /**
     * Handles GET requests to the "/songs" URL and returns the "songs" view.
     *
     * @param model the Model object to pass data to the view
     * @return the name of the view to be rendered (songs.html)
     */
    @GetMapping("/songs")
    public String getSongsPage(Model model) {
        // Find the team members "Jaydee" and "Harry" from the repository
        TeamMember jaydee = teamMemberRepository.findByName("Jaydee");
        TeamMember harry = teamMemberRepository.findByName("Harry");

        // Retrieve the list of songs for each team member
        List<Song> jaydeeSongs = songRepository.findByTeamMember(jaydee);
        List<Song> harrySongs = songRepository.findByTeamMember(harry);

        // Add the lists of songs to the model to be accessible in the view
        model.addAttribute("jaydeeSongs", jaydeeSongs);
        model.addAttribute("harrySongs", harrySongs);

        // Return the name of the view to be rendered
        return "songs";
    }
}
