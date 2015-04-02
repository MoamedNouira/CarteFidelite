package com.medbac.carte_fidelite.Downloader;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.medbac.carte_fidelite.Models.Enseigne;
import com.medbac.carte_fidelite.activity.MenuCarte;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Mohamed Nouira on 02/04/2015.
 */
public class GetEnseigne {

    private static String url ;

    private ProgressDialog pDialog;
    public  Enseigne enseigne1 = null;
    // clé
    private static final String TAG_enseigne= "enseigne";
    private static final String TAG_id_enseigne = "id_enseigne";
    private static final String TAG_nom_commercial = "nom_commercial";
    private static final String TAG_adresse = "adresse";
    private static final String TAG_vlle = "vlle";
    private static final String TAG_code_postal= "code_postal";
    private static final String TAG_tell = "tell";
    private static final String TAG_mail = "mail";



    // tableau json
    JSONArray enseigne = null;

    Context context;




    public GetEnseigne(String url, String id_enseigne, Context context){
        this.context = context;
        this.url = url+"?id_enseigne="+id_enseigne;

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
          //  pDialog = new ProgressDialog(context);
         //   pDialog.setMessage("chargement... ");
         //   pDialog.setCancelable(false);
         //   pDialog.show();

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

                      //  getCompte gc = new getCompte("http://mohamednouira.esy.es/getCompte.php",id_client,context);

                       // client1.setCompte(gc.ListCompte);

                        Log.e("samarche","add enseigne1");


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
            //    pDialog.dismiss();




        }

    }

}
