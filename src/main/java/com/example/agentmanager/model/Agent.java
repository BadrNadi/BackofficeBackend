package com.example.agentmanager.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Agent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    private Long matriculation,patente;
    private String numerotele;
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String password;
    @Column(unique=true)
    private String email;
    private String name,lastname,date,piece,fichier;





    public Agent() {
    }

    public Agent(Long id, String numerotele, Long matriculation, Long patente, String date, String password, String name, String lastname, String email, String piece, String fichier,String Role) {
        this.id = id;
        this.numerotele = numerotele;
        this.matriculation = matriculation;
        this.patente = patente;
        this.date = date;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.piece = piece;
        this.fichier = fichier;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumerotele() {
        return numerotele;
    }

    public void setNumerotele(String numerotele) {
        this.numerotele = numerotele;
    }

    public Long getMatriculation() {
        return matriculation;
    }

    public void setMatriculation(Long matriculation) {
        this.matriculation = matriculation;
    }

    public Long getPatente() {
        return patente;
    }

    public void setPatente(Long patente) {
        this.patente = patente;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }

    public String getFichier() {
        return fichier;
    }

    public void setFichier(String fichier) {
        this.fichier = fichier;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", numerotele=" + numerotele +
                ", matriculation=" + matriculation +
                ", patente=" + patente +
                ", date=" + date +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", piece='" + piece + '\'' +
                ", fichier='" + fichier + '\'' +
                '}';
    }

}
