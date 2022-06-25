package com.example.agentmanager.service;

import com.example.agentmanager.repo.Rolerepository;
import com.example.agentmanager.repo.UserRepository;
import com.example.agentmanager.sec.entities.AppUser;
import com.example.agentmanager.sec.entities.Approle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AccountserviceImpl implements Accountservice {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Rolerepository rolerepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public AccountserviceImpl(UserRepository userRepository, Rolerepository rolerepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.rolerepository = rolerepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AppUser addNewUser(AppUser appUser) {
        String pswd=appUser.getPassword();
        appUser.setPassword(passwordEncoder.encode(pswd));
        return userRepository.save(appUser);
    }

    @Override
    public Approle addNewRole(Approle approle) {
        return rolerepository.save(approle);
    }

    @Override
    public void addroleToUser(String appUser1, String approle1) {
        AppUser appUser=userRepository.findUserByemail(appUser1);
        Approle approle=rolerepository.findRoleByRolename(approle1);
        appUser.getApproles().add(approle);

    }

    @Override
    public AppUser loadUserByEmail(String email) {
        return userRepository.findUserByemail(email);
    }

    @Override
    public List<AppUser> listUser() {
        return userRepository.findAll();
    }
}
