package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.widget.ProgressBar;

import activity.carte_fidelite.medbac.com.cartefidelite.R;


public class MainActivity extends Activity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        boolean active = true;
        int time = 4000;
        Thread s = new Thread()

        {
            try {
                @Override
                public void run() {
                    int w = 0;
                    while (active && ( w < time ))
                    {
                        sleep(100);
                        if (active) {
                            w += 100;
                        }
                    }
                }
            }
            catch(Exception e) {
            }
            finally { }

 };



            Intent i = new Intent(getApplicationContext(), Login.class);
            startActivity(i);
            finish();
            s.State();





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
