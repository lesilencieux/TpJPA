/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp;

import com.bootcamp.jpa.entities.Bailleur;
import com.bootcamp.jpa.enums.TypeBailleur;
import com.bootcamp.jpa.repositories.BailleurRepository;
import java.sql.SQLException;
import java.util.List;
import org.testng.annotations.Test;

/**
 *
 * @author Administrateur
 */
public class BailleurCrudTest {
     @Test
    public void createBailleurTest() throws SQLException{
        // creation d'un premier bailleur
        Bailleur b1 = new Bailleur();
        b1.setNom("Cecile");
        b1.setTypeBailleur(TypeBailleur.PRIVE);
        BailleurRepository br1 = new BailleurRepository("punit-mysql");
        br1.create(b1);
        
        
        // creation d'un deuxieme bailleur
        Bailleur b2 = new Bailleur();
        b2.setNom("hilaire111");
        b2.setTypeBailleur(TypeBailleur.PRIVE);
        BailleurRepository br2 = new BailleurRepository("punit-mysql");
        br2.create(b2);
    } 
    
     // test du update et du findByProperty
    //@Test
   public void updateFournisseurTest() throws SQLException{
       BailleurRepository br = new BailleurRepository("punit-mysql");
        List<Bailleur> bail = br.findByProperty("nom", "darex");
        Bailleur b=bail.get(0);
        b.setNom("Benedict");
        br.update(b);
   } 
   
   // test du delete de bailleur en memme temp que le findByProperty
    //@Test
    public void deleteFournisseurTest() throws SQLException{
        BailleurRepository fr = new BailleurRepository("punit-mysql");
        List<Bailleur> b = fr.findByProperty("nom", "fafa");
        Bailleur f=b.get(0);
        fr.delete(f);     
    }
  // test du findAll
   @Test
    public void findAllTest(){
        BailleurRepository br = new BailleurRepository("punit-mysql");
        br.findAll();
        System.out.println(br.findAll());
    }
}
