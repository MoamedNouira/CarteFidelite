package com.medbac.carte_fidelite.activity;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;

public class InfoCarteCarte extends Fragment implements View.OnClickListener {
    Button scanBtn;



    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);




    }



	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_info_carte_carte, container, false);
        TextView nom_carte = (TextView)  rootView.findViewById(R.id.textView10);
        TextView  descr_carte = (TextView)  rootView.findViewById(R.id.textView11);
        TextView montant = (TextView)  rootView.findViewById(R.id.textView12);
        TextView nb_point = (TextView)  rootView.findViewById(R.id.textView13);
        scanBtn = (Button)  rootView.findViewById(R.id.ButtonButton);

        nom_carte.setText(FrInfoCarte.nom_carte+"");
        descr_carte.setText(FrInfoCarte.descr_carte+"");
        montant.setText(FrInfoCarte.montant+"");
        nb_point.setText(FrInfoCarte.nb_point+"");
        scanBtn.setOnClickListener(this);






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
    public void onClick(View v){

        if(v.getId()==R.id.ButtonButton){
            Intent i = new Intent(getActivity(), AffichageBarreCode.class);
            long scode = FrInfoCarte.code_barre;
            Log.e(" scodescodescodescodescode",""+scode);
            String strLong = Long.toString(scode);
            i.putExtra("scode",strLong);
            startActivity(i);

            // setResult(Facvc.RESULT_OK);



        }
    }

}
