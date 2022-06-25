package com.example.agentmanager.repo;

import com.example.agentmanager.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Agentrepo extends JpaRepository<Agent,Long> {

    void deleteAgentById(Long id);
    Optional<Agent> findAgentById(Long id);
    Optional<Agent> findAgentByName(String name);
}
