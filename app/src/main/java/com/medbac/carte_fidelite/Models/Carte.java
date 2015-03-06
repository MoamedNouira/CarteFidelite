package com.medbac.carte_fidelite.Models;

/**
 * Created by Mohamed Nouira on 05/03/2015.
 */
public class Carte {
    private int id_carte;
    private String descr_carte;
    private String type_carte;


    public Carte(int id_carte, String descr_carte, String type_carte) {
        this.id_carte = id_carte;
        this.descr_carte = descr_carte;
        this.type_carte = type_carte;
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

    public void setDescr_carte(String descr_carte) {
        this.descr_carte = descr_carte;
    }

    public String getType_carte() {
        return type_carte;
    }

    public void setType_carte(String type_carte) {
        this.type_carte = type_carte;
    }
}
