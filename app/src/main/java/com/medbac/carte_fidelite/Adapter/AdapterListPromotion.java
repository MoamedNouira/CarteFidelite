package com.medbac.carte_fidelite.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
public class AdapterListPromotion  extends BaseAdapter {

    private ArrayList<Promotion> list_promotion;
    Context c;

    public AdapterListPromotion(Context c, ArrayList<Promotion> list_promotion){
        this.c = c;
        this.list_promotion = list_promotion;
    }

    @Override
    public int getCount() {
        return list_promotion.size();
    }

    @Override
    public Object getItem(int position) {
        return list_promotion.get(position);
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
            v=inflater.inflate(R.layout.item_list_promotion,null);
        }
        TextView title_promotion_enseigne=(TextView)v.findViewById(R.id.title_promotion_enseigne);
        TextView title_descr_promo=(TextView)v.findViewById(R.id.title_descr_promo);
        TextView title_date_deb_promo=(TextView)v.findViewById(R.id.title_date_deb_promo);
        TextView title_date_fin_promo=(TextView)v.findViewById(R.id.title_date_fin_promo);
        ImageView info_offers=(ImageView)v.findViewById(R.id.info_offers);



        title_descr_promo.setText(list_promotion.get(position).getDescr_promo());


            DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
             Date today = list_promotion.get(position).getDate_deb_promo();
             Date today2 = list_promotion.get(position).getDate_fin_promo();

             String reportDate = df.format(today);
              String reportDate2 = df.format(today2);

        title_date_deb_promo.setText(reportDate);
        title_date_fin_promo.setText(reportDate2);

        title_promotion_enseigne.setText(list_promotion.get(position).getEnseigne().getNom_commercial());

        return v;
    }
}
