package services;

import dao.IDao;
import beans.InscriptionEvenement;
import beans.Evenement;
import beans.Participant;
import connexion.Connexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dao.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InscriptionEvenementService implements IDao<InscriptionEvenement> {

    private Connexion connexion;
    private EvenementService evenementService;
    private ParticipantService participantService;

    public InscriptionEvenementService() {
        connexion = Connexion.getInstance();
        evenementService = new EvenementService();
        participantService = new ParticipantService();
    }

    @Override
    public boolean create(InscriptionEvenement o) {
        String req = "INSERT INTO inscriptionevenement (evenement_id, participant_id) VALUES (?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getEvenement().getId());
            ps.setInt(2, o.getParticipant().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(InscriptionEvenement o) {
        String req = "DELETE FROM inscriptionevenement WHERE evenement_id = ? AND participant_id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getEvenement().getId());
            ps.setInt(2, o.getParticipant().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(InscriptionEvenement o) {
        // Since InscriptionEvenement doesn't have an ID, we'll use the composite key
        String req = "UPDATE inscriptionevenement SET evenement_id = ?, participant_id = ? WHERE evenement_id = ? AND participant_id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getEvenement().getId());
            ps.setInt(2, o.getParticipant().getId());
            // These should be the original values that identify the row
            // In practice, you might need to store the original values somewhere
            ps.setInt(3, o.getEvenement().getId());
            ps.setInt(4, o.getParticipant().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public InscriptionEvenement findById(int id) {
        // Since InscriptionEvenement doesn't have a single ID field, 
        // this method might not be applicable as is
        String req = "SELECT * FROM inscriptionevenement WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Load the full Evenement and Participant objects using their services
                Evenement evenement = evenementService.findById(rs.getInt("evenement_id"));
                Participant participant = participantService.findById(rs.getInt("participant_id"));

                return new InscriptionEvenement(evenement, participant);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<InscriptionEvenement> findAll() {
        List<InscriptionEvenement> inscriptions = new ArrayList<>();
        String req = "SELECT * FROM inscriptionevenement";
        try {
            Statement st = connexion.getCn().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                // Load the full Evenement and Participant objects using their services
                Evenement evenement = evenementService.findById(rs.getInt("evenement_id"));
                Participant participant = participantService.findById(rs.getInt("participant_id"));

                inscriptions.add(new InscriptionEvenement(evenement, participant));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return inscriptions;
    }

   

    public List<InscriptionEvenement> findByEvenement(Evenement selectedEvenement) {
        List<InscriptionEvenement> inscriptions = new ArrayList<>();
        String req = "SELECT * FROM InscriptionEvenement WHERE evenement_id = ?";
        try (PreparedStatement ps = connexion.getCn().prepareStatement(req)) {
            ps.setInt(1, selectedEvenement.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Participant participant = participantService.findById(rs.getInt("participant_id"));
                Evenement evenement = evenementService.findById(rs.getInt("evenement_id"));

                inscriptions.add(new InscriptionEvenement(evenement, participant));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return inscriptions;
    }

    public List<InscriptionEvenement> findByEvenement(Participant selectedParticipant) {
        List<InscriptionEvenement> inscriptions = new ArrayList<>();
        String req = "SELECT * FROM InscriptionEvenement WHERE participant_id = ?";
        try (PreparedStatement ps = connexion.getCn().prepareStatement(req)) {
            ps.setInt(1, selectedParticipant.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Participant participant = participantService.findById(rs.getInt("participant_id"));
                Evenement evenement = evenementService.findById(rs.getInt("evenement_id"));

                inscriptions.add(new InscriptionEvenement(evenement, participant));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return inscriptions;
    }
}


    

