package com.medbac.carte_fidelite.Downloader;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.medbac.carte_fidelite.Models.Coordonnee;
import com.medbac.carte_fidelite.Models.Enseigne;
import com.medbac.carte_fidelite.activity.ListEnseigne;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Mohamed Nouira on 19/03/2015.
 */
public class getCoordonnee{

    private static String url ;

    //private ProgressDialog pDialog;
    public static ArrayList<Coordonnee> ListCoordonnee= new ArrayList<Coordonnee>();

    Coordonnee coordonnee1 ;
Enseigne enseigne1;
    ArrayList<Enseigne> ListEnseignes;

    // clé
    private static final String TAG_coordonnee= "coordonnee";

    private static final String TAG_id_coordonnee= "id_coordonnee";
    private static final String TAG_longitude = "longitude";
    private static final String TAG_latitude = "latitude";
    private static final String TAG_id_enseigne = "id_enseigne";





    // tableau json
    JSONArray coordonnee = null;
    int compteur;
    Context context;

    String id_coordonneex;
String s;

    public getCoordonnee(String url, String id_coordonneex, Context context, int compteur,Enseigne enseigne1, ArrayList<Enseigne> ListEnseignes,String s){
        this.context = context;
        this.url = url+"?id_enseigne=";
        this.id_coordonneex = ""+GetEnseigne.enseigne1.getId_enseigne();
        this.compteur = compteur;
        this.enseigne1=enseigne1;
        this.ListEnseignes=ListEnseignes;
        this.s=s;
        new GetCoordonnee().execute();

    }

    public getCoordonnee(String url, String id_coordonneex, Context context, int compteur,Enseigne enseigne1){
        this.context = context;
        this.url = url+"?id_enseigne=";
        this.id_coordonneex = ""+GetEnseigne.enseigne1.getId_enseigne();
        this.compteur = compteur;
        this.enseigne1=enseigne1;
        new GetCoordonnee().execute();

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
    private class GetCoordonnee extends AsyncTask<Void, Void, Void> {

        String id_coordonnee;
        String longitude ;
        String latitude ;
        String id_enseigne ;



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
            String jsonStr = sh.makeServiceCall(url+id_coordonneex, ServiceHandler.GET);

            Log.d("Response: coordonnee", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Get JSON Array
                    coordonnee = jsonObj.getJSONArray(TAG_coordonnee);


                    String id_coordonnee;
                    String longitude ;
                    String latitude ;
                    String id_enseigne ;


                    // looping through All Contacts
                    for (int i = 0; i < coordonnee.length(); i++) {
                        JSONObject c = coordonnee.getJSONObject(i);

                        id_coordonnee = c.getString(TAG_id_coordonnee);
                        longitude = c.getString(TAG_longitude);
                        latitude = c.getString(TAG_latitude);
                        id_enseigne = c.getString(TAG_id_enseigne);

                        coordonnee1 = new Coordonnee();

                        coordonnee1.setId_coordonnee(Integer.parseInt(id_coordonnee));
                        Double l = Double.parseDouble(longitude);
                        Double ll = Double.parseDouble(latitude);

                        coordonnee1.setLatitude(l);
                        coordonnee1.setLatitude(ll);

                        coordonnee1.setId_enseigne(Integer.parseInt(id_enseigne));

                        ListCoordonnee.add(coordonnee1);


                        // getAllPromotion.ListPromotion.add(getAllPromotion.promotion1);
                       // getAllPromotion.ListPromotion.get(compteur).setEnseigne(enseigne1);

                      //  Log.e("getensssssssssssssssss",""+ getAllPromotion.ListPromotion.get(compteur).getEnseigne().getNom_commercial());
                        //  GetCatégories gc = new GetCatégories("http://mohamednouira.esy.es/GetCategories.php",id_categories,context);
                        //   carte1.setCatégories(gc.catégories1);

                        // GetEnseigne gcC = new GetEnseigne("http://mohamednouira.esy.es/getEnseigne.php",id_enseigne,context);
                        //carte1.setEnseigne(gcC.enseigne1);

                    }
                   enseigne1.setCoordonnee(ListCoordonnee);
            Log.e("mmmmmmmmmmmmmmmmmmmmmmmmmmm",""+enseigne1.getNom_commercial() +" "+ enseigne1.getCoordonnee().get(0).getLatitude());
            if(s=="list"){
                ListEnseignes.add(enseigne1);

            }

                }
                catch (JSONException e) {
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

         //   Log.e("zzzzzzzzzzzzzzzzzzzzzzzzzzz",""+ GetEnseigne.enseigne1.getId_enseigne());

            //GetEnseigne.enseigne1.setCoordonnee(ListCoordonnee);

//             Log.e("zzzeeeeeeezzzzzzzzzzzzzzzzzzzzzzzz",""+ ListCoordonnee.get(0).getLatitude());


        //    coordonnee1 = null;

//        Log.e("samarchennnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn",""+ carte1.getNom());
            // Désactivation de la ProgressBar
            //  if (pDialog.isShowing())
            //     pDialog.dismiss();


        }

    }

}
