package com.medbac.carte_fidelite.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import com.medbac.carte_fidelite.Adapter.AdapterListAjouteCarteAllCarte;
import com.medbac.carte_fidelite.Downloader.GetAllCarte;
import com.medbac.carte_fidelite.Downloader.GetClient;
import com.medbac.carte_fidelite.Downloader.getAllEnseigne;
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

        ListAllCarte= GetAllCarte.ListAllCarte;

        adapter = new AdapterListAjouteCarteAllCarte(getActivity(), ListAllCarte);
        ListViewAllCarte.setAdapter(adapter);
        ListViewAllCarte.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position,long arg3) {
                Intent i = new Intent(getActivity(),AjouteCarte.class);
                i.putExtra("position", position);
                ArrayList <Carte> ListCarte2 =new ArrayList<Carte>();
                ListCarte2 =  GetAllCarte.ListAllCarte;
                i.putExtra("nom_carte",ListCarte2.get(position).getNom());
                i.putExtra("id_carte",ListCarte2.get(position).getId_carte());
                i.putExtra("id_client", GetClient.client1.getId_clinet());
                i.putExtra("des",ListCarte2.get(position).getDescr_carte());

                for(int x=0;x< getAllEnseigne.ListEnseignes.size();x++){
                    if(ListCarte2.get(position).getId_enseigne()== getAllEnseigne.ListEnseignes.get(x).getId_enseigne())
                    {
                        i.putExtra("nom_ens", getAllEnseigne.ListEnseignes.get(x).getNom_commercial());
                    }

                }

                startActivity(i);

            }

        });
        return rootView;

    }

}