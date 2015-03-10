package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.widget.ProgressBar;
import android.support.v7.app.ActionBar;
import android.view.Window;
import activity.carte_fidelite.medbac.com.cartefidelite.R;


public class MainActivity extends Activity {

    boolean active = true;
    int splashTime = 4000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        Thread splashThread=new Thread()
        {
            public void run()
            {
                try
                {
                    int waited=0;

                    while(active && (waited<splashTime))
                    {
                        sleep(100);
                        if(active)
                        {
                            waited +=100;
                        }
                    }
                }
                catch(Exception e)
                {
                    e.toString();
                }


                finally
                {

                    Intent int1=new Intent(getApplicationContext(),Login.class);
                    startActivity(int1);
                    finish();


                }
            }
        };

        splashThread.start();



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
