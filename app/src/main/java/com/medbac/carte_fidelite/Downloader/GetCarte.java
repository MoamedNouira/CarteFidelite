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
import com.medbac.carte_fidelite.Models.Carte;
import com.medbac.carte_fidelite.activity.MenuCarte;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 19/03/2015.
 */
public class GetCarte{

private static String url ;

//private ProgressDialog pDialog;
Carte carte1 = null;


// clé
private static final String TAG_CLIENT = "carte";
private static final String TAG_id_carte = "id_carte";
private static final String TAG_nom = "nom";
private static final String TAG_descr_carte = "descr_carte";
private static final String TAG_type_carte = "type_carte";
private static final String TAG_id_enseigne = "id_enseigne";
private static final String TAG_id_categories = "id_categories";




// tableau json
JSONArray carte = null;
int compteur;
Context context;

    String id_cartex;


        public GetCarte(String url, String id_cartex, Context context, int compteur){
            this.context = context;

            this.url = url+"?id_carte=";;
            this.id_cartex = id_cartex;
            this.compteur = compteur;
            new GetCartes().execute();

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
private class GetCartes extends AsyncTask<Void, Void, Void> {

    String id_carte;
    String nom ;
    String descr_carte ;
    String type_carte ;
    String id_enseigne ;
    String id_categories ;



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
        Log.e("id cartedddddddddd",""+url+id_cartex);
        String jsonStr = sh.makeServiceCall(url+id_cartex, ServiceHandler.GET);

        Log.d("Response: Carte", "> " + jsonStr);

        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);

                // Get JSON Array
                carte = jsonObj.getJSONArray(TAG_CLIENT);





                // looping through All Contacts
                for (int i = 0; i < carte.length(); i++) {
                    JSONObject c = carte.getJSONObject(i);

                    id_carte = c.getString(TAG_id_carte);
                    nom = c.getString(TAG_nom);
                    descr_carte = c.getString(TAG_descr_carte);
                    type_carte = c.getString(TAG_type_carte);
                    id_enseigne = c.getString(TAG_id_enseigne);
                    id_categories = c.getString(TAG_id_categories);

                    carte1 = new Carte();

                    carte1.setId_carte(Integer.parseInt(id_carte));
                    carte1.setNom(nom);
                    carte1.setDescr_carte(descr_carte);
                    carte1.setType_carte(type_carte);
                    carte1.setId_categories(Integer.parseInt(id_categories));
                    carte1.setId_enseigne(Integer.parseInt(id_enseigne));
                    Log.e("samarchennnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn getCarte",carte1.getNom());

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

        getCompte.ListCompte.get(compteur).setCarte(carte1);

        Log.e("id compete apres getcarte ",""+ getCompte.ListCompte.get(compteur).getId_compte());
        carte1 = null;
//        Log.e("samarchennnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn",""+ carte1.getNom());
        // Désactivation de la ProgressBar
      //  if (pDialog.isShowing())
       //     pDialog.dismiss();


    }

}

}
