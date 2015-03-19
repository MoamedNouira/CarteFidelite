package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 06/03/2015.
 */
public class MenuCarte extends Activity {

    private ProgressDialog pDialog;

    // URL
    private static String url = "http://mohamednouira.esy.es/getClient.php";

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
    JSONArray contacts = null;
    ListView lv;

    // Hashmap for ListView
	/*
	 * une table de hachage
	 * est une structure de données
	 * qui permet une association clé-élément, c'est-à-dire une implémentation
	 * du type abstrait table de symboles.
	 * On accède à chaque élément de la table via sa clé.*/

    ArrayList<HashMap<String, String>> contactList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_carte);
         lv = (ListView) findViewById(R.id.listView);

        contactList = new ArrayList<HashMap<String, String>>();

        // Calling async task to get json
        new GetContacts().execute();
    }

    /*
     * Une AsyncTask est ce qu'on appelle un UI Thread. Cela permet d'effectuer un traitement
     * en arrière plan sur une application Android sans ralentir la navigation, et de mettre
     * à jour l'interface de l'application en fin de traitement.
     *
     */
    private class GetContacts extends AsyncTask<Void, Void, Void> {

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
            pDialog = new ProgressDialog(MenuCarte.this);
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
                    contacts = jsonObj.getJSONArray(TAG_CLIENT);

                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

                        String id_client = c.getString(TAG_ID_CLIENT);
                        String nom = c.getString(TAG_NOM);
                        String prenom = c.getString(TAG_PRENOM);
                        String login = c.getString(TAG_LOGIN);
                        String password = c.getString(TAG_PASSWORD);
                        String cin = c.getString(TAG_CIN);
                        String adr = c.getString(TAG_ADR);
                        String tell = c.getString(TAG_TELL);
                        String mail = c.getString(TAG_MAIL);
                        String code_postal = c.getString(TAG_CODE_POSTAL);

                        // Phone node is JSON Object

                        /*

                        JSONObject phone = c.getJSONObject(TAG_PHONE);
                        String mobile = phone.getString(TAG_PHONE_MOBILE);
                        String home = phone.getString(TAG_PHONE_HOME);
                        String office = phone.getString(TAG_PHONE_OFFICE);

	         */
                        // tmp hashmap for single contact
                        HashMap<String, String> contact = new HashMap<String, String>();

                        // adding each child node to HashMap key => value
                        contact.put(TAG_ID_CLIENT, id_client);
                        contact.put(TAG_NOM, nom);
                        contact.put(TAG_PRENOM, prenom);
                        contact.put(TAG_MAIL, mail);


                        // adding contact to contact list
                        contactList.add(contact);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
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
/*            TextView t1 = (EditText) findViewById(R.id.editText5);
            TextView t2 = (EditText) findViewById(R.id.editText6);
            TextView t3 = (EditText) findViewById(R.id.editText7);
            TextView t4 = (EditText) findViewById(R.id.editText8);

            t1.setText(contactList.get(0).get(TAG_ID_CLIENT));
            t2.setText(contactList.get(0).get(TAG_NOM));
            t3.setText(contactList.get(0).get(TAG_PRENOM));
            t4.setText(contactList.get(0).get(TAG_MAIL));

            */

            /**
             * Updating parsed JSON data into ListView
             */
            ListAdapter adapter = new SimpleAdapter(
                    MenuCarte.this, contactList,
                    R.layout.item,
                    new String[] { TAG_ID_CLIENT, TAG_NOM, TAG_PRENOM }, new int[] { R.id.textView5,
                    R.id.textView6, R.id.textView7 });


            lv.setAdapter(adapter);
        }

    }

}
