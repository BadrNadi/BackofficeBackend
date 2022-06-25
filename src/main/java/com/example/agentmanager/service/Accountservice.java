package com.example.agentmanager.service;

import com.example.agentmanager.sec.entities.AppUser;
import com.example.agentmanager.sec.entities.Approle;

import java.util.List;

public interface Accountservice {
    AppUser addNewUser(AppUser appUser);
    Approle addNewRole(Approle approle);
    void addroleToUser(String appUser,String approle);
    AppUser loadUserByEmail(String email);
    List<AppUser> listUser();
}
