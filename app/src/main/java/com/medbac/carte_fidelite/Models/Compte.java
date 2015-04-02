package com.medbac.carte_fidelite.Models;

/**
 * Created by Mohamed Nouira on 05/03/2015.
 */
public class Compte {
    private int id_compte;
    private int code_barre;
    private int montant;
    private int nb_point;

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public void setId_carte(int id_carte) {
        this.id_carte = id_carte;
    }

    public int getId_client() {

        return id_client;
    }

    public int getId_carte() {
        return id_carte;
    }

    private int id_client;
    private int id_carte;

    private Client client;
    private Carte carte;

    public Compte() {
    }

    public Compte(int id_compte, int code_barre, int montant, int nb_point, Client client, Carte carte,int id_client,int id_carte) {
        this.id_compte = id_compte;
        this.code_barre = code_barre;
        this.montant = montant;
        this.nb_point = nb_point;
        this.client = client;
        this.carte = carte;
        this.id_carte=id_carte;
        this.id_client=id_client;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }
}
