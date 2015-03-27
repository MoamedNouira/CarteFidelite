package com.medbac.carte_fidelite.Models;

import java.util.ArrayList;

/**
 * Created by Mohamed Nouira on 05/03/2015.
 */
public class Catégories {
    private int id_catégories;
    private String libellé_cat;

    private ArrayList<Carte> carte = new ArrayList<Carte>();

    public Catégories(int id_catégories, String libellé_cat, ArrayList<Carte> carte) {
        this.id_catégories = id_catégories;
        this.libellé_cat = libellé_cat;
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

    public String getLibellé_cat() {
        return libellé_cat;
    }

    public void setLibellé_cat(String libellé_cat) {
        this.libellé_cat = libellé_cat;
    }

    public ArrayList<Carte> getCarte() {
        return carte;
    }

    public void setCarte(ArrayList<Carte> carte) {
        this.carte = carte;
    }
}
