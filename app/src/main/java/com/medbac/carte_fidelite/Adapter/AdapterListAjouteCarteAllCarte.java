package com.medbac.carte_fidelite.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.medbac.carte_fidelite.Downloader.ImageLoader;
import com.medbac.carte_fidelite.Models.Carte;
import com.medbac.carte_fidelite.Downloader.getAllEnseigne;

import java.util.ArrayList;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 28/04/2015.
 */
public class AdapterListAjouteCarteAllCarte extends BaseAdapter {

     ArrayList<Carte> list_allcarte;
    Context c;
    Carte carte;
    public ImageLoader imageLoader;

    public AdapterListAjouteCarteAllCarte(Context c, ArrayList<Carte> list_allcarte){
        this.c = c;
        this.list_allcarte = list_allcarte;
        imageLoader = new ImageLoader(c);

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
        TextView title_enseigne=(TextView)v.findViewById(R.id.title_enseigne);
        TextView title_allcarte=(TextView)v.findViewById(R.id.title_allcarte);
        ImageView image_list_image=(ImageView)v.findViewById(R.id.list_image_allcarte);


//        txt_title.setText(list_allcarte.get(position).getNom());
        title_allcarte.setText(list_allcarte.get(position).getNom());
        imageLoader.DisplayImage("http://mohamednouira.esy.es/images/"+list_allcarte.get(position).getImage(), image_item_list);

        for(int i=0;i<getAllEnseigne.ListEnseignes.size();i++){
            if(list_allcarte.get(position).getId_enseigne() == getAllEnseigne.ListEnseignes.get(i).getId_enseigne())
            {
                title_enseigne.setText(getAllEnseigne.ListEnseignes.get(i).getNom_commercial());
            }

        }

        //  txt_duration.setText(list_allcarte.get(position).getNom());

        //  txt_artist.setText(getCompte.ListCompteCarte.get(position).getNom());


        return v;
    }
}
