package com.medbac.carte_fidelite.Downloader;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.medbac.carte_fidelite.Models.Carte;
import com.medbac.carte_fidelite.Models.Client;
import com.medbac.carte_fidelite.Models.Compte;
import com.medbac.carte_fidelite.activity.MenuCarte;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Mohamed Nouira on 26/03/2015.
 */
public class getCompte {



    private static String url ;

    public static  ArrayList<Compte> ListCompte = new ArrayList<Compte>();

    private ProgressDialog pDialog;
    public static Compte compte1 = null;
    public static ArrayList<Carte> ListCompteCarte ;

    // clé
    private static final String TAG_compte = "compte";
    private static final String TAG_id_compte = "id_compte";
    private static final String TAG_code_barre = "code_barre";
    private static final String TAG_montant= "montant";
    private static final String TAG_nb_point = "nb_point";
    private static final String TAG_id_client = "id_client";
    private static final String TAG_id_carte = "id_carte";


    // tableau json
    JSONArray compte = null;

    Context context;




    public getCompte(String url,String id_client, Context context){
        this.context = context;
        this.url = url+"?id_client="+id_client;

        new getComptes().execute();

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
    private class getComptes extends AsyncTask<Void, Void, Void> {



        String id_compte;
        String code_barre ;
        String montant ;
        String nb_point ;
        String id_client;
        String id_carte ;


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
            //pDialog.setCancelable(false);
            //pDialog.show();

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
                    compte = jsonObj.getJSONArray(TAG_compte);

                    ListCompteCarte = new ArrayList<Carte>() ;

                    // looping through All Contacts
                    for (int i = 0; i < compte.length(); i++) {
                        JSONObject c = compte.getJSONObject(i);


                        String id_compte;
                        String code_barre ;
                        String montant ;
                        String nb_point ;
                        String id_client;
                        String id_carte ;

                        id_compte = c.getString(TAG_id_compte);
                        code_barre = c.getString(TAG_code_barre);
                        montant = c.getString(TAG_montant);
                        nb_point = c.getString(TAG_nb_point);
                        id_client = c.getString(TAG_id_client);
                        id_carte = c.getString(TAG_id_carte);


                       compte1 = new Compte();
                       compte1.setId_compte(Integer.parseInt(id_compte));
                       compte1.setCode_barre(Integer.parseInt(code_barre));
                       compte1.setMontant(Integer.parseInt(montant));
                       compte1.setNb_point(Integer.parseInt(nb_point));

                        compte1.setId_client(Integer.parseInt(id_client));

                        compte1.setId_carte(Integer.parseInt(id_carte));

                        compte1.setClient(GetClient.client1);

                        GetCarte gcarte = new GetCarte("http://mohamednouira.esy.es/getCarte.php", id_carte, context);







                        // Phone node is JSON Object

                        /*

                        JSONObject phone = c.getJSONObject(TAG_PHONE);
                        String mobile = phone.getString(TAG_PHONE_MOBILE);
                        String home = phone.getString(TAG_PHONE_HOME);
                        String office = phone.getString(TAG_PHONE_OFFICE);

	         */
                        // tmp hashmap for single contact




                        // adding each child node to HashMap key => value

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
			 /*
	         * Ici, le code exécuté une fois le traitement terminé, par exemple:
	         *  -Mise à jour de l'affichage
	         *  -Affichage d'une pop-up indiquant la fin du traitement
	         *  -Désactivation de la ProgressBar
	         *  -...
	         */
            // Désactivation de la ProgressBar
       //     if (pDialog.isShowing())
         //       pDialog.dismiss();





       /*
            */

            /**
             * Updating parsed JSON data into ListView
             */

        }

    }


}
