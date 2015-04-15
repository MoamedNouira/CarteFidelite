package com.medbac.carte_fidelite.activity;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class InfoCarteCarte extends Fragment {

    public static TextView id_compte;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);




    }



	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_info_carte_carte, container, false);
        id_compte = (TextView)  rootView.findViewById(R.id.textView10);

           id_compte.setText(FrInfoCarte.info_carte_id_compte+"");





        //    if (getArguments() != null){

      //      Bundle data = getArguments();
      //      int strtext= data.getInt("id_compte");
      //      id_compte.setText(strtext);
    //    }else {
    //        id_compte.setText("null");
     //   }
    //    int strtext=getArguments().getInt("id_compte",0);
      //  id_compte.setText("");

        return rootView;
	}
}
