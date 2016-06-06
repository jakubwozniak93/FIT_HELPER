package com.example.jakub.fit_helper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void kalkulator(View v)
    {
        Intent intent = new Intent(this, Kalkulator.class);
        startActivity(intent);
    }

    public void Kalendarz(View v)
    {
        Intent intent = new Intent(this, Kalendarz.class);
        startActivity(intent);
    }

    public void Trening(View v)
    {
        Intent intent = new Intent(this, Trening.class);
        startActivity(intent);
    }

    public void Autor(View v)
    {
        Intent intent = new Intent(this, Autor.class);
        startActivity(intent);
    }
}
