package com.example.personalwebsite.controller;

import com.example.personalwebsite.entity.TeamMember;
import com.example.personalwebsite.service.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling HTTP requests related to TeamMember entities.
 * Provides endpoints for displaying, adding, and deleting team members.
 */
@Controller
@RequestMapping("/team-members")
public class TeamMemberController {

    @Autowired
    private TeamMemberService teamMemberService;

    /**
     * Handles GET requests to "/team-members".
     * Retrieves all team members and adds them to the model for rendering the "teamMembers" view.
     *
     * @param model the model to add attributes to
     * @return the name of the view to render
     */
    @GetMapping
    public String getAllTeamMembers(Model model) {
        List<TeamMember> teamMembers = teamMemberService.getAllTeamMembers();
        model.addAttribute("teamMembers", teamMembers);
        model.addAttribute("teamMember", new TeamMember());
        return "teamMembers";
    }

    /**
     * Handles POST requests to "/team-members".
     * Adds a new team member using the provided form data.
     *
     * @param teamMember the team member to add
     * @return a redirect to the "/team-members" page
     */
    @PostMapping
    public String addTeamMember(@ModelAttribute TeamMember teamMember) {
        teamMemberService.addTeamMember(teamMember);
        return "redirect:/team-members";
    }

    /**
     * Handles GET requests to "/team-members/{id}/delete".
     * Deletes the team member with the specified ID.
     *
     * @param id the ID of the team member to delete
     * @return a redirect to the "/team-members" page
     */
    @GetMapping("/{id}/delete")
    public String deleteTeamMember(@PathVariable Long id) {
        teamMemberService.deleteTeamMember(id);
        return "redirect:/team-members";
    }
}
