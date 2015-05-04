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
import com.medbac.carte_fidelite.Models.Enseigne;
import com.medbac.carte_fidelite.Downloader.getAllEnseigne;

import java.util.Date;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 23/04/2015.
 */
public class InfoOffer extends Activity{

    TextView text_enseigne,date_d,date_fin,offer_desc;
    int id_enseigne;
    Button info;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_offer);

        text_enseigne = (TextView) findViewById(R.id.offer_text_enseigne);
        date_d = (TextView) findViewById(R.id.offer_dat_d);
        date_fin = (TextView) findViewById(R.id.offer_date_fin);
        offer_desc = (TextView) findViewById(R.id.offer_desc);
        info = (Button) findViewById(R.id.plus_info);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            id_enseigne= extras.getInt("id_enseigne");
            date_d.setText(extras.getString("date_deb_promo"));
            date_fin.setText(extras.getString("date_fin_promo"));
            offer_desc.setText(extras.getString("descr_promo"));
            text_enseigne.setText(extras.getString("nom_enseigne"));
        }



        info.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(InfoOffer.this, InfoEnseigne.class);
                for(int x=0;x<getAllEnseigne.ListEnseignes.size();x++){
                    if(getAllEnseigne.ListEnseignes.get(x).getId_enseigne()==id_enseigne){

                        i.putExtra("id_enseigne",id_enseigne);
                        i.putExtra("nom_commercial", getAllEnseigne.ListEnseignes.get(x).getNom_commercial());
                        i.putExtra("adresse", getAllEnseigne.ListEnseignes.get(x).getAdresse());
                        i.putExtra("vile",getAllEnseigne.ListEnseignes.get(x).getVile());
                        i.putExtra("code_postal",getAllEnseigne.ListEnseignes.get(x).getCode_postal());
                        i.putExtra("tell",getAllEnseigne.ListEnseignes.get(x).getTell());
                        i.putExtra("mail",getAllEnseigne.ListEnseignes.get(x).getMail());
                        startActivity(i);

                    }
                }




            }
        });



    }





    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}