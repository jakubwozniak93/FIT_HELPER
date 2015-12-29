package com.example.jakub.mojaapka;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaKrakow extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_krakow2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng cracow = new LatLng(50.062093, 19.937250);

        LatLng alternatywy = new LatLng(50.061141, 19.940600);
        LatLng goraczka = new LatLng(50.0623985,19.9355481);
        LatLng spolem = new LatLng(50.063975, 19.936551);
        LatLng frantic = new LatLng(50.062345, 19.935525);

        int cena = 7;

        mMap.moveCamera(CameraUpdateFactory.newLatLng(cracow));
        mMap.addMarker(new MarkerOptions().position(goraczka).title("Gorączka - " + cena + "zł").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_beer)));
        mMap.addMarker(new MarkerOptions().position(alternatywy).title("Alternatywy " + "- 5zł").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_beer)));
        mMap.addMarker(new MarkerOptions().position(spolem).title("Społem " + "- 6zł").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_beer)));
        mMap.addMarker(new MarkerOptions().position(frantic).title("Frantic " + "- 14zł").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_beer)));




        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cracow, 16));

        // Zoom in, animating the camera.
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16), 2000, null);

    }

    public void Marker(LatLng name, int price){
        mMap.addMarker(new MarkerOptions().position(name).title(name +" - " + price + "zł").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_beer)));
    }
}
