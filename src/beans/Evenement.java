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
import java.util.Date;
import java.util.List;
import java.util.ArrayList;


public class Evenement {
    private int id;
    private String nom;
    private Date date;
    private String lieu;
    private List<Participant> participants;
    
    public Evenement() {
        this.participants = new ArrayList<>();
    }
    
    public Evenement(int id, String nom, Date date, String lieu) {
        this.id = id;
        this.nom = nom;
        this.date = date;
        this.lieu = lieu;
        this.participants = new ArrayList<>();
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
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public String getLieu() {
        return lieu;
    }
    
    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
    
    public List<Participant> getParticipants() {
        return participants;
    }
    
    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }
    
    public void addParticipant(Participant participant) {
        if (!this.participants.contains(participant)) {
            this.participants.add(participant);
        }
    }
    
    @Override
    public String toString() {
        return "Evenement [id=" + id + ", nom=" + nom + ", date=" + date + ", lieu=" + lieu + "]";
    }
}
