package com.medbac.carte_fidelite.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.medbac.carte_fidelite.Models.Carte;

import java.util.ArrayList;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 28/04/2015.
 */
public class AdapterListAjouteCarteAllCarte extends BaseAdapter {

     ArrayList<Carte> list_allcarte;
    Context c;
    Carte carte;

    public AdapterListAjouteCarteAllCarte(Context c, ArrayList<Carte> list_allcarte){
        this.c = c;
        this.list_allcarte = list_allcarte;
    }
    @Override
    public int getCount() {
        return list_allcarte.size();
    }

    @Override
    public Object getItem(int position) {
        return list_allcarte.get(position);
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
            v=inflater.inflate(R.layout.item_list_allcarte,null);
        }
        ImageView image_item_list=(ImageView)v.findViewById(R.id.image_item_listallcarte);
        TextView txt_title=(TextView)v.findViewById(R.id.title_enseigne);
        TextView txt_duration=(TextView)v.findViewById(R.id.duration);
        ImageView image_list_image=(ImageView)v.findViewById(R.id.list_image_allcarte);

        list_allcarte = new ArrayList<Carte>();
        for(int i=0;i< list_allcarte.size();i++)
        {

            //compte =  list_compte.get(i);
            //carte=compte.getCarte();
            //Carte carten = new Carte();

            //   carten.setNom(carte.getNom());
//            Log.e("valide", ""+(list_compte.get(i)).getCarte().getNom());
            //    list_carte.add(carten);
        }

//        txt_title.setText(list_allcarte.get(position).getNom());
        txt_title.setText("dddd");

        //  txt_artist.setText(getCompte.ListCompteCarte.get(position).getNom());


        return v;
    }
}
