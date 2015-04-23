package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 23/04/2015.
 */
public class InfoOffer extends Activity{

    TextView text_enseigne,date_d,date_fin,offer_desc;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_offer);
        text_enseigne = (TextView) findViewById(R.id.offer_text_enseigne);
        date_d = (TextView) findViewById(R.id.offer_dat_d);
        date_fin = (TextView) findViewById(R.id.offer_date_fin);
        offer_desc = (TextView) findViewById(R.id.offer_desc);


    }





    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}