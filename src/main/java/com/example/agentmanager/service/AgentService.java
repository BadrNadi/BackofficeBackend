package com.example.agentmanager.service;

import com.example.agentmanager.exceptiom.UserNotFoundException;
import com.example.agentmanager.model.Agent;
import com.example.agentmanager.repo.Agentrepo;
import com.example.agentmanager.sec.entities.AppUser;
import com.example.agentmanager.sec.entities.Approle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
@Transactional
public class AgentService {
    private final Agentrepo agentrepo;
    private final EmailService emailService;
    private final Accountservice accountservice;


    @Autowired
    public AgentService(Agentrepo agentrepo, EmailService emailService, Accountservice accountservice) {
        this.agentrepo = agentrepo;
        this.emailService=emailService;
        this.accountservice = accountservice;
    }
    public Agent addAgent(Agent agent){
        String pswd=UUID.randomUUID().toString().substring(0,6);


      agent.setPassword(pswd);

        accountservice.addNewUser(new AppUser(agent.getId(),agent.getEmail(),pswd,new ArrayList<>()));
        AppUser A=new AppUser (null,agent.getEmail(),agent.getPassword(),new ArrayList<>());
        Approle B=new Approle(null,"Agent");
        accountservice.addroleToUser(A.getEmail(),B.getRolename());
        this.emailService.sendmessage(agent.getEmail(),"Votre Modepasse",pswd);
        return agentrepo.save(agent);

    }
    public List<Agent> findAllAgent(){
        return agentrepo.findAll();
    }
    public Agent updateAgent(Agent agent){
        return agentrepo.save(agent);
    }

    public void deleteagent(Long id){
        agentrepo.deleteAgentById(id);
    }
    public Agent findAgentById(Long id){
        return agentrepo.findAgentById(id).orElseThrow(()-> new UserNotFoundException("User by id "+ id +"was not found"));

    }
    public Agent findAgentByName(String name){
        return agentrepo.findAgentByName(name).orElseThrow(()-> new UserNotFoundException("User by id "+ name +"was not found"));

    }
}
