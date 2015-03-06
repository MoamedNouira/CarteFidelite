package com.medbac.carte_fidelite.Models;

/**
 * Created by Mohamed Nouira on 05/03/2015.
 */
public class Coordonnée {
    private int id_coordonnée;
    private Double longitude;
    private Double latitude;

    public Coordonnée(int id_coordonnée, Double longitude, Double latitude) {
        this.id_coordonnée = id_coordonnée;
        this.longitude = longitude;
        this.latitude = latitude;
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
}
