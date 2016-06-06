package com.example.jakub.fit_helper;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Klatka extends AppCompatActivity {


    private ImageView sztangielka_plaska;
    private ImageView sztanga_plasko;
    private ImageView rozpietki_plasko;
    private ImageView przenoszenie;
    private ImageView krzyzowanie_gora;
    private ImageView krzyzowanie_dol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klatka);


        sztangielka_plaska = (ImageView) findViewById(R.id.sztangielka_plaska);
        sztanga_plasko = (ImageView) findViewById(R.id.sztanga_plasko);
        rozpietki_plasko = (ImageView) findViewById(R.id.rozpietki_plasko);
        przenoszenie = (ImageView) findViewById(R.id.przenoszenie);
        krzyzowanie_gora = (ImageView) findViewById(R.id.krzyzowanie_gora);
        krzyzowanie_dol = (ImageView) findViewById(R.id.krzyzowanie_dol);


        sztangielka_plaska.post(new Runnable() {
            @Override
            public void run() {
                ((AnimationDrawable) sztangielka_plaska.getBackground()).start();
                ((AnimationDrawable) sztanga_plasko.getBackground()).start();
                ((AnimationDrawable) rozpietki_plasko.getBackground()).start();
                ((AnimationDrawable) przenoszenie.getBackground()).start();
                ((AnimationDrawable) krzyzowanie_gora.getBackground()).start();
                ((AnimationDrawable) krzyzowanie_dol.getBackground()).start();
            }

        });



    }

    public void dane(View view){
        String idPartii = "Klatka";
        int idCwiczenia = 0;
        switch (view.getId()) {
            case R.id.b1:
            case R.id.sztangielka_plaska:
            case R.id.textView4:
                idCwiczenia = 1;
                break;
            case R.id.b2:
            case R.id.sztanga_plasko:
            case R.id.textView8:
                idCwiczenia = 2;
                break;
            case R.id.b3:
            case R.id.rozpietki_plasko:
            case R.id.textView12:
                idCwiczenia = 3;
                break;
            case R.id.b4:
            case R.id.przenoszenie:
            case R.id.textView13:
                idCwiczenia = 4;
                break;
            case R.id.b5:
            case R.id.krzyzowanie_gora:
            case R.id.textView14:
                idCwiczenia = 5;
                break;
            case R.id.b6:
            case R.id.krzyzowanie_dol:
            case R.id.textView7:
                idCwiczenia = 6;
                break;
        }


        Intent intent = new Intent(this, Dane_Trening.class);
        intent.putExtra("idCwiczenia", idCwiczenia);
        intent.putExtra("idPartii", idPartii);
        startActivity(intent);
    }
}