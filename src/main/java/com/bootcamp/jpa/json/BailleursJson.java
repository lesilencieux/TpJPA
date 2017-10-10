/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.json;

import com.bootcamp.jpa.entities.Bailleur;
import com.bootcamp.jpa.enums.TypeBailleur;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Administrateur
 */
public class BailleursJson {
    
    ObjectMapper objetMapper = new ObjectMapper();

    public void jsonMaker() throws IOException{
        Bailleur bailleur = new Bailleur();
        bailleur.setNom("BOA");
        bailleur.setTypeBailleur(TypeBailleur.PARTENAIRE_INTERNATIONAL);
        
        File file = new File("JsonGenerated/bailleurs.json");
        
        objetMapper.writeValue(file, bailleur);
        Bailleur b = objetMapper.readValue(file, Bailleur.class);
        System.out.println(b);
    }
    
}
