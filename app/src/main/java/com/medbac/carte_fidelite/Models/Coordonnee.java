package com.medbac.carte_fidelite.Models;

/**
 * Created by Mohamed Nouira on 05/03/2015.
 */
public class Coordonnee {
    private int id_coordonnee;
    private Double longitude;
    private Double latitude;
    private  int id_enseigne;

    public int getId_enseigne() {
        return id_enseigne;
    }

    public void setId_enseigne(int id_enseigne) {
        this.id_enseigne = id_enseigne;
    }

    private Enseigne enseigne;

    public Coordonnee() {
    }

    public Coordonnee(int id_coordonnee, Double longitude, Double latitude, Enseigne enseigne) {
        this.id_coordonnee = id_coordonnee;
        this.longitude = longitude;
        this.latitude = latitude;
        this.enseigne = enseigne;
    }


    public int getId_coordonnee() {
        return id_coordonnee;
    }

    public void setId_coordonnee(int id_coordonnee) {
        this.id_coordonnee = id_coordonnee;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Enseigne getEnseigne() {
        return enseigne;
    }

    public void setEnseigne(Enseigne enseigne) {
        this.enseigne = enseigne;
    }
}
