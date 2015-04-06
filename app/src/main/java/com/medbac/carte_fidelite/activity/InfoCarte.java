package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 05/04/2015.
 */
public class InfoCarte extends Activity implements OnTabChangeListener {

    TabHost view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_carte);
        view = (TabHost)findViewById(R.id.tabhost);
        view.setOnTabChangedListener(this);
        view.setup();
        addTab("Carte","Carte",android.R.drawable.ic_menu_preferences,R.id.tab1);
        addTab("Localiser","Localiser",android.R.drawable.ic_menu_call,R.id.tab2);
    }

    private void addTab(String tag, String title, int icon, int content){
        TabSpec spec = view.newTabSpec(tag);
        spec.setIndicator(title, getResources().getDrawable(icon));
        spec.setContent(content);
        view.addTab(spec);
    }

    @Override
    public void onTabChanged(String tabId) {
        Toast.makeText(this, tabId, Toast.LENGTH_SHORT).show();
    }

}