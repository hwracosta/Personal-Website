package com.example.personalwebsite.service;

import com.example.personalwebsite.entity.TeamMember;
import com.example.personalwebsite.repository.TeamMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing TeamMember entities.
 * Provides methods to interact with the TeamMemberRepository.
 */
@Service
public class TeamMemberService {

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    /**
     * Retrieves all team members from the repository.
     *
     * @return a list of all team members
     */
    public List<TeamMember> getAllTeamMembers() {
        return teamMemberRepository.findAll();
    }

    /**
     * Adds a new team member to the repository.
     *
     * @param teamMember the team member to be added
     * @return the saved team member
     */
    public TeamMember addTeamMember(TeamMember teamMember) {
        return teamMemberRepository.save(teamMember);
    }

    /**
     * Deletes a team member by their ID.
     *
     * @param id the ID of the team member to be deleted
     */
    public void deleteTeamMember(Long id) {
        teamMemberRepository.deleteById(id);
    }
}
