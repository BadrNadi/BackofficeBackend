package com.example.agentmanager;

import com.example.agentmanager.model.Agent;
import com.example.agentmanager.service.AgentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agent")
public class AgentResource {
    private final AgentService agentService;

    public AgentResource(AgentService agentService) {
        this.agentService = agentService;
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Agent>> getAllAgents(){
        List<Agent> agent=agentService.findAllAgent();
        return new ResponseEntity<>(agent, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Agent> getAllAgents(@PathVariable("id") Long id){
        Agent agent=agentService.findAgentById(id);
        return new ResponseEntity<>(agent, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Agent> addAgent(@RequestBody Agent agent){
        Agent newagent = agentService.addAgent(agent);
        return new ResponseEntity<>(newagent,HttpStatus.CREATED);
    }
    @GetMapping("/facture/{name}")
    public ResponseEntity<Agent> getAgentByName(@PathVariable("name") String name){
        Agent agent=agentService.findAgentByName(name);
        return new ResponseEntity<>(agent, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Agent> updateEmployee(@RequestBody Agent employee) {
        Agent updateEmployee = agentService.updateAgent(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
            public ResponseEntity<?> updateAgent(@PathVariable("id") Long id){
             agentService.deleteagent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
