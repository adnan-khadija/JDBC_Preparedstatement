/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ma.connexion.Connexion;
import ma.projet.beans.Profil;
import ma.projet.beans.Profil;
import ma.projet.beans.Profil;
import ma.projet.dao.IDao;


/**
 *
 * @author lenovo
 */
public class ProfilImpl implements IDao<Profil>{
    
@Override
    public boolean add(Profil o) {
       
try {
            String req = "insert into profil values (null, ?, ?)";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getCode());
            ps.setString(2, o.getLibelle());
            if(ps.executeUpdate() == 1)
                return true;
        } catch (SQLException ex) {
            System.out.println("Erreur d'ajout d'un d'un profil:" +ex.getMessage());
        }
        return false;    }

    @Override
    public boolean update(Profil o) {
    try {
        // Création d'un objet PreparedStatement avec une requête SQL paramétrée
        String req = "UPDATE profil SET code=?,libelle=? WHERE id=?";
        PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getCode());
            ps.setString(2, o.getLibelle());

        // Exécution de la requête SQL paramétrée
        if (ps.executeUpdate() == 1) {
            System.out.println("Mise à jour réussie");
            return true;
        }
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la mise à jour du profil : " + ex.getMessage());
    }
    return false;
}


    @Override
    public boolean delete(Profil o) {
     String req = "delete from profil where id = "+ o.getId();
        try {
            Statement st = Connexion.getConnection().createStatement();
            st.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur de suppression d'un profil:" +ex.getMessage());
        }
        return false;    }

    @Override
    public Profil getById(int id) {
     Profil profil = null;
        ResultSet rs = null;
        String req = "select * from profil where id = "+id;
        try {
            Statement st = Connexion.getConnection().createStatement();
            rs = st.executeQuery(req);
            if (rs.next()){
              profil = new Profil( rs.getString("code"),rs.getString("libelle"));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur findById profil:" +ex.getMessage());
        }
        return profil;    }

    @Override
    public List<Profil> getAll() {
    List<Profil> profils = new ArrayList<>();
        ResultSet rs = null;
        String req = "select * from profil";
        try {
            Statement st = Connexion.getConnection().createStatement();
            rs = st.executeQuery(req);
            while (rs.next()){
              profils.add( new Profil( rs.getInt("id"),rs.getString("code"),rs.getString("libelle")));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur findAll profil:" +ex.getMessage());
        }
        return profils;    }

    
}
    
    
