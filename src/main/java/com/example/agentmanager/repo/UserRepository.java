package com.example.agentmanager.repo;

import com.example.agentmanager.sec.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser,Long> {
    AppUser findUserByemail(String email);
}
