/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp;

import com.bootcamp.jpa.entities.Programme;
import com.bootcamp.jpa.repositories.ProgrammeRepository;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.annotations.Test;

/**
 *
 * @author Administrateur
 */
public class ProgrammeCrudTest {
    @Test
    public void createProgrammeTest() throws SQLException, ParseException{
        
        Date dateD = new SimpleDateFormat("yyyy/MM/dd").parse("2016/05/03"); 
        Date dateF = new SimpleDateFormat("yyyy/MM/dd").parse("2015/01/18"); 
        // creation d'un premier fournisseur
        Programme b1 = new Programme();
        b1.setNom("Grand");
        b1.setObjectif("Loi loi");
        b1.setBudgetEffectif(1000000);
        b1.setBudgetPrevisioonel(1500000);
        b1.setDateDeDebut(dateD);
        b1.setDateDeFin(dateF);
        
        ProgrammeRepository pr1 = new ProgrammeRepository("punit-mysql");
        pr1.create(b1);
        
        
    }
    
  // test du findAll
    @Test
    public void findAllTest(){
        ProgrammeRepository br = new ProgrammeRepository("punit-mysql");
        br.findAll();
    }
}
