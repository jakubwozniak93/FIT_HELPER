package com.example.jakub.fit_helper;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Nogi extends AppCompatActivity {

    private ImageView nogi_prostowanie_maszyna;
    private ImageView nogi_przysiad;
    private ImageView nogi_suwnica;
    private ImageView nogi_wykroki_sztanga;
    private ImageView nogi_wykroki_sztangielki;
    private ImageView nogi_wypychanie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nogi);


        nogi_prostowanie_maszyna = (ImageView) findViewById(R.id.nogi_prostowanie_maszyna);
        nogi_przysiad = (ImageView) findViewById(R.id.nogi_przysiad);
        nogi_suwnica = (ImageView) findViewById(R.id.nogi_suwnica);
        nogi_wykroki_sztanga = (ImageView) findViewById(R.id.nogi_wykroki_sztanga);
        nogi_wykroki_sztangielki = (ImageView) findViewById(R.id.nogi_wykroki_sztangielki);
        nogi_wypychanie = (ImageView) findViewById(R.id.nogi_wypychanie);


        nogi_prostowanie_maszyna.post(new Runnable() {
            @Override
            public void run() {
                ((AnimationDrawable) nogi_prostowanie_maszyna.getBackground()).start();
                ((AnimationDrawable) nogi_przysiad.getBackground()).start();
                ((AnimationDrawable) nogi_suwnica.getBackground()).start();
                ((AnimationDrawable) nogi_wykroki_sztanga.getBackground()).start();
                ((AnimationDrawable) nogi_wykroki_sztangielki.getBackground()).start();
                ((AnimationDrawable) nogi_wypychanie.getBackground()).start();
            }

        });
    }

    public void dane(View view){
        String idPartii = "Nogi";
        int idCwiczenia = 0;
        switch (view.getId()) {
            case R.id.b1:
            case R.id.nogi_prostowanie_maszyna:
            case R.id.textView4:
                idCwiczenia = 1;
                break;
            case R.id.b2:
            case R.id.nogi_przysiad:
            case R.id.textView8:
                idCwiczenia = 2;
                break;
            case R.id.b3:
            case R.id.nogi_suwnica:
            case R.id.textView12:
                idCwiczenia = 3;
                break;
            case R.id.b4:
            case R.id.nogi_wykroki_sztanga:
            case R.id.textView13:
                idCwiczenia = 4;
                break;
            case R.id.b5:
            case R.id.nogi_wykroki_sztangielki:
            case R.id.textView14:
                idCwiczenia = 5;
                break;
            case R.id.b6:
            case R.id.nogi_wypychanie:
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
