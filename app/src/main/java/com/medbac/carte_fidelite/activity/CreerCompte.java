package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
 * Created by Mohamed Nouira on 06/03/2015.
 */
public class CreerCompte extends Activity {
    EditText id, password, password_r, mail;
    Button creer_mon_compte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creer_compte);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        id = (EditText) findViewById(R.id.compte_id);
        mail = (EditText) findViewById(R.id.compte_mail);
        password = (EditText) findViewById(R.id.compte_pwd);
        password_r = (EditText) findViewById(R.id.compte_rpwd);
        creer_mon_compte = (Button) findViewById(R.id.bt_compte_compte);

    }

    public void onClick(View v) {
        if (v.getId() == creer_mon_compte.getId()) {

            String Sid = id.getText().toString();
            String Smail = mail.getText().toString();

            String Spassword = password.getText().toString();
            String Spassword_r = password_r.getText().toString();

/*
            if ( testt == null) {
                test.setError("Identifiant est obligatoire");
            }



            if (Smail == null || Smail == "") {
                mail.setError("e-mail est obligatoire");
            }
            ;

            if (Spassword == null || Spassword == "") {
                password.setError("Mot de passe est obligatoire");
            }
            ;

            if (Spassword_r == null || Spassword_r == "" || Spassword_r != Spassword) {
                password_r.setError("Répéter mot passe est obligatoire");
            }
            ;
        }
       if (x == 0) {
*/

            //   InputStream is = null;


            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://mohamednouira.esy.es/setClient.php");
            ArrayList<NameValuePair> client = new ArrayList<NameValuePair>();


            client.add(new BasicNameValuePair("nom", id.getText().toString()));
            client.add(new BasicNameValuePair("login", id.getText().toString()));
            client.add(new BasicNameValuePair("password", password.getText().toString()));
            client.add(new BasicNameValuePair("mail", mail.getText().toString()));

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
                    Toast.makeText(this, "Berhasil", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Gagal", Toast.LENGTH_LONG).show();
                }

                Toast.makeText(this, "les donnees sont enregistrées", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(this, Login.class);
                startActivity(i);


            } catch (Exception e) {
                Log.e("log_tag", "Error in http connection :" + e.toString());
            }

        }



    }

    }


