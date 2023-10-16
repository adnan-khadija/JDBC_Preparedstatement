package ma.test;

import java.util.Date;
import ma.beans.Client;
import ma.beans.Service;
import ma.service.ClientService;
import ma.service.ServiceService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lachgar
 */
public class Test {
    public static void main(String[] args) {
        ClientService cs = new ClientService();
        ServiceService ss = new ServiceService();
        ss.create(new Service("Mareketing"));
        ss.create(new Service("Finance"));
        ss.create(new Service("Transport"));
        
     Client c = new Client("rami", "ali", new Date(), ss.findById(2));
        cs.create(c);
    Client c1 = new Client("raji", "Mohammed", new Date(), ss.findById(1));
        cs.create(c1);
       Client c2 = new Client("rami", "ali", new Date(), ss.findById(3));
       cs.create(c2);
        Client c3 = new Client("Jdili", "Sara", new Date(), ss.findById(3));
        cs.create(c3);
        Client c4 = new Client("Dahi", "Salma", new Date(), ss.findById(3));
        cs.create(c4);
        
        System.out.println(cs.findById(2));
      /*  cs.delete(cs.findById(2));
        for(Service s : ss.findAll()){
            System.out.println("Service :"+s.getNom());
            for(Client c : cs.findAll()){
                if(c.getService().getId() == s.getId())
                    System.out.println("########## " +c.getNom()+" "+c.getPrenom());
            }
        }*/
       // cs.update(cs.findById(3));
       // ss.delete(ss.findById(8));
      // Client c= cs.findById(2);
       //cs.update(c);
        /*System.out.println(s);
       for(Client c: cs.findByService(s)){
           System.out.println("client :"+ c.getNom()+" "+c.getPrenom());
       }*/
         
       // ss.create(new Service("Finance"));
        
        
    }
}
