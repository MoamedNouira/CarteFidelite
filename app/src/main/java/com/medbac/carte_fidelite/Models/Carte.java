package com.medbac.carte_fidelite.Models;

import java.util.ArrayList;

/**
 * Created by Mohamed Nouira on 05/03/2015.
 */
public class Carte {
    private int id_carte;
    private String descr_carte;
    private String type_carte;
    private String nom;

    private ArrayList <Compte> compte = new ArrayList<Compte>();
    private Catégories catégories;
    private Enseigne enseigne;








    public Carte() {
    }

    public Carte(int id_carte, String descr_carte, String type_carte, String nom, ArrayList<Compte> compte, Catégories catégories, Enseigne enseigne) {
        this.id_carte = id_carte;
        this.descr_carte = descr_carte;
        this.type_carte = type_carte;
        this.nom = nom;
        this.compte = compte;
        this.catégories = catégories;
        this.enseigne = enseigne;
    }

    public int getId_carte() {
        return id_carte;
    }

    public void setId_carte(int id_carte) {
        this.id_carte = id_carte;
    }

    public String getDescr_carte() {
        return descr_carte;
    }


    public void setCompte(ArrayList<Compte> compte) {
        this.compte = compte;
    }

    public ArrayList<Compte> getCompte() {

        return compte;
    }


    public void setDescr_carte(String descr_carte) {
        this.descr_carte = descr_carte;
    }

    public String getType_carte() {
        return type_carte;
    }

    public void setType_carte(String type_carte) {
        this.type_carte = type_carte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Catégories getCatégories() {
        return catégories;
    }

    public void setCatégories(Catégories catégories) {
        this.catégories = catégories;
    }

    public Enseigne getEnseigne() {
        return enseigne;
    }

    public void setEnseigne(Enseigne enseigne) {
        this.enseigne = enseigne;
    }
}
