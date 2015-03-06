package com.medbac.carte_fidelite.Models;

/**
 * Created by Mohamed Nouira on 05/03/2015.
 */
public class Enseigne {
    private int id_enseigne;
    private String nom_commercial;
    private String adresse;
    private String vile;
    private int code_postal;
    private int tell;
    private int mail;

    public Enseigne(int id_enseigne, String nom_commercial, String adresse, String vile, int code_postal, int tell, int mail) {
        this.id_enseigne = id_enseigne;
        this.nom_commercial = nom_commercial;
        this.adresse = adresse;
        this.vile = vile;
        this.code_postal = code_postal;
        this.tell = tell;
        this.mail = mail;
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

    public String getVile() {
        return vile;
    }

    public void setVile(String vile) {
        this.vile = vile;
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

    public int getMail() {
        return mail;
    }

    public void setMail(int mail) {
        this.mail = mail;
    }
}
