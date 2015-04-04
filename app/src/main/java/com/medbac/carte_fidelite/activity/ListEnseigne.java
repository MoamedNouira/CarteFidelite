package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.medbac.carte_fidelite.Adapter.AdapterListEnseigne;
import com.medbac.carte_fidelite.Downloader.GetEnseigne;

import com.medbac.carte_fidelite.Models.Enseigne;




import java.util.ArrayList;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 03/04/2015.
 */
public class ListEnseigne extends Activity {

    ArrayList  ListEnseigne;
    AdapterListEnseigne adapter;
    ListView ListViewEnseigne;
    Context c ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_enseigne);

        ListViewEnseigne = (ListView)findViewById(R.id.listView_enseigne);

        ArrayList <Enseigne> ListEnseigne =new ArrayList<Enseigne>();


		///////////////////////////////////////////////////////////////////////


      //  ListEnseigne = GetEnseigne.client1.getCompte();

       // for(int i=0;i< ListCompte.size();i++)
      //  {
      //      compte =  ListCompte.get(i);
      //      carte = compte.getCarte();
      //      Log.e("samarche","fffffffffffffffff  "+compte.getId_carte());
     //   }
      //  adapter = new AdapterListCarte(this, ListCompte);
        // ListViewCarte.setAdapter(adapter);


    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}