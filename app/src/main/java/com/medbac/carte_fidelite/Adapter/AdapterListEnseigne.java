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
import com.medbac.carte_fidelite.Models.Enseigne;


import java.util.ArrayList;

/**
 * Created by ideapad on 03/04/2015.
 */

public class AdapterListEnseigne extends BaseAdapter {

   private ArrayList<Enseigne> list_enseigne;
    Context c;

   public AdapterListEnseigne(Context c, ArrayList<Enseigne> list_enseigne){
        this.c = c;
        this.list_enseigne = list_enseigne;
    }

    @Override
    public int getCount() {
        return list_enseigne.size();
    }

    @Override
    public Object getItem(int position) {
        return list_enseigne.get(position);
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
            v=inflater.inflate(R.layout.item_list_enseigne,null);
        }
        ImageView image_item_list_enseigne=(ImageView)v.findViewById(R.id.image_item_list_enseigne);
        TextView title_enseigne_nom_commercial=(TextView)v.findViewById(R.id.title_enseigne_nom_commercial);
        ImageView list_image_enseugne=(ImageView)v.findViewById(R.id.list_image_enseugne);


        title_enseigne_nom_commercial.setText(list_enseigne.get(position).getNom_commercial());


        return v;
    }
}
