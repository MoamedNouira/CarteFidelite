package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import com.medbac.carte_fidelite.Models.*;
import com.medbac.carte_fidelite.Downloader.getAllCoordonnee;

import java.util.ArrayList;

import activity.carte_fidelite.medbac.com.cartefidelite.R;


/**
 * Created by Mohamed Nouira on 24/04/2015.
 */
public class InfoEnseigne  extends Activity {
    AlertDialog.Builder alertDialogBuilder;

    TextView enseigne_text_nom;
    TextView enseigne_text_vile;
    TextView enseigne_text_adresse;
    TextView enseigne_text_code;
    TextView enseigne_text_tell;
    TextView enseigne_text_mail;
    Button local;
    public static ArrayList<Coordonnee>list_coor;
    int id_enseigne;
    Button call;
    final CharSequence[] items = {"tell", "sms", "mail"};
    String number;


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
        local = (Button) findViewById(R.id.enseigne_local);
        call = (Button) findViewById(R.id.call);









        call.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialogBuilder = new AlertDialog.Builder(InfoEnseigne.this);
                alertDialogBuilder.setTitle("What is your favourite animal?");
                alertDialogBuilder.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
                    Bundle extras = getIntent().getExtras();
                    public void onClick(DialogInterface dialog, int item) {

                        if (items[item].equals("tell")) {
                            Bundle extras = getIntent().getExtras();
                            if (extras != null) {

                                Intent callIntent = new Intent(Intent.ACTION_CALL);
                                // callIntent.setData(Uri.parse("tel:"+Integer.toString(extras.getInt("tell"))));
                                 number = Integer.toString(extras.getInt("tell"));

                                callIntent.setData(Uri.parse("tel:" + number));
                                startActivity(callIntent);
                            }
                        } else if (items[item].equals("sms")) {
                            if (extras != null) {
                                String number = Integer.toString(extras.getInt("tell"));

                                 number = "12346556";  // The number on which you want to send SMS
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null)));
                            }

                        } else if (items[item].equals("mail")) {



                        }

                        dialog.dismiss();
                    }
                });
                alertDialogBuilder.show();


                    }
                });








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
        list_coor=new ArrayList<Coordonnee>();

        for(int x = 0;x < getAllCoordonnee.ListAllCoordonnee.size();x++){
                if(getAllCoordonnee.ListAllCoordonnee.get(x).getId_enseigne()==id_enseigne){
                    list_coor.add(getAllCoordonnee.ListAllCoordonnee.get(x));
                    Log.e("llllllllllllllllllll", ""+list_coor.get(x).getLatitude());
                    Log.e("llllllllllllllllllll", ""+list_coor.get(x).getLongitude());


                }

            }


    }


    public void onClick(View view) {
        Intent i = new Intent(InfoEnseigne.this,Localisation.class);
        startActivity(i);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}