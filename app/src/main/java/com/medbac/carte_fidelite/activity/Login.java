package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 06/03/2015.
 */
public class Login  extends Activity {

    Button creer_compte;
    Button connexion;
    EditText id, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        creer_compte = (Button) findViewById(R.id.button3);
        connexion = (Button) findViewById(R.id.button);

        id = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);


    }

    public void onClick(View v) {
        if (v.getId() == creer_compte.getId()) {
            Intent i = new Intent(this, CreerCompte.class);
            startActivity(i);
        }
        if (v.getId() == connexion.getId()) {


            String Sid = id.getText().toString();
            String Spassword = password.getText().toString();


            if (Sid == null || Sid == "" || Sid.length() < 3) {
                Toast.makeText(this, "Identifiant est obligatoire", Toast.LENGTH_SHORT).show();
            } else if (Spassword == null || Spassword == "" || Spassword.length() < 3) {
                Toast.makeText(this, "Mot de passe est obligatoire", Toast.LENGTH_SHORT).show();
            } else {


                Toast.makeText(this, "OUI", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, MenuCarte.class);
                startActivity(i);

            }


        }
    }
}
