/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ma.connexion.Connexion;
import ma.projet.beans.Personne;
import ma.projet.beans.Profil;
import ma.projet.dao.IDao;




/**
 *
 * @author lenovo
 */
public class PersonneImpl implements IDao<Personne>{
    private ProfilImpl pi;

    public PersonneImpl() {
        pi=new ProfilImpl();
    }
   

    
   
   
    @Override
    public boolean add(Personne o) {
       
try {
            String req = "insert into personne values (null, ?, ?,?,?,?,?,?)";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setString(3, o.getVille());
            ps.setDate(4, new Date( o.getDateNaiss().getTime()));
            ps.setString(5, o.getEmail());
            ps.setDouble(6, o.getSalaire());
            ps.setInt(7, o.getProfile().getId());
           
            if(ps.executeUpdate() == 1)
                return true;
        } catch (SQLException ex) {
            System.out.println("Erreur d'ajout d'un d'un personne:" +ex.getMessage());
        }
        return false;    }

    @Override
    public boolean update(Personne o) {
    try {
        // Création d'un objet PreparedStatement avec une requête SQL paramétrée
        String req = "UPDATE personne SET nom=?,prenom=?,vill=?,dateNaiss=?,email=?, salaire=?,profil=? WHERE id=?";
        PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setString(3, o.getVille());
            ps.setDate(4, new Date ( o.getDateNaiss().getTime()));
            ps.setString(5, o.getEmail());
            ps.setDouble(6, o.getSalaire());
            ps.setInt(7, o.getProfile().getId());    

        // Exécution de la requête SQL paramétrée
        if (ps.executeUpdate() == 1) {
            System.out.println("Mise à jour réussie");
            return true;
        }
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la mise à jour du personne : " + ex.getMessage());
    }
    return false;
}


    @Override
    public boolean delete(Personne o) {
     String req = "delete from personne where id = "+ o.getId();
        try {
            Statement st = Connexion.getConnection().createStatement();
            st.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur de suppression d'un personne:" +ex.getMessage());
        }
        return false;    }

    @Override
    public Personne getById(int id) {
     Personne personne = null;
        ResultSet rs = null;
        String req = "select * from personne where id = "+id;
        try {
            Statement st = Connexion.getConnection().createStatement();
            rs = st.executeQuery(req);
            if (rs.next()){
              personne = new Personne( rs.getString("nom"),rs.getString("prenom"),rs.getString("ville"),rs.getDate("dateNaiss"),rs.getString("email"),rs.getDouble("salaire"),pi.getById(rs.getInt("profil")));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur findById personne:" +ex.getMessage());
        }
        return personne;    }

    @Override
    public List<Personne> getAll() {
    List<Personne> personnes = null;
        ResultSet rs = null;
        String req = "select * from personne";
        try {
            Statement st = Connexion.getConnection().createStatement();
            rs = st.executeQuery(req);
            while (rs.next()){
              personnes.add( new Personne( rs.getString("nom"),rs.getString("prenom"),rs.getString("ville"),rs.getDate("dateNaiss"),rs.getString("email"),rs.getDouble("salaire"),pi.getById(rs.getInt("profil"))));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur findAll personne:" +ex.getMessage());
        }
        return personnes;    }
    public List<Personne> findByProfil(Profil p){
        List<Personne> clients =new ArrayList<>();
      if (p==null){
          return clients;
      }
       String req = "SELECT * FROM personne WHERE profil=?";

        try {
             PreparedStatement pr =Connexion.getConnection().prepareStatement(req);
             pr.setInt(1, p.getId());
             ResultSet rs = pr.executeQuery();
            while (rs.next()){
                clients.add(new Personne( rs.getString("nom"),rs.getString("prenom"),rs.getString("ville"),rs.getDate("dateNaiss"),rs.getString("email"),rs.getDouble("salaire"),pi.getById(rs.getInt("profil"))));
                
            }
        } catch (SQLException ex) {
            System.out.println("SQLException "+ ex.getMessage());
        }
        return clients;
    }

    
    
    

    
}

