package team42.cs2340.rattrackingapp.Controller;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import team42.cs2340.rattrackingapp.R;
import team42.cs2340.rattrackingapp.Model.Admin;
import team42.cs2340.rattrackingapp.Model.Borough;
import team42.cs2340.rattrackingapp.Model.LocationType;
import team42.cs2340.rattrackingapp.Model.Model;
import team42.cs2340.rattrackingapp.Model.Rat;
import team42.cs2340.rattrackingapp.Model.RatSightingData;
import team42.cs2340.rattrackingapp.Model.User;
import team42.cs2340.rattrackingapp.R;
import android.content.Context;

/**
 * Created by Beatrice on 10/25/17.
 */

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney, Australia, and move the camera.
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}