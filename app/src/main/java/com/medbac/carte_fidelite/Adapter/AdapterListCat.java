package com.medbac.carte_fidelite.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.medbac.carte_fidelite.Models.Catégories;
import com.medbac.carte_fidelite.Models.Promotion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 22/04/2015.
 */
public class AdapterListCat  extends BaseAdapter {

    private ArrayList<Catégories> list_cat;
    Context c;

    public AdapterListCat(Context c, ArrayList<Catégories> list_cat){
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
            v=inflater.inflate(R.layout.item_list_cat,null);
        }
        TextView title_nom_cat=(TextView)v.findViewById(R.id.title_nom_cat);




        title_nom_cat.setText(list_cat.get(position).getNom_cat());




        return v;
    }
}
