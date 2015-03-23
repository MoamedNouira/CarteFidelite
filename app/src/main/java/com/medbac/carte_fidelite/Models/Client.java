package com.medbac.carte_fidelite.Models;

/**
 * Created by Mohamed Nouira on 05/03/2015.
 */
public class Client {
    private int id_clinet;
    private String nom;
    private String prenom;
    private String login;
    private String password;
    private int cin;
    private String adr;
    private int tell;
    private String mail;
    private int code_postal;


    public  Client(int id_clinet, String nom, String login, String prenom, String password, int cin, String adr, int tell, String mail, int code_postal) {
        this.id_clinet = id_clinet;
        this.nom = nom;
        this.login = login;
        this.prenom = prenom;
        this.password = password;
        this.cin = cin;
        this.adr = adr;
        this.tell = tell;
        this.mail = mail;
        this.code_postal = code_postal;
    }

    public Client() {
    }

    public int getId_clinet() {
        return id_clinet;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
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

    public int getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(int code_postal) {
        this.code_postal = code_postal;
    }

    public void setId_clinet(int id_clinet) {
        this.id_clinet = id_clinet;
    }
}
