package com.example.agentmanager.web;

import com.example.agentmanager.sec.entities.AppUser;
import com.example.agentmanager.sec.entities.Approle;
import com.example.agentmanager.service.Accountservice;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestContoller {
    private Accountservice accountservice;

    public AccountRestContoller(Accountservice accountservice) {
        this.accountservice = accountservice;
    }
    @GetMapping("/user")
    public List<AppUser> appUserList(){
        return accountservice.listUser();
    }
    @PostMapping("/adduser")
    public AppUser saveuser(@RequestBody AppUser appUser){
        return accountservice.addNewUser(appUser);

    }
    @PostMapping("/roles")
    public Approle saveRole(@RequestBody Approle approle){
        return accountservice.addNewRole(approle);

    }
    @PostMapping("/addroletouser")
    public void addroletouser(@RequestBody RoletoUser roletoUser){
        accountservice.addroleToUser(roletoUser.getUsername(), roletoUser.getRolename());

    }



}
@Data
class RoletoUser{
    private String username;
    private String rolename;
}
