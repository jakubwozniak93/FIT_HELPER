package com.example.jakub.mojaapka;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.model.Marker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }




    public void reakcjaKrk(View view){
        Intent i = new Intent(this,MapaKrakow.class);
        startActivity(i);
    }

    public void reakcjaWroc(View view){
        Intent i = new Intent(this,MapaWroclaw.class);
        startActivity(i);
    }

    public void reakcjaKato(View view){
        Intent i = new Intent(this, MapaKatowice.class);
        startActivity(i);
    }

    public void reakcjaCiesz(View view){
        Intent i = new Intent(this, MapaCieszyn.class);
        startActivity(i);
    }


}
