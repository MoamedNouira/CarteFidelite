package com.medbac.carte_fidelite.Models;
import  java.util.*;
/**
 * Created by Mohamed Nouira on 05/03/2015.
 */
public class Promotion {
    private int id_promotion;
    private String descr_promo;
    private Date  date_deb_promo;
    private Date date_fin_promo;

    private Promotion promotion;

    public Promotion(int id_promotion, String descr_promo, Date date_deb_promo, Date date_fin_promo, Promotion promotion) {
        this.id_promotion = id_promotion;
        this.descr_promo = descr_promo;
        this.date_deb_promo = date_deb_promo;
        this.date_fin_promo = date_fin_promo;
        this.promotion = promotion;
    }

    public Promotion() {
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public int getId_promotion() {
        return id_promotion;
    }

    public void setId_promotion(int id_promotion) {
        this.id_promotion = id_promotion;
    }

    public String getDescr_promo() {
        return descr_promo;
    }

    public void setDescr_promo(String descr_promo) {
        this.descr_promo = descr_promo;
    }

    public Date getDate_deb_promo() {
        return date_deb_promo;
    }

    public void setDate_deb_promo(Date date_deb_promo) {
        this.date_deb_promo = date_deb_promo;
    }

    public Date getDate_fin_promo() {
        return date_fin_promo;
    }

    public void setDate_fin_promo(Date date_fin_promo) {
        this.date_fin_promo = date_fin_promo;
    }
}
