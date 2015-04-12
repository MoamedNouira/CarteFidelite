package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.medbac.carte_fidelite.Downloader.GetClient;

import java.io.IOException;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 12/04/2015.
 */
public class MotPasse extends Activity {

    EditText mail;
    Button bt_motpasse;
    String smail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mot_passe);
        mail = (EditText) findViewById(R.id.email);
        bt_motpasse = (Button) findViewById(R.id.bt_mot_passe);

    }


    public void onClick(View v) {


        if (v.getId() == bt_motpasse.getId()) {
            smail = mail.getText().toString();
            if (smail == null || smail == "" || smail.length() < 1 ) {
                mail.setError("mail est obligatoire");
            } else
            {   new LoadImagesFromSDCard().execute();}


        }
        }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public class LoadImagesFromSDCard  extends AsyncTask<String, Void, Void> {

        private ProgressDialog Dialog = new ProgressDialog(MotPasse.this);


        protected void onPreExecute() {

            Dialog.setMessage("attendre...");
            Dialog.show();
        }

        protected Void doInBackground(String... urls) {


            try {

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ "support@mohamednouira.esy.es"});
                email.putExtra(Intent.EXTRA_SUBJECT, "Récupérer mot de passe");
                email.putExtra(Intent.EXTRA_TEXT, "Récupérer mot de passe de : "+smail);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,mail.getText().toString()));


            } catch (Exception  e) {
                cancel(true);
            }

            return null;
        }

        protected void onPostExecute(Void unused) {


            Dialog.dismiss();
            Intent i = new Intent(MotPasse.this, Login.class);
            startActivity(i);


        }

    }









}