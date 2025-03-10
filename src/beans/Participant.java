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

public class Participant {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private List<evenement> evenements;
    
    public Participant() {
        this.evenements = new ArrayList<>();
    }
    
    public Participant(int id, String nom, String prenom, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
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
    
    public List<evenement> getEvenements() {
        return evenements;
    }
    
    public void setEvenements(List<evenement> evenements) {
        this.evenements = evenements;
    }
    
    public void addEvenement(evenement evenement) {
        if (!this.evenements.contains(evenement)) {
            this.evenements.add(evenement);
        }
    }
    
    @Override
    public String toString() {
        return "Participant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Participant that = (Participant) obj;
        return id == that.id;
    }
}

