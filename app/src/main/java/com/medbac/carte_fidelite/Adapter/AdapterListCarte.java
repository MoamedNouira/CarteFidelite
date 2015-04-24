package com.medbac.carte_fidelite.Adapter;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.ImageView;

import activity.carte_fidelite.medbac.com.cartefidelite.R;
import com.medbac.carte_fidelite.Downloader.GetCarte;
import com.medbac.carte_fidelite.Downloader.GetClient;
import com.medbac.carte_fidelite.Downloader.getCompte;

import com.medbac.carte_fidelite.Models.Compte;
import com.medbac.carte_fidelite.Models.Carte;
import com.medbac.carte_fidelite.Models.Client;


import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by ideapad on 03/04/2015.
 */

public class AdapterListCarte extends BaseAdapter {

   private ArrayList<Compte> list_compte;
    Context c;
    private ArrayList<Carte> list_carte;
    Compte compte;
    Carte carte;

   public AdapterListCarte(Context c, ArrayList<Compte> list_compte){
        this.c = c;
        this.list_compte = list_compte;
    }

    @Override
    public int getCount() {
        return list_compte.size();
    }

    @Override
    public Object getItem(int position) {
        return list_compte.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if(v == null){
            LayoutInflater inflater =(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inflater.inflate(R.layout.item_list_carte,null);
        }
        ImageView image_item_list=(ImageView)v.findViewById(R.id.image_item_list);
        TextView txt_title=(TextView)v.findViewById(R.id.title);
        TextView txt_artist=(TextView)v.findViewById(R.id.artist);
        TextView txt_duration=(TextView)v.findViewById(R.id.duration);
        ImageView image_list_image=(ImageView)v.findViewById(R.id.list_image);

        list_carte = new ArrayList<Carte>();
        for(int i=0;i< list_compte.size();i++)
        {

            compte =  list_compte.get(i);
            carte=compte.getCarte();
            Carte carten = new Carte();

         //   carten.setNom(carte.getNom());
//            Log.e("valide", ""+(list_compte.get(i)).getCarte().getNom());
            list_carte.add(carten);
          }

        txt_title.setText(getCompte.ListCompte.get(position).getCarte().getNom());
        txt_artist.setText(GetClient.client1.getNom()+" "+GetClient.client1.getPrenom());
        String strLong = Long.toString(getCompte.ListCompte.get(position).getCode_barre());
        txt_duration.setText(strLong);



        return v;
    }
}
