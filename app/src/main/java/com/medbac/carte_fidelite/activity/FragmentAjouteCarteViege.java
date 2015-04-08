package com.medbac.carte_fidelite.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 07/04/2015.
 */
public class FragmentAjouteCarteViege   extends Fragment {
    Button scanner;
    Button valider;
    ImageView facvc,facve;
    Context c;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ajoute_carte_viege, container, false);
        scanner = (Button)  rootView.findViewById(R.id.button7);

        valider = (Button)  rootView.findViewById(R.id.button8);
        facvc = (ImageView)  rootView.findViewById(R.id.facv_cplus);
        facve = (ImageView)  rootView.findViewById(R.id.facv_eplus);
        addListenerOnButton();


        return rootView;
    }
    public void onClick2(View v) {

        if (v.getId() == facvc.getId()) {
            Intent i = new Intent(getActivity(), Activity_facvc.class);
            startActivity(i);
        }


    }


    public void addListenerOnButton() {
        facvc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                facvc.setFocusableInTouchMode(false);
                facvc.setFocusable(false);
                onClick2(arg0);

            }
        });


    }


}
