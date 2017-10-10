/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp;

import com.bootcamp.jpa.json.BailleursJson;
import com.bootcamp.jpa.json.FournisseursJson;
import java.io.IOException;
import org.testng.annotations.Test;

/**
 *
 * @author Administrateur
 */
public class GsonTester {
     @Test
    public void jsonBailleurTester() throws IOException{
            BailleursJson bj = new BailleursJson();
            bj.jsonMaker();
    }
    @Test
    public void jsonFournisseurTester() throws IOException{
     
        FournisseursJson fj =new FournisseursJson();
        fj.jsonMaker();
    }
}
