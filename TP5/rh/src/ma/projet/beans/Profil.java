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

public class Profil {
   

    private  int id ;
    private String code;
    private String libelle;

    public Profil() {
    }

    public Profil(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public Profil(int id, String code, String libelle) {
        this.id = id;
        this.code = code;
        this.libelle = libelle;
    }
    

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return libelle ;
    }

    
     

    

  
    

    

   
   

   
   
    
    
    
}
