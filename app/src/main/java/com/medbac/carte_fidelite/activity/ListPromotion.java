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

    private static String url = "http://mohamednouira.esy.es/getAllPromotion.php";
    private ProgressDialog pDialog;
    private Promotion promotion1 = null;
    // clé
    private static final String TAG_promotion = "promotion";
    private static final String TAG_id_promotion = "id_promotion";
    private static final String TAG_descr_promo = "descr_promo";
    private static final String TAG_date_deb_promo = "date_deb_promo";
    private static final String TAG_date_fin_promo = "date_fin_promo";
    private static final String TAG_id_enseigne = "id_enseigne";
    // tableau json
    JSONArray promotion = null;
    public static ArrayList<Promotion> ListPromotions;

    ListView ListViewOffers;
    AdapterListPromotion adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_promorion);
        ListViewOffers = (ListView) findViewById(R.id.listView_offers);
        ListViewOffers.setOnItemClickListener(this);

        ListPromotions = new ArrayList<Promotion>();
        new GetPromotion().execute();

    }

    @Override

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       Enseigne enseigne = new Enseigne();
        enseigne=ListPromotions.get(position).getEnseigne();
       Intent i = new Intent(ListPromotion.this, InfoOffer.class);

        i.putExtra("id_enseigne", ListPromotions.get(position).getId_enseigne());
        i.putExtra("nom_enseigne", ListPromotions.get(position).getEnseigne().getNom_commercial());
        i.putExtra("id_promotion", ListPromotions.get(position).getId_promotion());
        i.putExtra("descr_promo", ListPromotions.get(position).getDescr_promo());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date today =  ListPromotions.get(position).getDate_deb_promo();
        Date today2 = ListPromotions.get(position).getDate_fin_promo();

        String reportDate = formatter.format(today);
        String reportDate2 = formatter.format(today2);



        i.putExtra("date_deb_promo",reportDate);
        i.putExtra("date_fin_promo",reportDate2);



        startActivity(i);
    }




    private class GetPromotion extends AsyncTask<Void, Void, Void> {
        String id_promotion;
        String descr_promo ;
        Date date_deb_promo ;
        Date date_fin_promo ;
        String id_enseigne;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(ListPromotion.this);
            pDialog.setMessage("chargement... ");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {

            // service handler : parse
            ServiceHandler sh = new ServiceHandler();

            // get response
            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Get JSON Array
                    promotion = jsonObj.getJSONArray(TAG_promotion);


                    // looping through All Contacts
                    for (int i = 0; i < promotion.length(); i++) {
                        JSONObject c = promotion.getJSONObject(i);

                        try {

                            String id_promotion;
                            String descr_promo ;
                            Date date_deb_promo ;
                            Date date_fin_promo ;
                            String id_enseigne;




                            id_promotion = c.getString(TAG_id_promotion);
                            descr_promo = c.getString(TAG_descr_promo);


                            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                            String dateInString = c.getString(TAG_date_deb_promo);
                            date_deb_promo = formatter.parse(dateInString);

                            String dateInString2 = c.getString(TAG_date_fin_promo);
                            date_fin_promo = formatter.parse(dateInString2);

                            //  date_deb_promo = c.getString(TAG_date_deb_promo);
                            //date_fin_promo = c.getString(TAG_date_fin_promo);
                            id_enseigne = c.getString(TAG_id_enseigne);


                            promotion1 = new Promotion();

                            promotion1.setId_promotion(Integer.parseInt(id_promotion));
                            promotion1.setDescr_promo(descr_promo);
                            promotion1.setDate_deb_promo(date_deb_promo);
                            promotion1.setDate_fin_promo(date_fin_promo);
                            promotion1.setId_enseigne(Integer.parseInt(id_enseigne));


                            // getCompte gc = new getCompte("http://mohamednouira.esy.es/getCompte.php",id_client,context);
                            //client1.setCompte(gc.ListCompte);
                            //Log.e("samarche","add list compte to client");

                            ListPromotions.add(promotion1);
                        //    Log.e("GetEnseigneGetEnseigne", ""+id_enseigne);

                           GetEnseigne gEnseigne = new GetEnseigne("http://mohamednouira.esy.es/getEnseigne.php", id_enseigne, context, i);


                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                        // adding each child node to HashMap key => value
                        Log.e("samarche", "samarchefffffffffffff");

                        // adding contact to contact list

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(context, "eerreurr !!", Toast.LENGTH_SHORT).show();
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            if (pDialog.isShowing())
                pDialog.dismiss();

            adapter = new AdapterListPromotion(ListPromotion.this, ListPromotions);
            ListViewOffers.setAdapter(adapter);





        }


    }



}

