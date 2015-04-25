package com.medbac.carte_fidelite.Models;

/**
 * Created by Mohamed Nouira on 05/03/2015.
 */
public class Coordonnée {
    private int id_coordonnée;
    private float longitude;
    private float latitude;

    private Enseigne enseigne;

    public Coordonnée() {
    }

    public Coordonnée(int id_coordonnée, float longitude, float latitude, Enseigne enseigne) {
        this.id_coordonnée = id_coordonnée;
        this.longitude = longitude;
        this.latitude = latitude;
        this.enseigne = enseigne;
    }


    public int getId_coordonnée() {
        return id_coordonnée;
    }

    public void setId_coordonnée(int id_coordonnée) {
        this.id_coordonnée = id_coordonnée;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public Enseigne getEnseigne() {
        return enseigne;
    }

    public void setEnseigne(Enseigne enseigne) {
        this.enseigne = enseigne;
    }
}
