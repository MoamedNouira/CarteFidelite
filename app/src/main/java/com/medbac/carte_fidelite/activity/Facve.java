package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 09/04/2015.
 */
public class Facve extends Activity {

    EditText adresse,vile,code_postal,tell,mail;
    Button oke;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.facve);
        adresse = (EditText) findViewById(R.id.adresse);
        vile = (EditText) findViewById(R.id.vile);
        code_postal = (EditText) findViewById(R.id.code_postal);
        tell = (EditText) findViewById(R.id.tell);
        mail = (EditText) findViewById(R.id.mail);
        oke = (Button) findViewById(R.id.oke);


        oke.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent data = new Intent();
                String sadresse = adresse.getText().toString();
                String svile = vile.getText().toString();
                String scode_postal = code_postal.getText().toString();
                String stell = tell.getText().toString();
                String smail = mail.getText().toString();

                data.putExtra("adresse",sadresse);
                data.putExtra("vile",svile);
                data.putExtra("code_postal",scode_postal);
                data.putExtra("tell",stell);
                data.putExtra("mail",smail);

                setResult(Facvc.RESULT_OK);
                finish();

            }

        });




    }






    }
