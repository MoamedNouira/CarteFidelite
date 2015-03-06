package com.medbac.carte_fidelite.Models;

/**
 * Created by Mohamed Nouira on 05/03/2015.
 */
public class Catégories {
    private int id_catégories;
    private String libellé_cat;

    public Catégories(int id_catégories, String libellé_cat) {
        this.id_catégories = id_catégories;
        this.libellé_cat = libellé_cat;
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
}
