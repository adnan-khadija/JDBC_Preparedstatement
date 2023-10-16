/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author lenovo
 */

public class Manager extends Personne{
   private  List<Personne> personnes;

    public Manager() {
    }

    public Manager(String nom, double salaire ) {
        super(nom, salaire);
    }

    public Manager(List<Personne> personnes, String nom, double salaire) {
        super(nom, salaire);
        this.personnes = personnes;
    }

    public Manager(List<Personne> personnes, String nom, double salaire, Manager manager) {
        super(nom, salaire, manager);
        this.personnes = personnes;
    }

    public List<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(List<Personne> personnes) {
        this.personnes = personnes;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    

  
    

    

   
   

   
   
    
    
    
}
