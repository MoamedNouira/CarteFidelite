package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.medbac.carte_fidelite.Models.*;
import activity.carte_fidelite.medbac.com.cartefidelite.R;


/**
 * Created by Mohamed Nouira on 24/04/2015.
 */
public class InfoEnseigne  extends Activity{

    TextView enseigne_text_nom;
    TextView enseigne_text_vile;
    TextView enseigne_text_adresse;
    TextView enseigne_text_code;
    TextView enseigne_text_tell;
    TextView enseigne_text_mail;
    int id_enseigne;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_enseigne);

        enseigne_text_nom = (TextView) findViewById(R.id.enseigne_text_nom);
        enseigne_text_vile = (TextView) findViewById(R.id.enseigne_text_vile);
        enseigne_text_adresse = (TextView) findViewById(R.id.enseigne_text_adresse);
        enseigne_text_code = (TextView) findViewById(R.id.enseigne_text_code);
        enseigne_text_tell = (TextView) findViewById(R.id.enseigne_text_tell);
        enseigne_text_mail = (TextView) findViewById(R.id.enseigne_text_mail);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            id_enseigne= extras.getInt("id_enseigne");
            Log.e("HHHHHHHHHHHHHHHHHHHH", ""+extras.getString("nom_commercial"));

           enseigne_text_nom.setText(extras.getString("nom_commercial"));
            enseigne_text_vile.setText(extras.getString("vile"));
            enseigne_text_adresse.setText(extras.getString("adresse"));
            enseigne_text_code.setText(Integer.toString(extras.getInt("code_postal")));
            enseigne_text_tell.setText(Integer.toString(extras.getInt("tell")));
            enseigne_text_mail.setText(extras.getString("mail"));

        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}