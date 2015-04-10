package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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

        if (v.getId() == facvc.getId()) {
            Intent i = new Intent(getActivity(), Facvc.class);
           // startActivity(i);
            getActivity().startActivityForResult(i,1);
        }
        if (v.getId() == facve.getId()) {
            Intent i = new Intent(getActivity(), Facve.class);
            // startActivity(i);
            getActivity().startActivityForResult(i,2);
        }

        if (v.getId() == valider.getId()) {
            String Snom_carte = nom_carte.getText().toString();
            String Snom_enseigne = nom_enseigne.getText().toString();
            String Scode_barre = code_barre.getText().toString();

            if (Snom_carte == "" || Snom_enseigne == "" || Scode_barre == "" ) {
                nom_carte.setError("nom de carte est obligatoire");
                nom_enseigne.setError("nom de enseigne est obligatoire");
                code_barre.setError("code barre de carte est obligatoire");


            } else {

                //   InputStream is = null;

                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost("http://mohamednouira.esy.es/setClient.php");
                ArrayList<NameValuePair> client = new ArrayList<NameValuePair>();


                client.add(new BasicNameValuePair("nom", nom.getText().toString()));
                client.add(new BasicNameValuePair("prenom", prenom.getText().toString()));
                client.add(new BasicNameValuePair("login", id.getText().toString()));
                client.add(new BasicNameValuePair("password", password.getText().toString()));
                client.add(new BasicNameValuePair("cin", cin.getText().toString()));
                client.add(new BasicNameValuePair("adr", adr.getText().toString()));
                client.add(new BasicNameValuePair("tell", tell.getText().toString()));
                client.add(new BasicNameValuePair("mail", mail.getText().toString()));
                client.add(new BasicNameValuePair("code_postal", code_postal.getText().toString()));

                try {
                    httpPost.setEntity(new UrlEncodedFormEntity(client));
                    HttpResponse httpRespose = httpClient.execute(httpPost);
                    Log.e("ss", "ee");
                    HttpEntity httpEntity = httpRespose.getEntity();
                    InputStream in = httpEntity.getContent();
                    BufferedReader read = new BufferedReader(new InputStreamReader(in));

                    String isi = "";
                    String baris = "";

                    while ((baris = read.readLine()) != null) {
                        isi += baris;
                    }

                    //Jika isi tidak sama dengan "null " maka akan tampil Toast "Berhasil" sebaliknya akan tampil "Gagal"
                    if (!isi.equals("null")) {
                        Toast.makeText(this, "Berhasil", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(this, "Gagal", Toast.LENGTH_LONG).show();
                    }

                    Toast.makeText(this, "les donnees sont enregistrées", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(this, Login.class);
                    startActivity(i);


                } catch (Exception e) {
                    Log.e("log_tag", "Error in http connection :" + e.toString());
                }


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




    }

public void onActivityResult(int request,int result, Intent data){
    if (request == 1) {
        if(result == Activity.RESULT_OK){
            String type_carte=data.getStringExtra("type_carte");
            String description=data.getStringExtra("description");
            ImageView showImg = (ImageView) data.getParcelableExtra("showImg");
        }
        if (result == Activity.RESULT_CANCELED) {
            //Write your code if there's no result
        }
    }
    if (request == 2) {
        if(result == Activity.RESULT_OK){
            String adresse=data.getStringExtra("adresse");
            String vile=data.getStringExtra("vile");
            String code_postal=data.getStringExtra("code_postal");
            String tell=data.getStringExtra("tell");
            String mail=data.getStringExtra("mail");


        }
        if (result == Activity.RESULT_CANCELED) {
            //Write your code if there's no result
        }
    }

}
}
