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
    EditText id, password, password_r, prenom, nom, tell, code_postal, cin, adr, mail;
    Button creer_mon_compte;
    boolean test = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creer_compte);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        id = (EditText) findViewById(R.id.editText3);
        password = (EditText) findViewById(R.id.editText4);
        password_r = (EditText) findViewById(R.id.editText5);
        prenom = (EditText) findViewById(R.id.editText6);
        nom = (EditText) findViewById(R.id.editText7);
        tell = (EditText) findViewById(R.id.editText8);
        code_postal = (EditText) findViewById(R.id.editText9);
        cin = (EditText) findViewById(R.id.editText10);
        adr = (EditText) findViewById(R.id.editText11);
        mail = (EditText) findViewById(R.id.editText12);

        creer_mon_compte = (Button) findViewById(R.id.button4);

    }

    public void creerMonCompte(View v) {
        String Sid = id.getText().toString();
        String Spassword = password.getText().toString();
        String Spassword_r = password_r.getText().toString();
        String Sprenom = prenom.getText().toString();
        String Snom = nom.getText().toString();
        String Stell = tell.getText().toString();
        String Scode_postal = code_postal.getText().toString();
        String Scin = cin.getText().toString();
        String Sadr = adr.getText().toString();
        String Smail = mail.getText().toString();

        if (Sid == null || Sid == "" ) {
            id.setError("Identifiant est obligatoire");

            Toast.makeText(this, "Identifiant est obligatoire", Toast.LENGTH_SHORT).show();
        } else if (Spassword == null || Spassword == "") {
            password.setError("Mot de passe est obligatoire");

            Toast.makeText(this, "Mot de passe est obligatoire", Toast.LENGTH_SHORT).show()
            ;
        } else if (Spassword_r == null || Spassword_r == "" || Spassword_r != Spassword) {
            password_r.setError("Répéter mot passe est obligatoire");

            Toast.makeText(this, "Répéter mot passe est obligatoire", Toast.LENGTH_SHORT).show()
            ;
        } else if (Sprenom == null || Sprenom == "" ) {
            prenom.setError("Prénom est obligatoire");

            Toast.makeText(this, "Prénom est obligatoire", Toast.LENGTH_SHORT).show()
            ;
        } else if (Snom == null || Snom == "" ) {
            nom.setError("Nom est obligatoire");

            Toast.makeText(this, "Nom est obligatoire", Toast.LENGTH_SHORT).show()
            ;
        } else if (Stell == null || Stell == "" ) {
            tell.setError("Téléphone est obligatoire");

            Toast.makeText(this, "Téléphone est obligatoire", Toast.LENGTH_SHORT).show()
            ;
        } else if (Scode_postal == null || Scode_postal == "") {
            code_postal.setError("Code postal est obligatoire");

            Toast.makeText(this, "Code postal est obligatoire", Toast.LENGTH_SHORT).show()
            ;
        } else if (Scin == null || Scin == "" ) {
            cin.setError("CIN est obligatoire");

            Toast.makeText(this, "CIN est obligatoire", Toast.LENGTH_SHORT).show();
        } else if (Sadr == null || Sadr == "" ) {
            adr.setError("Adress est obligatoire");

            Toast.makeText(this, "Adress est obligatoire", Toast.LENGTH_SHORT).show()
            ;
        } else if (Smail == null || Smail == "" ) {
            mail.setError("e-mail est obligatoire");

            Toast.makeText(this, "e-mail est obligatoire", Toast.LENGTH_SHORT).show()
            ;
        } else {

            //   InputStream is = null;


            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://mohamednouira.esy.es/setClient.php");
            ArrayList<NameValuePair> client = new ArrayList<NameValuePair>();


            client.add(new BasicNameValuePair("nom", nom.getText().toString()));
            client.add(new BasicNameValuePair("prenom", prenom.getText().toString()));
            client.add(new BasicNameValuePair("login", id.getText().toString()));
            client.add(new BasicNameValuePair("password", password.getText().toString()));
            client.add(new BasicNameValuePair("cin", cin.getText().toString()));
            client.add(new BasicNameValuePair("adr", adr.getText().toString()));
            client.add(new BasicNameValuePair("tell", tell.getText().toString()));
            client.add(new BasicNameValuePair("mail", mail.getText().toString()));
            client.add(new BasicNameValuePair("code_postal", code_postal.getText().toString()));

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


