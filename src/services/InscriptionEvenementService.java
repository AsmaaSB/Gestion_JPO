/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author PC
 */
import dao.IDao;
import beans.InscriptionEvenement;
import connexion.Connexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InscriptionEvenementService implements IDao<InscriptionEvenement> {
    private Connexion connexion;

    public InscriptionEvenementService() {
        connexion = Connexion.getInstance();
    }

    @Override
    public boolean create(InscriptionEvenement o) {
        String req = "INSERT INTO inscription_evenement VALUES (NULL, " + o.getEvenementId() + ", " + o.getParticipantId() + ")";
        try {
            Statement st = connexion.getCn().createStatement();
            st.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(InscriptionEvenement o) {
        String req = "DELETE FROM inscription_evenement WHERE id = " + o.getId();
        try {
            Statement st = connexion.getCn().createStatement();
            st.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(InscriptionEvenement o) {
        String req = "UPDATE inscription_evenement SET evenement_id = " + o.getEvenementId() + ", participant_id = " + o.getParticipantId() + " WHERE id = " + o.getId();
        try {
            Statement st = connexion.getCn().createStatement();
            st.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public InscriptionEvenement findById(int id) {
        String req = "SELECT * FROM inscription_evenement WHERE id = " + id;
        try {
            Statement st = connexion.getCn().createStatement();
            ResultSet rs = st.executeQuery(req);
            if (rs.next()) {
                return new InscriptionEvenement(rs.getInt("id"), rs.getInt("evenement_id"), rs.getInt("participant_id"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<InscriptionEvenement> findAll() {
        List<InscriptionEvenement> inscriptions = new ArrayList<>();
        String req = "SELECT * FROM inscription_evenement";
        try {
            Statement st = connexion.getCn().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                inscriptions.add(new InscriptionEvenement(rs.getInt("id"), rs.getInt("evenement_id"), rs.getInt("participant_id")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return inscriptions;
    }
}
