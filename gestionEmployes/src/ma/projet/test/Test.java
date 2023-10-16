/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import ma.projet.beans.Devlopper;
import ma.projet.beans.Manager;
import ma.projet.beans.Personne;
import ma.projet.service.DeveloperService;
import ma.projet.service.ManagerService;


/**
 *
 * @author lenovo
 */
public class Test {
    public static void main(String[] args) {
        ManagerService ms=new ManagerService();
        DeveloperService ds= new DeveloperService();
        //Definition des personne hommes et femmes
        ms.create(new Manager("Saad", 19500));
       ms.create(new Manager("Mohammed", 19000));
        ds.create(new Devlopper("Hassan", 12000,ms.getById(1)));
        ds.create(new Devlopper("Mohammed", 13000,ms.getById(1)));
        ds.create(new Devlopper("Ahmed", 15000,ms.getById(1)));
        ds.create(new Devlopper("Samir", 11000,ms.getById(2)));
        ds.create(new Devlopper("Jamil", 12000,ms.getById(2)));
                
               
        
    }     
}
