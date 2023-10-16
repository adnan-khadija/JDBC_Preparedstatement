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
import ma.projet.beans.Manager;
import ma.projet.beans.Manager;
import ma.projet.dao.IDao;


/**
 *
 * @author lenovo
 */
public class ManagerService implements IDao<Manager>{
    
@Override
    public boolean create(Manager o) {
try {
            String req = "insert into manager values (null, ?, ?)";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setDouble(2, o.getSalaire());
           
            if(ps.executeUpdate() == 1)
                return true;
        } catch (SQLException ex) {
            System.out.println("Erreur d'ajout d'un d'un devloper:" +ex.getMessage());
        }
        return false;    }

    @Override
    public boolean update(Manager o) {
    try {
        // Création d'un objet PreparedStatement avec une requête SQL paramétrée
        String req = "UPDATE manager SET nom=?, salaire=? WHERE id=?";
        PreparedStatement ps = Connexion.getConnection().prepareStatement(req);

        // Demande à l'utilisateur d'entrer les nouvelles informations
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez les nouvelles informations :");
        System.out.print("Nouveau nom : ");
        String nom = sc.nextLine();
        System.out.print("Nouveau salaire: ");
        Double salaire = sc.nextDouble();
      
        int sr = sc.nextInt();

        // Paramétrage des valeurs pour la requête SQL
        ps.setString(1, nom);
        ps.setDouble(2, salaire);
       

        // Exécution de la requête SQL paramétrée
        if (ps.executeUpdate() == 1) {
            System.out.println("Mise à jour réussie");
            return true;
        }
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la mise à jour du manager : " + ex.getMessage());
    }
    return false;
}


    @Override
    public boolean delete(Manager o) {
     String req = "delete from manager where id = "+ o.getId();
        try {
            Statement st = Connexion.getConnection().createStatement();
            st.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur de suppression d'un manager:" +ex.getMessage());
        }
        return false;    }

    @Override
    public Manager getById(int id) {
     Manager manager = null;
        ResultSet rs = null;
        String req = "select * from manager where id = "+id;
        try {
            Statement st = Connexion.getConnection().createStatement();
            rs = st.executeQuery(req);
            if (rs.next()){
              manager = new Manager(rs.getString("nom"),rs.getDouble("salaire"));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur findById manager:" +ex.getMessage());
        }
        return manager;    }

    @Override
    public List<Manager> getAll() {
    List<Manager> managers = new ArrayList<>();
        ResultSet rs = null;
        String req = "select * from manager";
        try {
            Statement st = Connexion.getConnection().createStatement();
            rs = st.executeQuery(req);
            while (rs.next()){
              managers.add(new Manager( rs.getString("nom"),rs.getDouble("salaire")));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur findAll manager:" +ex.getMessage());
        }
        return managers;    }

    
    }
