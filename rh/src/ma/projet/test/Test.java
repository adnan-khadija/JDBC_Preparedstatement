/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import ma.projet.beans.Personne;
import ma.projet.beans.Profil;
import ma.projet.service.PersonneImpl;
import ma.projet.service.ProfilImpl;

/**
 *
 * @author lenovo
 */
public class Test {
    public static void main(String[] args) {
        
        ProfilImpl pi=new ProfilImpl();
        PersonneImpl per=new PersonneImpl();
       pi.add(new Profil("MN", "Manager") );
       pi.add(new Profil("DEV", "Developer") );
       per.add(new Personne("AZIZI", "Mohammed", "Casablanca", new Date(97,3,6), "m.azizi@gmail.com", (double)19000,pi.getById(1)));
        per.add(new Personne("Dahmani", "Jalal", "Casablanca", new Date(99,6,6), "J.dahmani@hotmail.com",(double)14000,pi.getById(2)));
        
    }
    
}
