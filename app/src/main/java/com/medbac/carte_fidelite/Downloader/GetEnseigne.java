package com.medbac.carte_fidelite.Downloader;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import com.medbac.carte_fidelite.Adapter.AdapterListPromotion;
import com.medbac.carte_fidelite.Models.Carte;
import com.medbac.carte_fidelite.activity.MenuCarte;
import com.medbac.carte_fidelite.Models.Enseigne;
import com.medbac.carte_fidelite.activity.ListPromotion;
import com.medbac.carte_fidelite.activity.MenuCarte;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 19/03/2015.
 */
public class GetEnseigne{

    private static String url ;

    //private ProgressDialog pDialog;
    Enseigne enseigne1 ;


    // clé
    private static final String TAG_enseigne= "enseigne";

    private static final String TAG_id_enseigne = "id_enseigne";
    private static final String TAG_nom_commercial = "nom_commercial";
    private static final String TAG_adresse = "adresse";
    private static final String TAG_vlle = "vile";
    private static final String TAG_code_postal= "code_postal";
    private static final String TAG_tell = "tell";
    private static final String TAG_mail = "mail";




    // tableau json
    JSONArray enseigne = null;
    int compteur;
    Context context;

    String id_enseignex;

    String test;
    public GetEnseigne(String url, String id_enseignex, Context context, int compteur){
        this.context = context;
        this.url = url+"?id_enseigne=";;
        this.id_enseignex = ""+getAllPromotion.promotion1.getId_enseigne();
        this.compteur = compteur;
        new GetEnseignes().execute();

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
    private class GetEnseignes extends AsyncTask<Void, Void, Void> {

        String id_enseigne;
        String nom_commercial ;
        String adresse ;
        String vlle ;
        String code_postal;
        String tell ;
        String mail ;



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
			/*
	         * Cette fonction contiendra le code exécuté au préalable, par exemple:
	         *  -Affichage d'une ProgressBar
	         *      =rond qui tourne pour indiquer une attente
	         *      =Barre de progression
	         *  -...
	         */
            // pDialog = new ProgressDialog(context);
            //pDialog.setMessage("chargement... ");
            // pDialog.setCancelable(false);
            // pDialog.show();

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
            String jsonStr = sh.makeServiceCall(url+id_enseignex, ServiceHandler.GET);

            Log.d("Response: enseigne", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Get JSON Array
                    enseigne = jsonObj.getJSONArray(TAG_enseigne);





                    // looping through All Contacts
                    for (int i = 0; i < enseigne.length(); i++) {
                        JSONObject c = enseigne.getJSONObject(i);

                        id_enseigne = c.getString(TAG_id_enseigne);
                        nom_commercial = c.getString(TAG_nom_commercial);
                        adresse = c.getString(TAG_adresse);
                        vlle = c.getString(TAG_vlle);
                        code_postal = c.getString(TAG_code_postal);
                        tell = c.getString(TAG_tell);
                        mail = c.getString(TAG_mail);

                        enseigne1 = new Enseigne();

                        enseigne1.setId_enseigne(Integer.parseInt(id_enseigne));
                        enseigne1.setNom_commercial(nom_commercial);
                        enseigne1.setAdresse(adresse);
                        enseigne1.setVile(vlle);
                        enseigne1.setCode_postal(Integer.parseInt(code_postal));
                        enseigne1.setTell(Integer.parseInt(tell));
                        enseigne1.setMail(mail);

                        getAllPromotion.ListPromotion.add(getAllPromotion.promotion1);
                        getAllPromotion.ListPromotion.get(compteur).setEnseigne(enseigne1);

                        Log.e("getensssssssssssssssss",""+ getAllPromotion.ListPromotion.get(compteur).getEnseigne().getNom_commercial());
                        //  GetCatégories gc = new GetCatégories("http://mohamednouira.esy.es/GetCategories.php",id_categories,context);
                        //   carte1.setCatégories(gc.catégories1);

                        // GetEnseigne gcC = new GetEnseigne("http://mohamednouira.esy.es/getEnseigne.php",id_enseigne,context);
                        //carte1.setEnseigne(gcC.enseigne1);




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
	         */



         //   Log.e("ServiceHandler", "okokokokok"+  enseigne1.getId_enseigne());



            enseigne1 = null;

//        Log.e("samarchennnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn",""+ carte1.getNom());
            // Désactivation de la ProgressBar
            //  if (pDialog.isShowing())
            //     pDialog.dismiss();


        }

    }

}
