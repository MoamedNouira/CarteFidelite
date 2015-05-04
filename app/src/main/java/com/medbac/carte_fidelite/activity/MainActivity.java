package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.widget.ProgressBar;
import android.support.v7.app.ActionBar;
import android.view.Window;
import android.widget.Toast;

import com.medbac.carte_fidelite.Downloader.GetAllCarte;
import com.medbac.carte_fidelite.Downloader.getAllCategorie;
import com.medbac.carte_fidelite.Downloader.getAllCoordonnee;
import com.medbac.carte_fidelite.Downloader.getAllEnseigne;
import com.medbac.carte_fidelite.Downloader.getAllPromotion;

import activity.carte_fidelite.medbac.com.cartefidelite.R;


public class MainActivity extends Activity {

    boolean active = true;
    int splashTime = 400;
    private ProgressDialog pDialog;
    ProgressBar pb;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb=(ProgressBar)findViewById(R.id.progressBar);

        new starte().execute();


    }

    private class starte extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pb.setVisibility(View.VISIBLE);


        }

        @Override
        protected Void doInBackground(Void... arg0) {

            getAllPromotion p = new getAllPromotion("http://mohamednouira.esy.es/getAllPromotion.php",MainActivity.this);
            getAllCategorie gcat = new getAllCategorie("http://mohamednouira.esy.es/getAllCategorie.php",MainActivity.this);
            GetAllCarte gcarte=new GetAllCarte("http://mohamednouira.esy.es/getAllCarte.php",MainActivity.this);
            getAllCoordonnee gcor=new getAllCoordonnee("http://mohamednouira.esy.es/getAllCoordonnee.php",MainActivity.this);
            getAllEnseigne galleng=new getAllEnseigne("http://mohamednouira.esy.es/getAllEnseigne.php",MainActivity.this);

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            pb.setVisibility(View.INVISIBLE);
            Intent int1=new Intent(getApplicationContext(),Login.class);
            startActivity(int1);

        }


    }


















    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
