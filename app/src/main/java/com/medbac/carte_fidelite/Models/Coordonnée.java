package com.medbac.carte_fidelite.Models;

/**
 * Created by Mohamed Nouira on 05/03/2015.
 */
public class Coordonnée {
    private int id_coordonnée;
    private Double longitude;
    private Double latitude;

    private Enseigne enseigne;

    public Coordonnée() {
    }

    public Coordonnée(int id_coordonnée, Double longitude, Double latitude, Enseigne enseigne) {
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
