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
import beans.Evenement;
import connexion.Connexion;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EvenementService implements IDao<Evenement> {

    private Connexion connexion;

    public EvenementService() {
        connexion = Connexion.getInstance();
    }

    @Override
    public boolean create(Evenement o) {
        String req = "INSERT INTO Evenement (id ,nom, date, lieu) VALUES (NULL, ?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setDate(2, new Date(o.getDate().getTime()));
            ps.setString(3, o.getLieu());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Evenement o) {
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
    public boolean update(Evenement o) {
        String req = "UPDATE evenement SET nom = ?, date = ?, lieu = ? WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setDate(2, new java.sql.Date(o.getDate().getTime()));
            ps.setString(3, o.getLieu());
            ps.setInt(4, o.getId());

            int rowsAffected = ps.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Evenement findById(int id) {
        String req = "SELECT * FROM evenement WHERE id = " + id;
        try {
            Statement st = connexion.getCn().createStatement();
            ResultSet rs = st.executeQuery(req);
            if (rs.next()) {
                return new Evenement(rs.getInt("id"), rs.getString("nom"), rs.getDate("date"), rs.getString("lieu"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Evenement> findAll() {
        List<Evenement> evenements = new ArrayList<>();
        String req = "SELECT * FROM evenement";
        try {
            Statement st = connexion.getCn().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                evenements.add(new Evenement(rs.getInt("id"), rs.getString("nom"), rs.getDate("date"), rs.getString("lieu")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return evenements;
    }
}
