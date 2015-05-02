package com.medbac.carte_fidelite.activity;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;

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

public class InfoCarteCarte extends Fragment implements View.OnClickListener {
    Button scanBtn,supp;



    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }



    }



	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_info_carte_carte, container, false);
        TextView nom_carte = (TextView)  rootView.findViewById(R.id.textView10);
        TextView  descr_carte = (TextView)  rootView.findViewById(R.id.textView11);
        TextView montant = (TextView)  rootView.findViewById(R.id.textView12);
        TextView nb_point = (TextView)  rootView.findViewById(R.id.textView13);
        scanBtn = (Button)  rootView.findViewById(R.id.ButtonButton);
        supp = (Button)  rootView.findViewById(R.id.button6);

        nom_carte.setText(FrInfoCarte.nom_carte+"");
        descr_carte.setText(FrInfoCarte.descr_carte+"");
        montant.setText(FrInfoCarte.montant+"");
        nb_point.setText(FrInfoCarte.nb_point+"");
        scanBtn.setOnClickListener(this);

        supp.setOnClickListener(this);





        //    if (getArguments() != null){

      //      Bundle data = getArguments();
      //      int strtext= data.getInt("id_compte");
      //      id_compte.setText(strtext);
    //    }else {
    //        id_compte.setText("null");
     //   }
    //    int strtext=getArguments().getInt("id_compte",0);
      //  id_compte.setText("");

        return rootView;
	}
    public void onClick(View v){

        if(v.getId()==R.id.ButtonButton){
            Intent i = new Intent(getActivity(), AffichageBarreCode.class);
            long scode = FrInfoCarte.code_barre;
            Log.e(" scodescodescodescodescode",""+scode);
            String strLong = Long.toString(scode);
            i.putExtra("scode",strLong);
            startActivity(i);

            // setResult(Facvc.RESULT_OK);



        }


        if(v.getId()==R.id.button6){

            AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());

            // Setting Dialog Title
            alertDialog.setTitle("Confirm Delete...");

            // Setting Dialog Message
            alertDialog.setMessage("Are you sure you want delete this?");

            // Setting Icon to Dialog
            alertDialog.setIcon(R.drawable.common_signin_btn_icon_dark);

            // Setting Positive "Yes" Button
            alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog,int which) {

                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost("http://mohamednouira.esy.es/deletCarte.php");
                    ArrayList<NameValuePair> client = new ArrayList<NameValuePair>();

                    client.add(new BasicNameValuePair("id_compte",Integer.toString(FrInfoCarte.id_compte)));


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
                            Toast.makeText(getActivity(), "Berhasil", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getActivity(), "Gagal", Toast.LENGTH_LONG).show();
                        }

                        Toast.makeText(getActivity(), "les donnees sont enregistrées", Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(getActivity(), Login.class);
                        startActivity(i);


                    } catch (Exception e) {
                        Log.e("log_tag", "Error in http connection :" + e.toString());
                    }



                    Toast.makeText(getActivity(), "You clicked on YES", Toast.LENGTH_SHORT).show();
                }
            });

            // Setting Negative "NO" Button
            alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // Write your code here to invoke NO event
                    Toast.makeText(getActivity(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                }
            });

            // Showing Alert Message
            alertDialog.show();




        }
    }

}
