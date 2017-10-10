/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.json;

import com.bootcamp.jpa.entities.Fournisseur;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Administrateur
 */
public class FournisseursJson {
     ObjectMapper objetMapper = new ObjectMapper();

    public void jsonMaker() throws IOException{
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setNom("Bénin");
        
        File file = new File("JsonGenerated/fournisseurs.json");
        
        objetMapper.writeValue(file, fournisseur);
        Fournisseur f = objetMapper.readValue(file, Fournisseur.class);
        System.out.println(f);
    }
}
