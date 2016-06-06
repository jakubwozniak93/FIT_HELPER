package com.example.jakub.fit_helper;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class Ramie extends AppCompatActivity {

    private ImageView ramie_francuskie;
    private ImageView ramie_pompki_maszyna;
    private ImageView ramie_prostowanie_wyciag;
    private ImageView ramie_uginanie_modlitewnik;
    private ImageView ramie_uginanie_nadgarstkow;
    private ImageView ramie_uginanie_podchwytem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramie);


        ramie_francuskie = (ImageView) findViewById(R.id.ramie_francuskie);
        ramie_pompki_maszyna = (ImageView) findViewById(R.id.ramie_pompki_maszyna);
        ramie_prostowanie_wyciag = (ImageView) findViewById(R.id.ramie_prostowanie_wyciag);
        ramie_uginanie_modlitewnik = (ImageView) findViewById(R.id.ramie_uginanie_modlitewnik);
        ramie_uginanie_nadgarstkow = (ImageView) findViewById(R.id.ramie_uginanie_nadgarstkow);
        ramie_uginanie_podchwytem = (ImageView) findViewById(R.id.ramie_uginanie_podchwytem);


        ramie_francuskie.post(new Runnable() {
            @Override
            public void run() {
                ((AnimationDrawable) ramie_francuskie.getBackground()).start();
                ((AnimationDrawable) ramie_pompki_maszyna.getBackground()).start();
                ((AnimationDrawable) ramie_prostowanie_wyciag.getBackground()).start();
                ((AnimationDrawable) ramie_uginanie_modlitewnik.getBackground()).start();
                ((AnimationDrawable) ramie_uginanie_nadgarstkow.getBackground()).start();
                ((AnimationDrawable) ramie_uginanie_podchwytem.getBackground()).start();
            }

        });
    }

    public void dane(View view){
        String idPartii = "Ramie";
        int idCwiczenia = 0;
        switch (view.getId()) {
            case R.id.b1:
            case R.id.ramie_francuskie:
            case R.id.textView4:
                idCwiczenia = 1;
                break;
            case R.id.b2:
            case R.id.ramie_pompki_maszyna:
            case R.id.textView8:
                idCwiczenia = 2;
                break;
            case R.id.b3:
            case R.id.ramie_prostowanie_wyciag:
            case R.id.textView12:
                idCwiczenia = 3;
                break;
            case R.id.b4:
            case R.id.ramie_uginanie_modlitewnik:
            case R.id.textView13:
                idCwiczenia = 4;
                break;
            case R.id.b5:
            case R.id.ramie_uginanie_nadgarstkow:
            case R.id.textView14:
                idCwiczenia = 5;
                break;
            case R.id.b6:
            case R.id.ramie_uginanie_podchwytem:
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
