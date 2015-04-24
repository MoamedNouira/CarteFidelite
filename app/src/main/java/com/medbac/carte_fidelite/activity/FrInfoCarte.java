package com.medbac.carte_fidelite.activity;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.TextView;
import android.app.FragmentManager;

import com.medbac.carte_fidelite.Adapter.TabsPagerAdapterInfoCarte;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

public class FrInfoCarte extends FragmentActivity implements
		ActionBar.TabListener {


	private ViewPager viewPager;
	private TabsPagerAdapterInfoCarte mAdapter;
	private ActionBar actionBar;
    InfoCarteCarte compte;

    public static    String nom_carte ;
    public static    long code_barre ;
    public static   int montant ;
    public static  int nb_point ;
    public static   String descr_carte;
    public static   String image;

	// Tab titles
	private String[] tabs = { "Carte", "Localiser" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_info_carte);
		// Initilization
		viewPager = (ViewPager) findViewById(R.id.pager);
		actionBar = getActionBar();
		mAdapter = new TabsPagerAdapterInfoCarte(getSupportFragmentManager());

		viewPager.setAdapter(mAdapter);
		actionBar.setHomeButtonEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

   //    Bundle extras = getIntent().getExtras();
     //   if (extras != null) {
      //     int scode = extras.getInt("id_compte");
    //        Log.e("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww", "" + scode);



     //   }



		// Adding Tabs
		for (String tab_name : tabs) {
			actionBar.addTab(actionBar.newTab().setText(tab_name)
					.setTabListener(this));
		}

		/**
		 * on swiping the viewpager make respective tab selected
		 * */
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				// on changing the page
				// make respected tab selected
				actionBar.setSelectedNavigationItem(position);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// on tab selected
		// show respected fragment view
		viewPager.setCurrentItem(tab.getPosition());

        Bundle extras = getIntent().getExtras();
          if (extras != null) {
              nom_carte = extras.getString("nom_carte");
           code_barre = extras.getLong("code_barre");
            montant = extras.getInt("montant");
            nb_point = extras.getInt("nb_point");
               descr_carte = extras.getString("descr_carte");
              image = extras.getString("image");



          }



	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	}

}
