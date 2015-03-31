package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import com.medbac.carte_fidelite.Downloader.GetClient;
import com.medbac.carte_fidelite.Downloader.ServiceHandler;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 06/03/2015.
 */
public class MenuCarte extends Activity {

    Button ButtonMenuCarte;
    Button ButtonMenuEnseigne;
    Button ButtonMenuPromotion;
    Button ButtonMenuCompte;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_carte);

        ButtonMenuCarte = (Button) findViewById(R.id.button_menu_carte);
        ButtonMenuEnseigne = (Button) findViewById(R.id.button_menu_enseigne);
        ButtonMenuPromotion = (Button) findViewById(R.id.button_menu_promotion);
        ButtonMenuCompte = (Button) findViewById(R.id.button_menu_compte);

        ButtonMenuCarte.setFocusableInTouchMode(true);
        ButtonMenuEnseigne.setFocusableInTouchMode(true);
        ButtonMenuPromotion.setFocusableInTouchMode(true);
        ButtonMenuCompte.setFocusableInTouchMode(true);

        addListenerOnButton();

    }


    public void addListenerOnButton() {

        ButtonMenuCarte.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(MenuCarte.this, "Carte  clicked!",
                        Toast.LENGTH_SHORT).show();
                ButtonMenuCarte.setFocusableInTouchMode(false);
                ButtonMenuCarte.setFocusable(false);
            }
        });

        ButtonMenuEnseigne.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(MenuCarte.this, "enseigne  clicked!",
                        Toast.LENGTH_SHORT).show();
                ButtonMenuEnseigne.setFocusableInTouchMode(false);
                ButtonMenuEnseigne.setFocusable(false);
            }
        });

        ButtonMenuPromotion.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(MenuCarte.this, "Promotion  clicked!",
                        Toast.LENGTH_SHORT).show();
                ButtonMenuPromotion.setFocusableInTouchMode(false);
                ButtonMenuPromotion.setFocusable(false);
            }
        });

        ButtonMenuCompte.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(MenuCarte.this, "Compte  clicked!",
                        Toast.LENGTH_SHORT).show();
                ButtonMenuCompte.setFocusableInTouchMode(false);
                ButtonMenuCompte.setFocusable(false);
            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        GetClient.client1 = null;
    }
}