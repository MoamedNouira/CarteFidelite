package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

import com.medbac.carte_fidelite.Adapter.AdapterListPromotion;
import com.medbac.carte_fidelite.Downloader.getAllPromotion;
import com.medbac.carte_fidelite.Models.Promotion;


import java.util.ArrayList;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 05/04/2015.
 */
public class ListPromotion extends Activity  {
    ListView ListViewOffers;
    ArrayList<Promotion>        ListOffer;
    AdapterListPromotion adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_promorion);
        ListViewOffers = (ListView)findViewById(R.id.listView_offers);
        ArrayList<Promotion> ListOffer =new ArrayList<Promotion>();


       getAllPromotion gp = new getAllPromotion("http://mohamednouira.esy.es/getAllPromotion.php",this);
        ListOffer = getAllPromotion.ListPromotion;

        adapter = new AdapterListPromotion(this, ListOffer);
        ListViewOffers.setAdapter(adapter);




    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}

