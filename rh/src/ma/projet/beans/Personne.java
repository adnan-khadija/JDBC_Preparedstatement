/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.Date;



/**
 *
 * @author lenovo
 */

public class Personne {
   
    private int id;
    private String nom;
    private  String ville;
    private  String prenom;
    private Date dateNaiss;
    private String email;
    private Double salaire;
    private Profil profile;

    public Personne() {
    }

    public Personne(String nom, String ville, String prenom, Date dateNaiss, String email, Double salaire, Profil profile) {
        this.nom = nom;
        this.ville = ville;
        this.prenom = prenom;
        this.dateNaiss = dateNaiss;
        this.email = email;
        this.salaire = salaire;
        this.profile = profile;
    }

    public Profil getProfile() {
        return profile;
    }

    public void setProfile(Profil profile) {
        this.profile = profile;
    }

   

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }
    
    
    

    public void setNom(String nom) {
        this.nom = nom;
    }

    
    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

 
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Personne{" + "id=" + id + ", nom=" + nom + ", ville=" + ville + ", prenom=" + prenom + ", dateNaiss=" + dateNaiss + ", email=" + email + ", salaire=" + salaire + '}';
    }


   
}

     
    

