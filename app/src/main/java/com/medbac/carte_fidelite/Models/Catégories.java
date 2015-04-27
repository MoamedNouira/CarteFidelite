package com.medbac.carte_fidelite.Models;

import java.util.ArrayList;

/**
 * Created by Mohamed Nouira on 05/03/2015.
 */
public class Catégories {
    private int id_catégories;

    public String getNom_cat() {
        return nom_cat;
    }

    public void setNom_cat(String nom_cat) {
        this.nom_cat = nom_cat;
    }

    private String nom_cat;

    private ArrayList<Carte> carte = new ArrayList<Carte>();

    public Catégories(int id_catégories, String nom_cat, ArrayList<Carte> carte) {
        this.id_catégories = id_catégories;
        this.nom_cat = nom_cat;
        this.carte = carte;
    }

    public Catégories() {
    }


    public int getId_catégories() {
        return id_catégories;
    }

    public void setId_catégories(int id_catégories) {
        this.id_catégories = id_catégories;
    }




    public ArrayList<Carte> getCarte() {
        return carte;
    }

    public void setCarte(ArrayList<Carte> carte) {
        this.carte = carte;
    }
}
