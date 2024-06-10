package com.example.personalwebsite.controller;

import com.example.personalwebsite.entity.TeamMember;
import com.example.personalwebsite.service.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/team-members")
public class TeamMemberController {

    @Autowired
    private TeamMemberService teamMemberService;

    @GetMapping
    public String getAllTeamMembers(Model model) {
        List<TeamMember> teamMembers = teamMemberService.getAllTeamMembers();
        model.addAttribute("teamMembers", teamMembers);
        return "teamMembers";
    }

    @PostMapping
    public String addTeamMember(@ModelAttribute TeamMember teamMember) {
        teamMemberService.addTeamMember(teamMember);
        return "redirect:/team-members";
    }

    @GetMapping("/{id}/delete")
    public String deleteTeamMember(@PathVariable Long id) {
        teamMemberService.deleteTeamMember(id);
        return "redirect:/team-members";
    }
}
