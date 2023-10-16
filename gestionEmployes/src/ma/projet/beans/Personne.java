/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;



/**
 *
 * @author lenovo
 */

public class Personne {
   
    protected int id;
    protected String nom;
    protected  double  salaire;
    protected Manager manager;

    public Personne() {
    }
    
    public Personne(String nom, double salaire) {
        this.nom = nom;
        this.salaire = salaire;
    } 
    
    public Personne(String nom, double salaire, Manager manager) {
        this.nom = nom;
        this.salaire = salaire;
        this.manager = manager;
    }

    

   

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

   

  
   

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSalaire() {
        return salaire;
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
        return nom ;
    }

   
}

     
    

