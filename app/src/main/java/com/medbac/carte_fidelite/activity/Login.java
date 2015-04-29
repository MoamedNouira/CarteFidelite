package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.medbac.carte_fidelite.Downloader.GetAllCarte;
import com.medbac.carte_fidelite.Models.Client;


import com.medbac.carte_fidelite.Downloader.GetClient;
import com.medbac.carte_fidelite.Downloader.getAllPromotion;
import com.medbac.carte_fidelite.Downloader.getAllCategorie;
import com.medbac.carte_fidelite.Downloader.getAllCoordonnee;




import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 06/03/2015.
 */
public class Login  extends Activity {

    Button creer_compte;
    Button connexion;
    EditText id, password;
    TextView motpasse;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        creer_compte = (Button) findViewById(R.id.bt_compte);
        connexion = (Button) findViewById(R.id.bt_connexion);

        id = (EditText) findViewById(R.id.editText13);
        id.setText("n");
        password = (EditText) findViewById(R.id.editText16);
        password.setText("n");

        motpasse = (TextView) findViewById(R.id.textView2);

    }

    public void onClick(View v) {

        if (v.getId() == creer_compte.getId()) {
            Intent i = new Intent(this, CreerCompte.class);
            startActivity(i);
        }

        if (v.getId() == motpasse.getId()) {
            Intent i = new Intent(this, MotPasse.class);
            startActivity(i);
        }


        if (v.getId() == connexion.getId()) {


            String Sid = id.getText().toString();
            String Spassword = password.getText().toString();


            if (Sid == null || Sid == "" || Sid.length() < 1) {
                id.setError("Identifiant est obligatoire");
            } else if (Spassword == null || Spassword == "" || Spassword.length() < 1) {
                password.setError("Mot de passe est obligatoire");

            } else {


                GetClient gc = new GetClient("http://mohamednouira.esy.es/getLogin.php",Sid,Spassword,this);
                getAllPromotion p = new getAllPromotion("http://mohamednouira.esy.es/getAllPromotion.php",this);
                getAllCategorie gcat = new getAllCategorie("http://mohamednouira.esy.es/getAllCategorie.php",this);
                GetAllCarte gcarte=new GetAllCarte("http://mohamednouira.esy.es/getAllCarte.php",this);
                getAllCoordonnee gcor=new getAllCoordonnee("http://mohamednouira.esy.es/getAllCoordonnee.php",this);


            }


        }
    }
}
