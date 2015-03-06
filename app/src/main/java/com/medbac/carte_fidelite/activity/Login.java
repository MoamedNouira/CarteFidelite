package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 06/03/2015.
 */
public class Login  extends Activity {

    Button creer_compte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        creer_compte = (Button) findViewById(R.id.button3);
    }

    public void onClick(View v) {
        if (v.getId() == creer_compte.getId()) {
            Intent i = new Intent(this, Creer_compte.class);
            startActivity(i);


        }

    }
}
