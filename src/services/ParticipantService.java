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
import beans.Evenement;
import dao.IDao;
import beans.Participant;
import connexion.Connexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import beans.InscriptionEvenement;

public class ParticipantService implements IDao<Participant> {

    private Connexion connexion;
    private Participant p;
    private EvenementService es;

    public ParticipantService() {
        connexion = Connexion.getInstance();
        es = new EvenementService();
    }

    @Override
    public boolean create(Participant o) {
        if (o == null || o.getEmail() == null) {
            return false;
        }
        String req = "INSERT INTO Participant (id, nom, prenom, email) VALUES (NULL, ?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setString(3, o.getEmail());
            System.out.println("In create method, email: " + o.getEmail()); // Changed p to o
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); // This is good - prints SQL errors
            return false;
        }
        // This will never be reached because of the return statements in the try/catch
    }

    @Override
    public boolean delete(Participant o) {
        String req = "DELETE FROM participant WHERE id = " + o.getId();
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
    public boolean update(Participant o) {
        String req = "UPDATE participant SET nom = '" + o.getNom() + "', email = '" + o.getEmail() + "' WHERE id = " + o.getId();
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
    public Participant findById(int id) {
        String req = "SELECT * FROM participant WHERE id = " + id;
        try {
            Statement st = connexion.getCn().createStatement();
            ResultSet rs = st.executeQuery(req);
            if (rs.next()) {
                return new Participant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Participant> findAll() {
        List<Participant> participants = new ArrayList<>();
        String req = "SELECT * FROM participant";
        try {
            Statement st = connexion.getCn().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                participants.add(new Participant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return participants;
    }

    public List<Participant> findByEvenement(Evenement evenement) {
        List<Participant> participants = new ArrayList<>();
        String req = ("SELECT * FROM participants WHERE evenement_id = ?");
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, evenement.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                participants.add(new Participant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return participants;
    }
}
