package com.example.agentmanager.repo;

import com.example.agentmanager.sec.entities.AppUser;
import com.example.agentmanager.sec.entities.Approle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Rolerepository extends JpaRepository<Approle,Long> {
    Approle findRoleByRolename(String rolename);
}
