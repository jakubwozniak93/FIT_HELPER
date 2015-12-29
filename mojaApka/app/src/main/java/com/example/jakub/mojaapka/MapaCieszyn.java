package com.example.jakub.mojaapka;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

public class MapaCieszyn extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static SeekBar seek_bar;
    private static TextView text_viewSB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_cieszyn);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        seeb_bar();


    }
    public void seeb_bar( ){
        seek_bar = (SeekBar) findViewById(R.id.seekBar);
        text_viewSB = (TextView) findViewById(R.id.textViewSB);
        text_viewSB.setText("Cena: "+ seek_bar.getProgress() + "zł");



        seek_bar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    int progress_Value;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        progress_Value = progress;
                        text_viewSB.setText("Cena: "+ progress + "zł");

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                        text_viewSB.setText("Cena: "+ progress_Value + "zł");
                        setMark(progress_Value);
                    }
                }
        );
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        int cena;

        // Add a marker in Sydney and move the camera
        LatLng cieszyn = new LatLng(49.7486583,18.6326757);

        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
        mMap.setMyLocationEnabled(true);


        mMap.moveCamera(CameraUpdateFactory.newLatLng(cieszyn));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cieszyn, 16));

        // Zoom in, animating the camera.
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16), 2000, null);

    }

    public void setMark(int progr){
        LatLng metro = new LatLng(49.749157, 18.634178);
        LatLng zak = new LatLng(49.748563, 18.633635);
        LatLng merkury = new LatLng(49.749129, 18.633250);
        LatLng arkady = new LatLng(49.748835, 18.633074);
        LatLng kufelek = new LatLng(49.748694, 18.631720);
        switch (progr)
        {
            case 0:
            case 1:
            case 2:
            case 3:
                Toast.makeText(MapaCieszyn.this, "Brak piwa w tej cenie :(",
                        Toast.LENGTH_SHORT).show();
                break;
            case 4:
                mMap.clear();
                marker(kufelek, "Kufelek :)", 4);
                break;
            case 5:
                mMap.clear();
                marker(metro, "Metro ", 5);

                break;
            case 6:
                mMap.clear();
                marker(arkady, "Arkady ", 6);

                break;
            case 7:
                mMap.clear();
                marker(merkury, "Merkury ", 7);

                break;
            case 8:
                mMap.clear();
                marker(zak, "Żak ", 8);

                break;
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                Toast.makeText(MapaCieszyn.this, "Brak piwa w tej cenie :(",
                        Toast.LENGTH_SHORT).show();
                break;

        }
    }

    public void marker(LatLng name, String Name, int cena){
        mMap.addMarker(new MarkerOptions().position(name).title(Name + cena + "zł").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_beer)));
    }



}
