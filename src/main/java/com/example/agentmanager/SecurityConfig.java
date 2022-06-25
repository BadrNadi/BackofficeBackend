package com.example.agentmanager;

import com.example.agentmanager.sec.entities.AppUser;
import com.example.agentmanager.service.Accountservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private Accountservice accountservice;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                AppUser appUser=accountservice.loadUserByEmail(username);
                System.out.println("---------------------");
                System.out.println(appUser.getApproles().isEmpty());
                Collection<GrantedAuthority> authorities=new ArrayList<>();
                appUser.getApproles().forEach(r->{
                    authorities.add(new SimpleGrantedAuthority(r.getRolename()));
                    System.out.println(r.getRolename());

                });
                return new User(appUser.getEmail(),appUser.getPassword(),authorities);
            }
        });
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{

//        httpSecurity.authorizeRequests().antMatchers("/agent/**").hasRole("Agent");
        httpSecurity.authorizeRequests().anyRequest().permitAll();
        httpSecurity.formLogin() ;
       httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();



    }
}
