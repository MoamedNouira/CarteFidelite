package com.medbac.carte_fidelite.Downloader;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.medbac.carte_fidelite.Models.Client;
import com.medbac.carte_fidelite.activity.Login;
import com.medbac.carte_fidelite.activity.MenuCarte;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 19/03/2015.
 */
public class GetClient  {

    private static String url ;

    private ProgressDialog pDialog;
    public static Client client1 = null;
   // clé
    private static final String TAG_CLIENT = "client";
    private static final String TAG_ID_CLIENT = "id_client";
    private static final String TAG_NOM = "nom";
    private static final String TAG_PRENOM = "prenom";
    private static final String TAG_LOGIN = "login";
    private static final String TAG_PASSWORD = "password";
    private static final String TAG_CIN = "cin";
    private static final String TAG_ADR = "adr";
    private static final String TAG_TELL = "tell";
    private static final String TAG_MAIL = "mail";
    private static final String TAG_CODE_POSTAL = "code_postal";

    // tableau json
    JSONArray client = null;

    Context context;




    public GetClient(String url, String login, String password, Context context){
        this.context = context;
        this.url = url+"?login="+login+"&password="+password;;

        new GetClients().execute();

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
    private class GetClients extends AsyncTask<Void, Void, Void> {

        String id_client;
        String nom ;
        String prenom ;
        String login ;
        String password;
        String cin ;
        String adr ;
        String tell ;
        String mail;
        String code_postal ;


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
            pDialog = new ProgressDialog(context);
            pDialog.setMessage("chargement... ");
            pDialog.setCancelable(false);
            pDialog.show();

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
                    client = jsonObj.getJSONArray(TAG_CLIENT);


                    // looping through All Contacts
                    for (int i = 0; i < client.length(); i++) {
                        JSONObject c = client.getJSONObject(i);

                         id_client = c.getString(TAG_ID_CLIENT);
                         nom = c.getString(TAG_NOM);
                         prenom = c.getString(TAG_PRENOM);
                         login = c.getString(TAG_LOGIN);
                         password = c.getString(TAG_PASSWORD);
                         cin = c.getString(TAG_CIN);
                         adr = c.getString(TAG_ADR);
                         tell = c.getString(TAG_TELL);
                         mail = c.getString(TAG_MAIL);
                         code_postal = c.getString(TAG_CODE_POSTAL);

                        client1 = new Client();

                        client1.setId_clinet(Integer.parseInt(id_client));
                        client1.setNom(nom);
                        client1.setPrenom(prenom);
                        client1.setAdr(adr);
                        client1.setCin(Integer.parseInt(cin));
                        client1.setCode_postal(Integer.parseInt(code_postal));
                        client1.setLogin(login);
                        client1.setMail(mail);
                        client1.setPassword(password);
                        client1.setTell(Integer.parseInt(tell));

                      getCompte gc = new getCompte("http://mohamednouira.esy.es/getCompte.php",id_client,context);

                      client1.setCompte(gc.ListCompte);

                        Log.e("samarche","add list compte to client");


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
            if (pDialog.isShowing())
                pDialog.dismiss();



            if(GetClient.client1 == null){
                Toast.makeText(context, "rrrrrrrrrrrrrrrr", Toast.LENGTH_LONG).show();
            }else{

                Intent ii = new Intent(context, MenuCarte.class);
                context.startActivity(ii);}
        }

    }

}
