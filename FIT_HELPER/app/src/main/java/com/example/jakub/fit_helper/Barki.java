package com.example.jakub.fit_helper;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Barki extends AppCompatActivity {

    private ImageView barki_arnoldki;
    private ImageView barki_pociaganie_broda;
    private ImageView barki_unoszenie_przod;
    private ImageView barki_wioslowanie;
    private ImageView barki_wyciskanie_sztangi_przed;
    private ImageView barki_wyciskanie_sztangielek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barki);

        barki_arnoldki = (ImageView) findViewById(R.id.barki_arnoldki);
        barki_pociaganie_broda = (ImageView) findViewById(R.id.barki_pociaganie_broda);
        barki_unoszenie_przod = (ImageView) findViewById(R.id.barki_unoszenie_przod);
        barki_wioslowanie = (ImageView) findViewById(R.id.barki_wioslowanie);
        barki_wyciskanie_sztangi_przed = (ImageView) findViewById(R.id.barki_wyciskanie_sztangi_przed);
        barki_wyciskanie_sztangielek = (ImageView) findViewById(R.id.barki_wyciskanie_sztangielek);


        barki_arnoldki.post(new Runnable() {
            @Override
            public void run() {
                ((AnimationDrawable) barki_arnoldki.getBackground()).start();
                ((AnimationDrawable) barki_pociaganie_broda.getBackground()).start();
                ((AnimationDrawable) barki_unoszenie_przod.getBackground()).start();
                ((AnimationDrawable) barki_wioslowanie.getBackground()).start();
                ((AnimationDrawable) barki_wyciskanie_sztangi_przed.getBackground()).start();
                ((AnimationDrawable) barki_wyciskanie_sztangielek.getBackground()).start();
            }

        });

    }

    public void dane(View view){
        String idPartii = "Barki";
        int idCwiczenia = 0;
        switch (view.getId()) {
            case R.id.b1:
            case R.id.barki_arnoldki:
            case R.id.textView4:
                idCwiczenia = 1;
                break;
            case R.id.b2:
            case R.id.barki_pociaganie_broda:
            case R.id.textView8:
                idCwiczenia = 2;
                break;
            case R.id.b3:
            case R.id.barki_unoszenie_przod:
            case R.id.textView12:
                idCwiczenia = 3;
                break;
            case R.id.b4:
            case R.id.barki_wioslowanie:
            case R.id.textView13:
                idCwiczenia = 4;
                break;
            case R.id.b5:
            case R.id.barki_wyciskanie_sztangielek:
            case R.id.textView14:
                idCwiczenia = 5;
                break;
            case R.id.b6:
            case R.id.barki_wyciskanie_sztangi_przed:
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
