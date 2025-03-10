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
import beans.evenement;
import connexion.Connexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EvenementService implements IDao<evenement> {
    private Connexion connexion;

    public EvenementService() {
        connexion = Connexion.getInstance();
    }

    @Override
    public boolean create(evenement o) {
        String req = "INSERT INTO evenement VALUES (NULL, '" + o.getNom() + "', '" + o.getDate() + "')";
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
    public boolean delete(evenement o) {
        String req = "DELETE FROM evenement WHERE id = " + o.getId();
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
    public boolean update(evenement o) {
        String req = "UPDATE evenement SET nom = '" + o.getNom() + "', date = '" + o.getDate() + "' WHERE id = " + o.getId();
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
    public evenement findById(int id) {
        String req = "SELECT * FROM evenement WHERE id = " + id;
        try {
            Statement st = connexion.getCn().createStatement();
            ResultSet rs = st.executeQuery(req);
            if (rs.next()) {
                return new evenement(rs.getInt("id"), rs.getString("nom"), rs.getString("date"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<evenement> findAll() {
        List<evenement> evenements = new ArrayList<>();
        String req = "SELECT * FROM evenement";
        try {
            Statement st = connexion.getCn().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                evenements.add(new evenement(rs.getInt("id"), rs.getString("nom"), rs.getString("date")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return evenements;
    }
}
