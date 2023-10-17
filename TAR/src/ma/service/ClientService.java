/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.beans.Client;
import ma.beans.Service;
import ma.connexion.Connexion;
import ma.dao.IDao;
import java.text.ParseException;


/**
 *
 * @author Lachgar
 */
public class ClientService implements IDao<Client>{
    private ServiceService ss;
    private Object dateFormat;

    public ClientService() {
        ss = new ServiceService();
    }
    

    @Override
    public boolean create(Client o) {
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String req = "insert into client values (null, ?, ?, ?, ?)";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setDate(3, new Date(o.getDate().getTime()));
            ps.setInt(4, o.getService().getId());
            if(ps.executeUpdate() == 1)
                return true;
        } catch (SQLException ex) {
            System.out.println("Erreur d'ajout d'un client:" +ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Client o) {
    try {
        // Création d'un objet PreparedStatement avec une requête SQL paramétrée
        String req = "UPDATE client SET nom=?, prenom=?, date=?, service=? WHERE id=?";
        PreparedStatement ps = Connexion.getConnection().prepareStatement(req);

        // Demande à l'utilisateur d'entrer les nouvelles informations
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez les nouvelles informations :");
        System.out.print("Nouveau nom : ");
        String nom = sc.nextLine();
        System.out.print("Nouveau prénom : ");
        String prenom = sc.nextLine();
        System.out.print("Nouvelle date (au format 'yyyy-MM-dd') : ");
        String dt = sc.nextLine();
        System.out.print("Nouveau service (ID) : ");
        int sr = sc.nextInt();

        // Paramétrage des valeurs pour la requête SQL
        ps.setString(1, nom);
        ps.setString(2, prenom);
        ps.setString(3, dt);
        ps.setInt(4, sr);
        ps.setInt(5, o.getId());

        // Exécution de la requête SQL paramétrée
        if (ps.executeUpdate() == 1) {
            System.out.println("Mise à jour réussie");
            return true;
        }
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la mise à jour du client : " + ex.getMessage());
    }
    return false;
}

    @Override
    public boolean delete(Client o) {
        String req = "delete from client where id = "+ o.getId();
        try {
            Statement st = Connexion.getConnection().createStatement();
            st.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur de suppression d'un client:" +ex.getMessage());
        }
        return false;
    }

    @Override
    public Client findById(int id) {
        Client client = null;
        ResultSet rs = null;
        String req = "select * from client where id = "+id;
        try {
            Statement st = Connexion.getConnection().createStatement();
            rs = st.executeQuery(req);
            if (rs.next()){
              client = new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getDate("date"), ss.findById(rs.getInt("service")));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur findById client:" +ex.getMessage());
        }
        return client;
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        ResultSet rs = null;
        String req = "select * from client";
        try {
            Statement st = Connexion.getConnection().createStatement();
            rs = st.executeQuery(req);
            while (rs.next()){
              clients.add(new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getDate("date"), ss.findById(rs.getInt("service"))));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur findAll client:" +ex.getMessage());
        }
        return clients;
            
    }
    public List<Client> findByService(Service s){
        List<Client> clients =new ArrayList<>();
      if (s==null){
          return clients;
      }
       String req = "SELECT * FROM client WHERE service =?";

        try {
             PreparedStatement pr =Connexion.getConnection().prepareStatement(req);
             pr.setInt(1, s.getId());
             ResultSet rs = pr.executeQuery();
            while (rs.next()){
                clients.add(new Client(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"),rs.getDate("date"), ss.findById(rs.getInt("service"))));
                
            }
        } catch (SQLException ex) {
            System.out.println("SQLException "+ ex.getMessage());
        }
        return clients;
    }

    
    

    
}