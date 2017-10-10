/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp;

import com.bootcamp.jpa.entities.Fournisseur;
import com.bootcamp.jpa.repositories.FournisseurRepository;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import org.testng.annotations.Test;

/**
 *
 * @author Administrateur
 */
public class FournisseurCrudTest {
    @Test
    public void createFournisseurTest() throws ParseException, SQLException{
        // creation d'un premier fournisseur
        Fournisseur b1 = new Fournisseur();
        b1.setNom("fafa");
        FournisseurRepository br1 = new FournisseurRepository("punit-mysql");
        br1.create(b1);
        
        
        // creation d'un deuxieme fournisseur
        Fournisseur b2 = new Fournisseur();
        b2.setNom("darex");
        FournisseurRepository br2 = new FournisseurRepository("punit-mysql");
        br2.create(b2);
        String[] args = null;
        
    }
    
    // test du update et du findByProperty
    //@Test
   public void updateFournisseurTest() throws SQLException{
       FournisseurRepository fr = new FournisseurRepository("punit-mysql");
        List<Fournisseur> four = fr.findByProperty("nom", "darex");
        Fournisseur f=four.get(0);
        f.setNom("agodotodji");
        fr.update(f);
   } 
   
   // test du delete de fournisseur en memme temp que le findByProperty
    //@Test
    public void deleteFournisseurTest() throws SQLException{
        FournisseurRepository fr = new FournisseurRepository("punit-mysql");
        List<Fournisseur> b = fr.findByProperty("nom", "fafa");
        Fournisseur f=b.get(0);
        fr.delete(f);     
    }
    
  // test du findAll
    @Test
    public void findAllTest(){
        FournisseurRepository br = new FournisseurRepository("punit-mysql");
        System.out.println(br.findAll());
    }
}
