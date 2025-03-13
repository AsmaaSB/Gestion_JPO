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
import beans.Participant;
import connexion.Connexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipantService implements IDao<Participant> {
    private Connexion connexion;

    public ParticipantService() {
        connexion = Connexion.getInstance();
    }

    @Override
    public boolean create(Participant o) {
        String req = "INSERT INTO participant VALUES (NULL, '" + o.getNom() + "', '" + o.getEmail() + "')";
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
                return new Participant(rs.getInt("id"), rs.getString("nom"), rs.getString("email"), rs.getString("lieu"));
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
                participants.add(new Participant(rs.getInt("id"), rs.getString("nom"), rs.getString("email"), rs.getString("lieu")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return participants;
    }
}
