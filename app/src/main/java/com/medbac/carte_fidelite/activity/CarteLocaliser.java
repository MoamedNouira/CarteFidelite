package com.medbac.carte_fidelite.activity;

import activity.carte_fidelite.medbac.com.cartefidelite.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CarteLocaliser extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_info_carte_localiser, container, false);
		
		return rootView;
	}

}
