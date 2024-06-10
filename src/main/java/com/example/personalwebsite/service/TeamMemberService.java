package com.example.personalwebsite.service;

import com.example.personalwebsite.entity.TeamMember;
import com.example.personalwebsite.repository.TeamMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamMemberService {

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    public List<TeamMember> getAllTeamMembers() {
        return teamMemberRepository.findAll();
    }

    public TeamMember addTeamMember(TeamMember teamMember) {
        return teamMemberRepository.save(teamMember);
    }

    public void deleteTeamMember(Long id) {
        teamMemberRepository.deleteById(id);
    }
}
