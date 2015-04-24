package com.medbac.carte_fidelite.Models;

import java.util.ArrayList;

/**
 * Created by Mohamed Nouira on 05/03/2015.
 */
public class Enseigne {
    private int id_enseigne;
    private String nom_commercial;
    private String adresse;

    public String getVile() {
        return vile;
    }

    public void setVile(String vile) {
        this.vile = vile;
    }

    private String vile;
    private int code_postal;
    private int tell;
    private String mail;

    private ArrayList<Coordonnée> coordonnée = new ArrayList<Coordonnée>();
    private ArrayList<Carte> carte = new ArrayList<Carte>();
    private ArrayList<Promotion> promotions = new ArrayList<Promotion>();


    public ArrayList<Coordonnée> getCoordonnée() {
        return coordonnée;
    }

    public void setCoordonnée(ArrayList<Coordonnée> coordonnée) {
        this.coordonnée = coordonnée;
    }

    public ArrayList<Carte> getCarte() {
        return carte;
    }

    public void setCarte(ArrayList<Carte> carte) {
        this.carte = carte;
    }

    public ArrayList<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(ArrayList<Promotion> promotions) {
        this.promotions = promotions;
    }

    public Enseigne() {
    }

    public Enseigne(int id_enseigne, String nom_commercial, String adresse, String vile, int code_postal, int tell, String mail, ArrayList<Coordonnée> coordonnée, ArrayList<Carte> carte, ArrayList<Promotion> promotions) {
        this.id_enseigne = id_enseigne;
        this.nom_commercial = nom_commercial;
        this.adresse = adresse;
        this.vile = vile;
        this.code_postal = code_postal;
        this.tell = tell;
        this.mail = mail;
        this.coordonnée = coordonnée;
        this.carte = carte;
        this.promotions = promotions;
    }


    public int getId_enseigne() {
        return id_enseigne;
    }

    public void setId_enseigne(int id_enseigne) {
        this.id_enseigne = id_enseigne;
    }

    public String getNom_commercial() {
        return nom_commercial;
    }

    public void setNom_commercial(String nom_commercial) {
        this.nom_commercial = nom_commercial;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }



    public int getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(int code_postal) {
        this.code_postal = code_postal;
    }

    public int getTell() {
        return tell;
    }

    public void setTell(int tell) {
        this.tell = tell;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
