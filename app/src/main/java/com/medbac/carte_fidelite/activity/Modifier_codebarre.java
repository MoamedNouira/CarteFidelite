package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
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
 * Created by Mohamed Nouira on 11/05/2015.
 */
public class Modifier_codebarre extends Activity  implements View.OnClickListener{

    EditText mod_codebarre;
    Button bt_scannebarre,modifier_ok;
    TextView text_nomcarte;
    String scode;
    String nom_carte;
    int id_compte;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.modifier_codebarre);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        text_nomcarte = (TextView) findViewById(R.id.text_nomcarte);
        mod_codebarre =(EditText) findViewById(R.id.mod_codebarre);
        bt_scannebarre = (Button) findViewById(R.id.bt_scannebarre);
        modifier_ok = (Button) findViewById(R.id.modifier_ok);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            scode = extras.getString("scode");
            nom_carte=extras.getString("nom_carte");
            id_compte=extras.getInt("id_compte");
        }
        mod_codebarre.setText(scode);
        text_nomcarte.setText(nom_carte);


        bt_scannebarre.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Modifier_codebarre.this, Barrecode.class);
                startActivityForResult(i, 3);
            }
        });


        modifier_ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(v.getId()==R.id.modifier_ok){



                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost("http://mohamednouira.esy.es/updateCodeBarre.php");
                    ArrayList<NameValuePair> client = new ArrayList<NameValuePair>();

                    client.add(new BasicNameValuePair("id_compte",Integer.toString(id_compte)));
                    client.add(new BasicNameValuePair("code_barre",scode));


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

        });

    public void onActivityResult(int request,int result, Intent data){
        super.onActivityResult(request, result, data);

        if (request == 3) {
            if(result == Activity.RESULT_OK){
                String code=data.getStringExtra("code");
                mod_codebarre.setText(code);
            }
            if (result == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }



    }






}
