package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

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
    ArrayList ListCartes;
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

     /*   ListViewCarte.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = ListViewCarte.getItemAtPosition(position);
                Compte obj_itemDetails = (Compte)o;
                Toast.makeText(ListCarte.this, "You have chosen : " + " " + obj_itemDetails.getId_compte(), Toast.LENGTH_LONG).show();
                Intent i = new Intent(ListCarte.this, InfoCarte.class);
                startActivity(i);
            }
        });

        */

        ListViewCarte.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position,long arg3) {
                Intent i = new Intent(ListCarte.this,InfoCarte.class);
                i.putExtra("position", position);
                startActivity(i);
            }
        });


    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}