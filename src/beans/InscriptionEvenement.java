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
public class InscriptionEvenement {
    private int id;
    private int evenementId;
    private int participantId;
    
    public InscriptionEvenement() {
    }
    
    public InscriptionEvenement(int id, int evenementId, int participantId) {
        this.id = id;
        this.evenementId = evenementId;
        this.participantId = participantId;
    }
    
    // Getters et Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getEvenementId() {
        return evenementId;
    }
    
    public void setEvenementId(int evenementId) {
        this.evenementId = evenementId;
    }
    
    public int getParticipantId() {
        return participantId;
    }
    
    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }
    
    @Override
    public String toString() {
        return "InscriptionEvenement [id=" + id + ", evenementId=" + evenementId + ", participantId=" + participantId + "]";
    }
}