package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.medbac.carte_fidelite.Adapter.AdapterListCarte;
import com.medbac.carte_fidelite.Downloader.GetCarte;
import com.medbac.carte_fidelite.Downloader.GetClient;
import com.medbac.carte_fidelite.Downloader.getCompte;

import com.medbac.carte_fidelite.Models.Compte;
import com.medbac.carte_fidelite.Models.Carte;
import com.medbac.carte_fidelite.Models.Client;




import java.util.ArrayList;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 03/04/2015.
 */
public class ListCarte extends Activity {

    ArrayList  ListCompte;
    ArrayList ListCarte;
    Compte compte;
    Carte carte;
    ListView ListViewCarte;
    AdapterListCarte adapter;
    Context c ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_carte);

        ListViewCarte = (ListView)findViewById(R.id.listView);

        ArrayList <Compte> ListCompte =new ArrayList<Compte>();

        ListCompte = GetClient.client1.getCompte();

        for(int i=0;i< ListCompte.size();i++)
        {
            compte =  ListCompte.get(i);
            carte = compte.getCarte();
            Log.e("samarche","fffffffffffffffff  "+compte.getId_carte());
        }
        adapter = new AdapterListCarte(this, ListCompte);
        ListViewCarte.setAdapter(adapter);


    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}