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
import beans.evenement;
import beans.InscriptionEvenement;
import beans.Participant;
import services.EvenementService;
import services.InscriptionEvenementService;
import services.ParticipantService;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        EvenementService evenementService = new EvenementService();
        ParticipantService participantService = new ParticipantService();
        InscriptionEvenementService inscriptionEvenementService = new InscriptionEvenementService();


        evenement event1 = new evenement(0, "Hackathon", "2025-04-20");
        evenement event2 = new evenement(0, "Conférence IA", "2025-05-10");

        evenementService.create(event1);
        evenementService.create(event2);

        Participant participant1 = new Participant(0, "Ali Abdo", "aliabdooo@email.com");
        Participant participant2 = new Participant(0, "Jamila Arabi", "jamilaarabi22@email.com");

        participantService.create(participant1);
        participantService.create(participant2);

        System.out.println("===== Liste des événements =====");
        List<evenement> evenements = evenementService.findAll();
        for (evenement e : evenements) {
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
