package com.example.agentmanager.sec.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity@AllArgsConstructor@NoArgsConstructor@Data
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Approle> approles=new ArrayList<>();



}
