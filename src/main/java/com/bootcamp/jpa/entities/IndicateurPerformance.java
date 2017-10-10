/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "tp_indicateur_performance")
public class IndicateurPerformance implements Serializable {
    /*
    *Debut de la 
    *d�claration des variables de la classe
    */
    @Id
    private int id;
    @NotNull(message = "Ce champs ne doit pas �tre vide")
    private String libelle,nature;
    @NotNull(message = "Ce champs ne doit pas �tre vide")
    private int valeur;
    
    
    /*
    *fin de la
    *d�claration des variables de la classe
    */
    

     //Representation de la collection de indicateur qualitatif dans indicateur de performance
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "indicateurPerformance")
    private List<IndicateurQualitatif> indicateurQualitatifs;
    //Representation de la collection de indicateur quanlitatif dans indicateur de performance
    @OneToMany(mappedBy = "indicateurPerformance")
    private List<IndicateurQuantitatif> indicateurQuantitatifs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public List<IndicateurQualitatif> getIndicateurQualitatifs() {
        return indicateurQualitatifs;
    }

    public void setIndicateurQualitatifs(List<IndicateurQualitatif> indicateurQualitatifs) {
        this.indicateurQualitatifs = indicateurQualitatifs;
    }

    public List<IndicateurQuantitatif> getIndicateurQuantitatifs() {
        return indicateurQuantitatifs;
    }

    public void setIndicateurQuantitatifs(List<IndicateurQuantitatif> indicateurQuantitatifs) {
        this.indicateurQuantitatifs = indicateurQuantitatifs;
    }
    
    
}
