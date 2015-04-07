package com.medbac.carte_fidelite.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.medbac.carte_fidelite.activity.FragmentAjouteCarteCategorie;
import com.medbac.carte_fidelite.activity.FragmentAjouteCarteNom;
import com.medbac.carte_fidelite.activity.FragmentAjouteCarteViege;

/**
 * Created by Mohamed Nouira on 07/04/2015.
 */
public class TabsPagerAdapterAjouteCarte  extends FragmentPagerAdapter {

    public TabsPagerAdapterAjouteCarte (FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Top Rated fragment activity

                return new FragmentAjouteCarteCategorie();
            case 1:
                // Games fragment activity
                return new FragmentAjouteCarteNom();
            case 2:
                // Games fragment activity
                return new FragmentAjouteCarteViege();

        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }

}
