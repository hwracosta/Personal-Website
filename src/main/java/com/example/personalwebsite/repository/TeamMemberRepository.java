package com.example.personalwebsite.repository;

import com.example.personalwebsite.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing TeamMember entities.
 * Extends JpaRepository to provide CRUD operations.
 */
@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {

    /**
     * Finds a team member by their name.
     *
     * @param name the name of the team member to find
     * @return the team member with the specified name, or null if not found
     */
    TeamMember findByName(String name);
}
