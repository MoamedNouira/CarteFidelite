package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.medbac.carte_fidelite.Downloader.GetClient;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

public class Carte extends Activity {

   Button ButtonListCarte;
   Button ButtonLiteAjouteCarte;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carte);

        ButtonListCarte = (Button) findViewById(R.id.button_carte_listcarte);
        ButtonListCarte.setFocusableInTouchMode(true);
        ButtonLiteAjouteCarte = (Button) findViewById(R.id.button_carte_add);
        ButtonLiteAjouteCarte.setFocusableInTouchMode(true);

        addListenerOnButton();

    }

    public void onClick2(View v) {

        if (v.getId() == ButtonListCarte.getId()) {
            Intent i = new Intent(this, ListCarte.class);
            startActivity(i);
        }
        if (v.getId() == ButtonLiteAjouteCarte.getId()) {
            Intent i = new Intent(this, LiteAjouteCarte.class);
            startActivity(i);
        }

    }
    public void addListenerOnButton() {
        ButtonListCarte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(Carte.this, "List Carte",
                        Toast.LENGTH_SHORT).show();
                ButtonListCarte.setFocusableInTouchMode(false);
                ButtonListCarte.setFocusable(false);
                onClick2(arg0);

            }
        });
        ButtonLiteAjouteCarte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(MenuCarte.this, "Ajoute Carte",
                        Toast.LENGTH_SHORT).show();
                ButtonLiteAjouteCarte.setFocusableInTouchMode(false);
                ButtonLiteAjouteCarte.setFocusable(false);
                onClick2(arg0);


            }
        });


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}