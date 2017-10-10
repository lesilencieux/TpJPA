package com.bootcamp;

import com.bootcamp.jpa.entities.Beneficiaire;
import com.bootcamp.jpa.repositories.BeneficiaireRepository;
import java.sql.SQLException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
        System.out.println( "Hello World!" );
        // creation d'un premier beneficiaire
        Beneficiaire b1 = new Beneficiaire();
        b1.setNom("ASSOGBA");
        
        BeneficiaireRepository br1 = new BeneficiaireRepository("punit-mysql");
        br1.create(b1);
        
        // creation d'un deuxieme beneficiaire
        Beneficiaire bene2 = new Beneficiaire();
        bene2.setNom("AMOUSSOU");
        BeneficiaireRepository br2 = new BeneficiaireRepository("punit-mysql");
        br2.create(bene2);
        
        List<Beneficiaire> b = br2.findByProperty("nom", "AMOUSSOU");
        Beneficiaire ben=b.get(0);
        ben.setNom("DIEU-DONNE");
        br2.delete(ben);
    }
}
