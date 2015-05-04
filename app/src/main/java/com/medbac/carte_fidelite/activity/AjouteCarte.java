package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 03/05/2015.
 */


public class AjouteCarte extends Activity {

    Button scanner;
    Button valider;
    String nom_carte,nom_enseigne,des;
    TextView text_nom_carte,text_nom_enseigne,text_des;
    int id_carte,id_client;
    EditText text_code_barre;
    String code_barre;
    Context c;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajoute_carte);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        scanner = (Button)  findViewById(R.id.a_barrcode);
        valider = (Button)  findViewById(R.id.a_Valider);
        text_nom_carte = (TextView)  findViewById(R.id.a_nom_carte);
        text_nom_enseigne = (TextView)  findViewById(R.id.a_nom_enseigne);
        text_des = (TextView)  findViewById(R.id.a_des);
        text_code_barre=(EditText)  findViewById(R.id.a_s_barrcode);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            nom_carte = extras.getString("nom_carte");
            id_carte = extras.getInt("id_carte");
            id_client = extras.getInt("id_client");
            des = extras.getString("des");
            nom_enseigne = extras.getString("nom_ens");
    }

        text_nom_carte.setText(nom_carte);
        text_nom_enseigne.setText(nom_enseigne);
        text_des.setText(des);

        scanner.setOnClickListener( new OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(AjouteCarte.this, Barrecode.class);
                startActivityForResult(i, 3);
            }
        });


        valider.setOnClickListener( new OnClickListener() {

            @Override
            public void onClick(View v) {

                if (text_code_barre.equals("") ) {
                    text_code_barre.setError("code barre de carte est obligatoire");


                } else {


                    Log.e("click" ,"OK OK OK");


                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost("http://mohamednouira.esy.es/setCarteN.php");
                    ArrayList<NameValuePair> client = new ArrayList<NameValuePair>();


                    client.add(new BasicNameValuePair("id_client",Integer.toString(id_client)));
                    client.add(new BasicNameValuePair("id_carte",Integer.toString(id_carte)));
                    client.add(new BasicNameValuePair("code_barre",text_code_barre.getText().toString()));



                    try {
                        httpPost.setEntity(new UrlEncodedFormEntity(client));
                        HttpResponse httpRespose = httpClient.execute(httpPost);
                        Log.e("ss", "ee");
                        HttpEntity httpEntity = httpRespose.getEntity();
                        InputStream in = httpEntity.getContent();
                        BufferedReader read = new BufferedReader(new InputStreamReader(in));

                        String isi = "";
                        String baris = "";

                        while ((baris = read.readLine()) != null) {
                            isi += baris;
                        }

                        //Jika isi tidak sama dengan "null " maka akan tampil Toast "Berhasil" sebaliknya akan tampil "Gagal"
                        if (!isi.equals("null")) {
                            Toast.makeText(AjouteCarte.this, "Berhasil", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(AjouteCarte.this, "Gagal", Toast.LENGTH_LONG).show();
                        }

                        Toast.makeText(AjouteCarte.this, "les donnees sont enregistrées", Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(AjouteCarte.this, MenuCarte.class);
                        startActivity(i);


                    } catch (Exception e) {
                        Log.e("log_tag", "Error in http connection :" + e.toString());
                    }






                }



            }
        });



}



    public void onActivityResult(int request,int result, Intent data){

        super.onActivityResult(request, result, data);

        if (request == 3) {

            if(result == Activity.RESULT_OK){
                code_barre=data.getStringExtra("code");
                text_code_barre.setText(code_barre);
            }
            if (result == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }

    }










}
