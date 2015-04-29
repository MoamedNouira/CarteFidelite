package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//import com.google.zxing.integration.android.IntentIntegrator;
//import com.google.zxing.integration.android.IntentResult;
import com.medbac.carte_fidelite.Downloader.GetClient;

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
 * Created by Mohamed Nouira on 07/04/2015.
 */
public class FragmentAjouteCarteViege   extends Fragment {
    Button scanner;
    Button valider;
    ImageView facvc,facve;
    EditText nom_carte,nom_enseigne,code_barre;
    Context c;
    Compte compte;
    Carte carte;
    Enseigne enseigne;
    TextView code;


   String  adress;
    String vile;
    String  code_postal;
    String tell;
    String mail;

    String description;
    String type_carte;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        View rootView = inflater.inflate(R.layout.fragment_ajoute_carte_viege, container, false);

        scanner = (Button)  rootView.findViewById(R.id.button7);
        valider = (Button)  rootView.findViewById(R.id.button8);
        nom_carte = (EditText)  rootView.findViewById(R.id.nom_carte);
        nom_enseigne = (EditText)  rootView.findViewById(R.id.nom_enseigne);
        code_barre = (EditText)  rootView.findViewById(R.id.editText15);
        facvc = (ImageView)  rootView.findViewById(R.id.facv_cplus);
        facve = (ImageView)  rootView.findViewById(R.id.facv_eplus);

        Carte carte= new Carte();
        Compte compte=new Compte();
        Enseigne enseigne = new Enseigne();



        addListenerOnButton();





        return rootView;
    }
    public void onClick2(View v) {

        if (v.getId() == scanner.getId()) {


            Intent i = new Intent(getActivity(), Barrecode.class);
            startActivityForResult(i, 3);


         // IntentIntegrator intentIntegrator = new IntentIntegrator(getActivity());
          //  intentIntegrator.initiateScan();

        }



        if (v.getId() == facvc.getId()) {

            Intent i = new Intent(getActivity(), Facvc.class);
           // startActivity(i);
            startActivityForResult(i, 1);

        }
        if (v.getId() == facve.getId()) {
            Intent i = new Intent(getActivity(), Facve.class);
            // startActivity(i);
            startActivityForResult(i, 2);
        }

        if (v.getId() == valider.getId()) {
            String Snom_carte = nom_carte.getText().toString();
            String Snom_enseigne = nom_enseigne.getText().toString();
            String Scode_barre = code_barre.getText().toString();
            Log.e("click" ,"clich inserttttttttt");
            if (Snom_carte == "" || Snom_enseigne == "" || Scode_barre == "" ) {
                nom_carte.setError("nom de carte est obligatoire");
                nom_enseigne.setError("nom de enseigne est obligatoire");
                code_barre.setError("code barre de carte est obligatoire");


            } else {





            }

           }




        }



    public void addListenerOnButton() {
        facvc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                facvc.setFocusableInTouchMode(false);
                facvc.setFocusable(false);
                onClick2(arg0);

            }
        });

        facve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                facve.setFocusableInTouchMode(false);
                facve.setFocusable(false);
                onClick2(arg0);

            }
        });

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                valider.setFocusableInTouchMode(false);
                valider.setFocusable(false);
                onClick2(arg0);

            }
        });

            scanner.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    scanner.setFocusableInTouchMode(false);
                    scanner.setFocusable(false);
                    onClick2(arg0);

                }
            });

    }




public void onActivityResult(int request,int result, Intent data){

    super.onActivityResult(request, result, data);




    if (request == 1) {

        if(result == Activity.RESULT_OK){
            nom_carte.setText("nom_carte");

            this.type_carte=data.getStringExtra("type_carte");
            this.description=data.getStringExtra("description");
            ImageView showImg = (ImageView) data.getParcelableExtra("showImg");
        }
        if (result == Activity.RESULT_CANCELED) {
            //Write your code if there's no result
        }
    }
    if (request == 2) {

        if(result == Activity.RESULT_OK){
            nom_enseigne.setText("nom_enseigne");

            this.adress=data.getStringExtra("adresse");
            this.vile=data.getStringExtra("vile");
            this.code_postal=data.getStringExtra("code_postal");
            this.tell=data.getStringExtra("tell");
            this.mail=data.getStringExtra("mail");



        }
        if (result == Activity.RESULT_CANCELED) {
        }
    }

    if (request == 3) {

        if(result == Activity.RESULT_OK){
            String code=data.getStringExtra("code");
            code_barre.setText(code);
        }
        if (result == Activity.RESULT_CANCELED) {
            //Write your code if there's no result
        }
    }

}
}
