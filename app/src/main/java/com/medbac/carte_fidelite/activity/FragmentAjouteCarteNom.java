package com.medbac.carte_fidelite.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;

import com.medbac.carte_fidelite.Adapter.AdapterListAjouteCarteAllCarte;
import com.medbac.carte_fidelite.Downloader.GetAllCarte;
import com.medbac.carte_fidelite.Models.Carte;

import java.util.ArrayList;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 07/04/2015.
 */
public class FragmentAjouteCarteNom  extends Fragment {
    ArrayList<Carte> ListAllCarte;
    ListView ListViewAllCarte;
    AdapterListAjouteCarteAllCarte adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_ajoute_carte_nom, container, false);

        ListViewAllCarte = (ListView)rootView.findViewById(R.id.listViewAllCarte);
        ListAllCarte=new ArrayList<Carte>();
        //  Log.e("FRgetallcarte", "" + GetAllCarte.ListAllCarte.size());

        ListAllCarte= GetAllCarte.ListAllCarte;

        adapter = new AdapterListAjouteCarteAllCarte(getActivity(), ListAllCarte);
        ListViewAllCarte.setAdapter(adapter);
        return rootView;

    }

}