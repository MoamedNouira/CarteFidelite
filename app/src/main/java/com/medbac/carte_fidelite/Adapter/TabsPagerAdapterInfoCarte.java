package com.medbac.carte_fidelite.Adapter;

import com.medbac.carte_fidelite.activity.CarteLocaliser;
import com.medbac.carte_fidelite.activity.InfoCarteCarte;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapterInfoCarte extends FragmentPagerAdapter {

	public TabsPagerAdapterInfoCarte(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			// Top Rated fragment activity

			return new InfoCarteCarte();
		case 1:
			// Games fragment activity
			return new CarteLocaliser();

		}

		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 2;
	}

}
