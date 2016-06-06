package com.example.jakub.fit_helper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jakub.fit_helper.Ramie;

public class Trening extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trening);
    }

    public void ramie(View v)
    {
        Intent intent = new Intent(this, Ramie.class);
        startActivity(intent);
    }

    public void klatka(View v)
    {
        Intent intent = new Intent(this, Klatka.class);
        startActivity(intent);
    }

    public void plecy(View v)
    {
        Intent intent = new Intent(this, Plecy.class);
        startActivity(intent);
    }

    public void barki(View v)
    {
        Intent intent = new Intent(this, Barki.class);

        startActivity(intent);
    }


    public void nogi(View v)
    {
        Intent intent = new Intent(this, Nogi.class);
        startActivity(intent);
    }
}
