package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.Toast;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 05/04/2015.
 */
public class LiteAjouteCarte  extends Activity implements TabHost.OnTabChangeListener {

    TabHost view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_ajoute_carte);
        view = (TabHost)findViewById(R.id.tabhost_ajoute_carte);
        view.setOnTabChangedListener(this);
        view.setup();
        addTab("Categorie","Categorie",R.drawable.user34,R.id.tab1_ajoute_categorie);
        addTab("Nom","Nom",R.drawable.home82,R.id.tab2_ajoute_nom);
        addTab("Vierge","vierge",R.drawable.home82,R.id.tab1_ajoute_vierge);


    }

    private void addTab(String tag, String title, int icon, int content){
        TabHost.TabSpec spec = view.newTabSpec(tag);
        spec.setIndicator(title, getResources().getDrawable(icon));
        spec.setContent(content);
        view.addTab(spec);
    }

    @Override
    public void onTabChanged(String tabId) {
        Toast.makeText(this, tabId, Toast.LENGTH_SHORT).show();
    }


}
