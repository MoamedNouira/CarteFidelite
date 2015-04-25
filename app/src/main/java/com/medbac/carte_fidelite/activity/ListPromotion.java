package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

import com.medbac.carte_fidelite.Adapter.AdapterListPromotion;
import com.medbac.carte_fidelite.Downloader.GetEnseigne;
import com.medbac.carte_fidelite.Downloader.ServiceHandler;
import com.medbac.carte_fidelite.Downloader.getAllPromotion;
import com.medbac.carte_fidelite.Models.Promotion;
import com.medbac.carte_fidelite.Models.Enseigne;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 05/04/2015.
 */
public class ListPromotion extends Activity  implements AdapterView.OnItemClickListener  {

    Context context;


    ArrayList<Promotion> ListPromotions;
    ArrayList<Promotion> ListPromotions2;
      ListView ListViewOffers;
      AdapterListPromotion adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_promorion);
        ListViewOffers = (ListView) findViewById(R.id.listView_offers);
        ArrayList <Promotion> ListPromotions =new ArrayList<Promotion>();
        ListPromotions = getAllPromotion.ListPromotion;

         adapter = new AdapterListPromotion(this,ListPromotions);
         ListViewOffers.setAdapter(adapter);

         Log.e("nom commer", ""+ListPromotions.size());

         ListViewOffers.setOnItemClickListener(this);

    }

    @Override

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        ListPromotions2 = getAllPromotion.ListPromotion;
        Intent i = new Intent(ListPromotion.this, InfoOffer.class);

        Log.e("nom commer", ""+ListPromotions2.size());

        Log.e("nom commer",""+ ListPromotions2.get(position).getId_enseigne());

        i.putExtra("id_enseigne",  ListPromotions2.get(position).getId_enseigne());
        i.putExtra("nom_enseigne", ListPromotions2.get(position).getEnseigne().getNom_commercial());
        i.putExtra("id_promotion", ListPromotions2.get(position).getId_promotion());
        i.putExtra("descr_promo", ListPromotions2.get(position).getDescr_promo());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date today =  ListPromotions2.get(position).getDate_deb_promo();
        Date today2 = ListPromotions2.get(position).getDate_fin_promo();
        String reportDate = formatter.format(today);
        String reportDate2 = formatter.format(today2);
        i.putExtra("date_deb_promo",reportDate);
        i.putExtra("date_fin_promo",reportDate2);

        startActivity(i);
    }







}

