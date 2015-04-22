package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;


import java.util.ArrayList;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 05/04/2015.
 */
public class ListPromotion extends Activity  {
    ListView ListViewCarte;
    ArrayList        ListOffer;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_promorion);
        ListViewCarte = (ListView)findViewById(R.id.listView);
        ArrayList<Promotion> ListOffer =new ArrayList<Promotion>();




    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}

