/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp;

import com.bootcamp.jpa.entities.Beneficiaire;
import com.bootcamp.jpa.repositories.BeneficiaireRepository;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import org.testng.annotations.Test;

/**
 *
 * @author Administrateur
 */
public class BeneficiaireCrudTest {
    @Test
    public void createBeneficiaireTest() throws ParseException, SQLException{
        // creation d'un premier beneficiaire
        Beneficiaire bene1 = new Beneficiaire();
        bene1.setNom("ASSOGBA");
        
        BeneficiaireRepository beneRep1 = new BeneficiaireRepository("punit-mysql");
        beneRep1.create(bene1);
        
        // creation d'un deuxieme beneficiaire
        Beneficiaire bene2 = new Beneficiaire();
        bene2.setNom("AMOUSSOU");
        BeneficiaireRepository beneRep2 = new BeneficiaireRepository("punit-mysql");
        beneRep2.create(bene2);
        
    }
    
    // test du update et du findByProperty
    @Test
   public void updateBeneficiaireTest() throws SQLException{
       BeneficiaireRepository br = new BeneficiaireRepository("punit-mysql");
        List<Beneficiaire> b = br.findByProperty("nom", "AMOUSSOU");
        Beneficiaire ben=b.get(0);
        ben.setNom("JEAN");
        br.update(ben);
   } 
   
   // test du delete de beneficiaire en memme temp que le findByProperty
    @Test
    public void deleteBeneficiaireTest() throws SQLException{
        BeneficiaireRepository br = new BeneficiaireRepository("punit-mysql");
        List<Beneficiaire> b = br.findByProperty("nom", "ASSOGBA");
        Beneficiaire ben=b.get(0);
        br.delete(ben);     
    }
    
  // test du findAll
    @Test
    public void findAllTest(){
        BeneficiaireRepository br = new BeneficiaireRepository("punit-mysql");
        System.out.println(br.findAll());
    }
}
