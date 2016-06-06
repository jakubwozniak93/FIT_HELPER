package com.example.jakub.fit_helper;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Plecy extends AppCompatActivity {

    private ImageView plecy_martwy_ciag;
    private ImageView plecy_maszyna;
    private ImageView plecy_przenoszenie_za_glowe;
    private ImageView plecy_wioslowanie_sztanga;
    private ImageView plecy_wioslowanie_sztangielka;
    private ImageView plecy_wyciag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plecy);


        plecy_martwy_ciag = (ImageView) findViewById(R.id.plecy_martwy_ciag);
        plecy_maszyna = (ImageView) findViewById(R.id.plecy_maszyna);
        plecy_przenoszenie_za_glowe = (ImageView) findViewById(R.id.plecy_przenoszenie_za_glowe);
        plecy_wioslowanie_sztanga = (ImageView) findViewById(R.id.plecy_wioslowanie_sztanga);
        plecy_wioslowanie_sztangielka = (ImageView) findViewById(R.id.plecy_wioslowanie_sztangielka);
        plecy_wyciag = (ImageView) findViewById(R.id.plecy_wyciag);


        plecy_martwy_ciag.post(new Runnable() {
            @Override
            public void run() {
                ((AnimationDrawable) plecy_martwy_ciag.getBackground()).start();
                ((AnimationDrawable) plecy_maszyna.getBackground()).start();
                ((AnimationDrawable) plecy_przenoszenie_za_glowe.getBackground()).start();
                ((AnimationDrawable) plecy_wioslowanie_sztanga.getBackground()).start();
                ((AnimationDrawable) plecy_wioslowanie_sztangielka.getBackground()).start();
                ((AnimationDrawable) plecy_wyciag.getBackground()).start();
            }

        });
    }

    public void dane(View view){
        String idPartii = "Plecy";
        int idCwiczenia = 0;
        switch (view.getId()) {
            case R.id.b1:
            case R.id.plecy_martwy_ciag:
            case R.id.textView4:
                idCwiczenia = 1;
                break;
            case R.id.b2:
            case R.id.plecy_maszyna:
            case R.id.textView8:
                idCwiczenia = 2;
                break;
            case R.id.b3:
            case R.id.plecy_przenoszenie_za_glowe:
            case R.id.textView12:
                idCwiczenia = 3;
                break;
            case R.id.b4:
            case R.id.plecy_wioslowanie_sztanga:
            case R.id.textView13:
                idCwiczenia = 4;
                break;
            case R.id.b5:
            case R.id.plecy_wioslowanie_sztangielka:
            case R.id.textView14:
                idCwiczenia = 5;
                break;
            case R.id.b6:
            case R.id.plecy_wyciag:
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
