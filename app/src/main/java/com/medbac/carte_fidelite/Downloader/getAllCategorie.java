package com.medbac.carte_fidelite.Downloader;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.medbac.carte_fidelite.Adapter.AdapterListAjouteCarteCat;
import com.medbac.carte_fidelite.Models.Catégories;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 07/04/2015.
 */
public class getAllCategorie  {

    private static String url ;
    public static ArrayList<Catégories> listCat = null;
    private ListView ListViewAjouteCarteCat;
    //private ProgressDialog pDialog;
    public static Catégories catégories1 = null;


    // clé
    private static final String TAG_categories = "categories";
    private static final String TAG_id_categories = "id_categories";
    private static final String TAG_nom_cat = "nom_cat";




    // tableau json
    JSONArray categories = null;

    Context context;





    public getAllCategorie(String url, Context context){
        this.context = context;
        this.url = url;

        new GetCategorie().execute();

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
    private class GetCategorie extends AsyncTask<Void, Void, Void> {

        String id_categories;
        String nom_cat ;



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
            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Get JSON Array
                       categories = jsonObj.getJSONArray(TAG_categories);

                     ArrayList<Catégories> listCat = new ArrayList<Catégories>();
                    // looping through All Contacts
                    for (int i = 0; i < categories.length(); i++) {
                        JSONObject c = categories.getJSONObject(i);
                        id_categories = c.getString(TAG_id_categories);
                        nom_cat = c.getString(TAG_nom_cat);

                        Catégories catégories1 = new Catégories();
                        catégories1.setId_catégories(Integer.parseInt(id_categories));
                        catégories1.setNom_cat(nom_cat);

                        listCat.add(catégories1);

                        Log.e(" catcatcatcatcatcatcat", "" + listCat.size());

                        Log.e("ServiceHandler", "jjjjjjjjjjjjjjjjj");

                     //   AdapterListAjouteCarteCat adapter = new AdapterListAjouteCarteCat(context, listCat);
                  //      ListView ListViewAjouteCarteCat = (ListView)((Activity)context).findViewById(R.id.listViewAjouteCarteCat);
//                        ListViewAjouteCarteCat.setAdapter(adapter);


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
            // Désactivation de la ProgressBar
            //  if (pDialog.isShowing())
            //     pDialog.dismiss();

        }

    }

}
