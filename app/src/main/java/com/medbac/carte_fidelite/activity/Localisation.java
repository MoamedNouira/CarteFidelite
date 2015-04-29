package com.medbac.carte_fidelite.activity;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 26/04/2015.
 */
public class Localisation extends Activity {
    private   LatLng TutorialsPoint ;
    private GoogleMap googleMap;
    int i ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);



        LocationManager lm = (LocationManager)Localisation.this.getSystemService(Localisation.LOCATION_SERVICE);
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        TutorialsPoint = new LatLng(latitude,longitude);

        try {
            if (googleMap == null) {
                googleMap = ((MapFragment) getFragmentManager().
                        findFragmentById(R.id.map)).getMap();
            }
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(new LatLng(latitude, longitude)).zoom(12).build();
            googleMap.animateCamera(CameraUpdateFactory
                    .newCameraPosition(cameraPosition));




            Marker TP = googleMap.addMarker(new MarkerOptions().
                    position(TutorialsPoint).title("TutorialsPoint"));
if(InfoEnseigne.list_coor.size()!=0){

        for(int x=0;x<InfoEnseigne.list_coor.size();x++)
    {
        TutorialsPoint = new LatLng(InfoEnseigne.list_coor.get(x).getLatitude(),InfoEnseigne.list_coor.get(x).getLongitude());

        googleMap.addMarker(new MarkerOptions().
                position(TutorialsPoint).title("TutorialsPoint"));
    }

}



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}