package com.medbac.carte_fidelite.Models;

/**
 * Created by Mohamed Nouira on 05/03/2015.
 */
public class Compte {
    private int id_compte;
    private int code_barre;
    private int montant;
    private int nb_point;

    public Compte(int id_compte, int code_barre, int montant, int nb_point) {
        this.id_compte = id_compte;
        this.code_barre = code_barre;
        this.montant = montant;
        this.nb_point = nb_point;
    }

    public int getId_compte() {
        return id_compte;
    }

    public void setId_compte(int id_compte) {
        this.id_compte = id_compte;
    }

    public int getCode_barre() {
        return code_barre;
    }

    public void setCode_barre(int code_barre) {
        this.code_barre = code_barre;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public int getNb_point() {
        return nb_point;
    }

    public void setNb_point(int nb_point) {
        this.nb_point = nb_point;
    }
}
