package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.medbac.carte_fidelite.Models.Client;

import java.util.ArrayList;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 03/04/2015.
 */
public class ListCarte extends Activity {

    ArrayList <Compte> ListCompte =new ArrayList<Compte>();
    Client client;
    Carte carte;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_carte);



    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}