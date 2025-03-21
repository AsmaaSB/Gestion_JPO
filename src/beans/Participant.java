/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author PC
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Participant {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private List<Evenement> evenements;
    
    public Participant() {
        this.evenements = new ArrayList<>();
    }
    
    public Participant(int id, String nom, String prenom, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        System.out.println("Participant constructor email: " + this.email);
        this.evenements = new ArrayList<>();
    }
    
    public Participant(String nom, String prenom, String email) {
    System.out.println("Three-param constructor called with:");
    System.out.println("nom: " + nom);
    System.out.println("prenom: " + prenom);
    System.out.println("email parameter: " + email);
    
    this.nom = nom;
    this.prenom = prenom;
    this.email = email;
    
    System.out.println("After assignment, this.email = " + this.email);
    this.evenements = new ArrayList<>();
}
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public List<Evenement> getEvenements() {
        return evenements;
    }
    
    public void setEvenements(List<Evenement> evenements) {
        this.evenements = evenements;
    }
    
    public void addEvenement(Evenement evenement) {
        if (!this.evenements.contains(evenement)) {
            this.evenements.add(evenement);
        }
    }
    
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Participant that = (Participant) obj;
        return id == that.id;
    }

    @Override
    public String toString() {
        return nom + " " +prenom;
    }
    
    
}

