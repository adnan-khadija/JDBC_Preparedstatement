/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ma.connexion.Connexion;
import ma.projet.beans.Devlopper;
import ma.projet.dao.IDao;


/**
 *
 * @author lenovo
 */
public class DeveloperService implements IDao<Devlopper>{
   private ManagerService ms;

    public DeveloperService() {
        ms=new ManagerService();
    }
   
   
    @Override
    public boolean create(Devlopper o) {
       
try {
            String req = "insert into devlopper values (null, ?, ?,?)";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setDouble(2, o.getSalaire());
            ps.setInt(3, (o.getManager()).getId());
           
            if(ps.executeUpdate() == 1)
                return true;
        } catch (SQLException ex) {
            System.out.println("Erreur d'ajout d'un d'un devloper:" +ex.getMessage());
        }
        return false;    }

    @Override
    public boolean update(Devlopper o) {
    try {
        // Création d'un objet PreparedStatement avec une requête SQL paramétrée
        String req = "UPDATE devlopper SET nom=?, salaire=?,manager=? WHERE id=?";
        PreparedStatement ps = Connexion.getConnection().prepareStatement(req);

        // Demande à l'utilisateur d'entrer les nouvelles informations
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez les nouvelles informations :");
        System.out.print("Nouveau nom : ");
        String nom = sc.nextLine();
        System.out.print("Nouveau salaire: ");
        Double salaire = sc.nextDouble();
        System.out.print("Nouveau manager: ");
        int manager = sc.nextInt();
        int sr = sc.nextInt();

        // Paramétrage des valeurs pour la requête SQL
        ps.setString(1, nom);
        ps.setDouble(2, salaire);
        ps.setDouble(3, manager);

        // Exécution de la requête SQL paramétrée
        if (ps.executeUpdate() == 1) {
            System.out.println("Mise à jour réussie");
            return true;
        }
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la mise à jour du devlopper : " + ex.getMessage());
    }
    return false;
}


    @Override
    public boolean delete(Devlopper o) {
     String req = "delete from devlopper where id = "+ o.getId();
        try {
            Statement st = Connexion.getConnection().createStatement();
            st.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur de suppression d'un devlopper:" +ex.getMessage());
        }
        return false;    }

    @Override
    public Devlopper getById(int id) {
     Devlopper devlopper = null;
        ResultSet rs = null;
        String req = "select * from devlopper where id = "+id;
        try {
            Statement st = Connexion.getConnection().createStatement();
            rs = st.executeQuery(req);
            if (rs.next()){
              devlopper = new Devlopper( rs.getString("nom"),rs.getDouble("salaire"),ms.getById(rs.getInt("manager")));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur findById devlopper:" +ex.getMessage());
        }
        return devlopper;    }

    @Override
    public List<Devlopper> getAll() {
    List<Devlopper> devloppers = new ArrayList<>();
        ResultSet rs = null;
        String req = "select * from devlopper";
        try {
            Statement st = Connexion.getConnection().createStatement();
            rs = st.executeQuery(req);
            while (rs.next()){
              devloppers.add(new Devlopper( rs.getString("nom"),rs.getDouble("salaire"),ms.getById(rs.getInt("manager"))));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur findAll devlopper:" +ex.getMessage());
        }
        return devloppers;    }

    
}

