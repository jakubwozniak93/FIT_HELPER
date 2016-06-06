package com.example.jakub.fit_helper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Trening_dane extends AppCompatActivity {

    EditText iloscserii;
    LinearLayout linearDane;
    Button button;
    int ilosc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trening_dane);
    }

    public void wypelnienie(View view){
        iloscserii = (EditText) findViewById(R.id.ilosc_serii);
        ilosc = Integer.parseInt(iloscserii.getText().toString());


        for(int i=0; i<ilosc; i++){
            formularz(i+1);
        }
        button = new Button(this);
        button.setText("Dodaj");
        button.setOnClickListener(akcja);
        linearDane.addView(button);

    }

    public void formularz(int ilosc)
    {
            linearDane  = (LinearLayout) findViewById(R.id.linearDane);

            TextView seria = new TextView(this);
            TextView newTextView = new TextView(this);
            EditText newEditText = new EditText(this);
            TextView newTextView1 = new TextView(this);
            EditText newEditText1 = new EditText(this);


            seria.setText("Seria " + ilosc);
            seria.setTextSize(22);
            //String costam = seria.getText().toString();

            newTextView.setText("Podaj ilość powtórzeń: ");
            newTextView.setTextSize(22);

            newEditText.setHint("ilość powtórzeń");
            newEditText.setTextSize(22);
            newEditText.setId(ilosc);


            newTextView1.setText("Obciążenie: ");
            newTextView1.setTextSize(22);


            newEditText1.setHint("obciążenie");
            newEditText1.setTextSize(22);
            newEditText1.setId(ilosc);

            /*button = new Button(this);
            button.setText("Dodaj");
            button.setOnClickListener(akcja);
            linearDane.addView(button);*/


            linearDane.addView(seria);
            linearDane.addView(newTextView);
            linearDane.addView(newEditText);
            linearDane.addView(newTextView1);
            linearDane.addView(newEditText1);


    }

    private View.OnClickListener akcja = new View.OnClickListener() {
        public void onClick(View view) {

        }
    };




}
