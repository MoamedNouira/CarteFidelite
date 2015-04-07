package com.medbac.carte_fidelite.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.medbac.carte_fidelite.Models.Catégories;

import java.util.ArrayList;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 07/04/2015.
 */
public class AdapterListAjouteCarteCat extends BaseAdapter {

    private ArrayList<Catégories> list_cat;
    Context c;
    Catégories cat;

    public AdapterListAjouteCarteCat(Context c, ArrayList<Catégories> list_cat){
        this.c = c;
        this.list_cat = list_cat;
    }

    @Override
    public int getCount() {
        return list_cat.size();
    }

    @Override
    public Object getItem(int position) {
        return list_cat.get(position);
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

        list_cat = new ArrayList<Catégories>();
        for(int i=0;i< list_cat.size();i++)
        {

            //compte =  list_compte.get(i);
            //carte=compte.getCarte();
            //Carte carten = new Carte();

            //   carten.setNom(carte.getNom());
//            Log.e("valide", ""+(list_compte.get(i)).getCarte().getNom());
        //    list_carte.add(carten);
        }

        txt_title.setText(Integer.toString(list_cat.get(position).getId_catégories()));
        //  txt_artist.setText(getCompte.ListCompteCarte.get(position).getNom());


        return v;
    }
}
