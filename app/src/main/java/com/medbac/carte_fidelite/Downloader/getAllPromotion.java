package com.medbac.carte_fidelite.Downloader;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.medbac.carte_fidelite.Adapter.AdapterListPromotion;
import com.medbac.carte_fidelite.Models.Client;
import com.medbac.carte_fidelite.Models.Promotion;
import com.medbac.carte_fidelite.activity.InfoOffer;
import com.medbac.carte_fidelite.activity.MenuCarte;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Mohamed Nouira on 22/04/2015.
 */
public class getAllPromotion   {

    private static String url ;
    public static ArrayList<Promotion> ListPromotion  =null;
    ListView ListViewOffers;
    AdapterListPromotion adapter;


    private ProgressDialog pDialog;
    public static Promotion promotion1 = null;

    // clé
    private static final String TAG_promotion = "promotion";
    private static final String TAG_id_promotion = "id_promotion";
    private static final String TAG_descr_promo= "descr_promo";
    private static final String TAG_date_deb_promo = "date_deb_promo";
    private static final String TAG_date_fin_promo = "date_fin_promo";
    private static final String TAG_id_enseigne = "id_enseigne";

    // tableau json
    JSONArray promotion = null;

    Context context;





    public getAllPromotion(String url, Context context){
        this.context = context;
        this.url = url;
        new getAllPromotions().execute();

    }

    // Hashmap for ListView
	/*
	 * une table de hachage
	 * est une structure de données
	 * qui permet une association clé-élément, c'est-à-dire une implémentation
	 * du type abstrait table de symboles.
	 * On accède à chaque élément de la table via sa clé.*/



    /*
     * Une AsyncTask est ce qu'on appelle un UI Thread. Cela permet d'effectuer un traitement
     * en arrière plan sur une application Android sans ralentir la navigation, et de mettre
     * à jour l'interface de l'application en fin de traitement.
     *
     */
    private class getAllPromotions extends AsyncTask<Void, Void, Void> {

        String id_promotion;
        String descr_promo ;
        Date date_deb_promo ;
        Date date_fin_promo ;
        String id_enseigne;



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
			/*
	         * Cette fonction contiendra le code exécuté au préalable, par exemple:
	         *  -Affichage d'une ProgressBar
	         *      =rond qui tourne pour indiquer une attente
	         *      =Barre de progression
	         *  -...

            pDialog = new ProgressDialog(context);
            pDialog.setMessage("chargement... ");
            pDialog.setCancelable(false);
            pDialog.show();
*/
        }

        @Override
        protected Void doInBackground(Void... arg0) {
          	/*
	         * Ici, le code qui doit être exécuté dans l'AsyncTask, par exemple:
	         *  -Une requête de base de données
	         *  -Un appel à un Web Service
	         *  -...
	         */

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
                    ListPromotion= new ArrayList<Promotion>();

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

                        GetEnseigne gEnseigne = new GetEnseigne("http://mohamednouira.esy.es/getEnseigne.php", id_enseigne, context, i);

                       // getCompte gc = new getCompte("http://mohamednouira.esy.es/getCompte.php",id_client,context);
                        //client1.setCompte(gc.ListCompte);
                        //Log.e("samarche","add list compte to client");




                        } catch (Exception e) {
                            e.printStackTrace();

                        }
                        Log.e("samarche","add  ListPromotion");



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
			 /*
	         * Ici, le code exécuté une fois le traitement terminé, par exemple:
	         *  -Mise à jour de l'affichage
	         *  -Affichage d'une pop-up indiquant la fin du traitement
	         *  -Désactivation de la ProgressBar
	         *  -...

            // Désactivation de la ProgressBar
            if (pDialog.isShowing())
                pDialog.dismiss();
 */


           // adapter = new AdapterListPromotion(context, ListPromotion);
          //  ListViewOffers.setAdapter(adapter);


        }

    }

}
