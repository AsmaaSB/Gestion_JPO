/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author PC
 */
import beans.Evenement;
import beans.InscriptionEvenement;
import beans.Participant;
import services.EvenementService;
import services.InscriptionEvenementService;
import services.ParticipantService;
import java.util.List;
import java.util.Date;
import java.text.ParseException;

public class Test {
    public static void main(String[] args) {
        EvenementService evenementService = new EvenementService();
        ParticipantService participantService = new ParticipantService();
        InscriptionEvenementService inscriptionEvenementService = new InscriptionEvenementService();

        java.sql.Date sqlDate1 = java.sql.Date.valueOf("2025-04-04");
        java.sql.Date sqlDate2 = java.sql.Date.valueOf("2025-05-10");
        
        Evenement event1 = new Evenement(0, "Hackathon", sqlDate1, "Marrakech");
        Evenement event2 = new Evenement(1, "Conférence IA", sqlDate2, "Rabat");
        
        evenementService.create(event1);
        evenementService.create(event2);
        

        Participant participant1 = new Participant(0, "Ali", "Abdo", "aliabdooo@email.com");
        Participant participant2 = new Participant(0, "Jamila","Arabi" , "jamilaarabi22@email.com");

        participantService.create(participant1);
        participantService.create(participant2);

        System.out.println("===== Liste des événements =====");
        List<Evenement> evenements = evenementService.findAll();
        for (Evenement e : evenements) {
            System.out.println(e.getId() + " - " + e.getNom() + " - " + e.getDate());
        }

        System.out.println("===== Liste des participants =====");
        List<Participant> participants = participantService.findAll();
        for (Participant p : participants) {
            System.out.println(p.getId() + " - " + p.getNom() + " - " + p.getEmail());
        }

        if (!evenements.isEmpty() && !participants.isEmpty()) {
            int eventId = evenements.get(0).getId();
            int participantId = participants.get(0).getId();
            
            InscriptionEvenement inscription1 = new InscriptionEvenement(0, eventId, participantId);
            inscriptionEvenementService.create(inscription1);
        }

        System.out.println("===== Liste des inscriptions =====");
        List<InscriptionEvenement> inscriptions = inscriptionEvenementService.findAll();
        for (InscriptionEvenement i : inscriptions) {
            System.out.println("Inscription ID: " + i.getId() + " - Événement ID: " + i.getEvenementId() + " - Participant ID: " + i.getParticipantId());
        }

        if (!participants.isEmpty()) {
            Participant p = participants.get(0);
            p.setNom("Alice Martin");
            participantService.update(p);
        }

        if (!evenements.isEmpty()) {
            evenementService.delete(evenements.get(0));
        }

        System.out.println("===== Après modifications =====");
        System.out.println("Participants : " + participantService.findAll());
        System.out.println("Événements : " + evenementService.findAll());
        System.out.println("Inscriptions : " + inscriptionEvenementService.findAll());
    }
}
