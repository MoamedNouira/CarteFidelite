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

import com.medbac.carte_fidelite.Adapter.AdapterListEnseigne;
import com.medbac.carte_fidelite.Adapter.AdapterListPromotion;
import com.medbac.carte_fidelite.Downloader.GetEnseigne;
import com.medbac.carte_fidelite.Downloader.ServiceHandler;
import com.medbac.carte_fidelite.Downloader.getAllPromotion;
import com.medbac.carte_fidelite.Downloader.getCoordonnee;
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
public class ListEnseigne extends Activity  implements AdapterView.OnItemClickListener  {

    Context context;

    private static String url = "http://mohamednouira.esy.es/getAllEnseigne.php";
    private ProgressDialog pDialog;
    public static Enseigne enseigne1 = null;
    // clé
    private static final String TAG_enseigne= "enseigne";
    private static final String TAG_id_enseigne = "id_enseigne";
    private static final String TAG_nom_commercial = "nom_commercial";
    private static final String TAG_adresse = "adresse";
    private static final String TAG_vile = "vile";
    private static final String TAG_code_postal= "code_postal";
    private static final String TAG_tell = "tell";
    private static final String TAG_mail = "mail";
    // tableau json
    JSONArray enseigne = null;
    public static ArrayList<Enseigne> ListEnseignes;

    ListView ListViewEnseigne;
    AdapterListEnseigne adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enseigne);
        ListViewEnseigne = (ListView) findViewById(R.id.listView_enseigne);
        ListViewEnseigne.setOnItemClickListener(this);

        ListEnseignes = new ArrayList<Enseigne>();
        new GetEnseigne().execute();

    }

    @Override

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

         Intent i = new Intent(ListEnseigne.this, InfoEnseigne.class);
       Log.e("GetEnseigneGetEnseigneGetEnseigneGetEnseigneGetEnseigneGetEnseigne", ""+ ListEnseignes.get(position).getNom_commercial());

         i.putExtra("id_enseigne", ListEnseignes.get(position).getId_enseigne());
         i.putExtra("nom_commercial", ListEnseignes.get(position).getNom_commercial());
          i.putExtra("adresse", ListEnseignes.get(position).getAdresse());
        i.putExtra("vile",ListEnseignes.get(position).getVile());
        i.putExtra("code_postal",ListEnseignes.get(position).getCode_postal());
         i.putExtra("tell",ListEnseignes.get(position).getTell());
          i.putExtra("mail",ListEnseignes.get(position).getMail());
         startActivity(i);

    }




    private class GetEnseigne extends AsyncTask<Void, Void, Void> {
        String id_enseigne;
        String nom_commercial ;
        String adresse ;
        String vile ;
        String code_postal;
        String tell ;
        String mail ;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(ListEnseigne.this);
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
                    enseigne = jsonObj.getJSONArray(TAG_enseigne);


                    // looping through All Contacts
                    for (int i = 0; i < enseigne.length(); i++) {
                        JSONObject c = enseigne.getJSONObject(i);

                        try {

                            String id_enseigne;
                            String nom_commercial ;
                            String adresse ;
                            String vile ;
                            String code_postal;
                            String tell ;
                            String mail ;



                            id_enseigne = c.getString(TAG_id_enseigne);
                            nom_commercial = c.getString(TAG_nom_commercial);
                            adresse = c.getString(TAG_adresse);
                            vile = c.getString(TAG_vile);
                            code_postal = c.getString(TAG_code_postal);
                            tell = c.getString(TAG_tell);
                            mail = c.getString(TAG_mail);


                            enseigne1 = new Enseigne();

                            enseigne1.setId_enseigne(Integer.parseInt(id_enseigne));
                            enseigne1.setNom_commercial(nom_commercial);
                            enseigne1.setAdresse(adresse);
                            enseigne1.setVile(vile);
                            enseigne1.setCode_postal(Integer.parseInt(code_postal));
                            enseigne1.setTell(Integer.parseInt(tell));
                            enseigne1.setMail(mail);
                            ListEnseignes.add(enseigne1);

                            //   getCoordonnee getc = new getCoordonnee("http://mohamednouira.esy.es/getCoordonnee.php",id_enseigne,context,i,enseigne1,ListEnseignes,"list");

                            //Log.e("samarche","add list compte to client");


                            Log.e("ffffffffffffffffffffffffffffffffffff",""+ListEnseignes.get(i).getCoordonnee().get(i).getLatitude());



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

            adapter = new AdapterListEnseigne(ListEnseigne.this, ListEnseignes);
            ListViewEnseigne.setAdapter(adapter);





        }


    }



}

