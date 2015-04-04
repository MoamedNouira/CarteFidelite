package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.medbac.carte_fidelite.Downloader.GetClient;
import com.medbac.carte_fidelite.Models.Compte;
import com.medbac.carte_fidelite.Models.Carte;



import java.util.ArrayList;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 03/04/2015.
 */
public class ListCarte extends Activity {

    ArrayList  ListCompte;
    Compte compte;
    Carte carte;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_carte);

        ArrayList <Compte> ListCompte =new ArrayList<Compte>();

        ListCompte = GetClient.client1.getCompte();
       int w=22;
        for(int i=0;i< ListCompte.size();i++)
        {

            compte =  ListCompte.get(i);
            carte=compte.getCarte();
            int x= carte.getId_carte();
            Log.e("samarche","fffffffffffffffff  "+x);

        }



    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}