package com.medbac.carte_fidelite.Models;

/**
 * Created by Mohamed Nouira on 05/03/2015.
 */
public class List_code {
    private int id_list;
    private int list_min;
    private int list_max;

    public List_code(int id_list, int list_min, int list_max) {
        this.id_list = id_list;
        this.list_min = list_min;
        this.list_max = list_max;
    }

    public int getId_list() {
        return id_list;
    }

    public void setId_list(int id_list) {
        this.id_list = id_list;
    }

    public int getList_min() {
        return list_min;
    }

    public void setList_min(int list_min) {
        this.list_min = list_min;
    }

    public int getList_max() {
        return list_max;
    }

    public void setList_max(int list_max) {
        this.list_max = list_max;
    }
}
