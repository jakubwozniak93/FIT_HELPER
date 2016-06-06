package com.example.jakub.fit_helper;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Kalendarz_Dane extends AppCompatActivity {

    TextView textView5;
    TextView dataKalendarz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalendarz__dane);

        dodajDane(null);
    }




    public void dodajDane(View view){
       /* textView5 = (TextView) findViewById(R.id.posortowane);
        textView5.setText("test");
        DaneDbAdapter daneDbAdapter = new DaneDbAdapter(this);
        daneDbAdapter.open();

        Cursor daneCursor = daneDbAdapter.getDane();
        StringBuilder results = new StringBuilder();
        if(daneCursor.moveToFirst()){
            do{
                Dane dane = daneDbAdapter.getDaneFromCursor(daneCursor);
                results.append(dane.mId+" "+ dane.mPowtorzenia+" " + dane.mObciazenie+" "+ dane.mData +" \n" );

            }while (daneCursor.moveToNext());
        }
        daneCursor.close();
        daneDbAdapter.close();
        String results2 = results.toString();
        textView5.setText(results2);
        */

        textView5 = (TextView) findViewById(R.id.posortowane);
        textView5.setText("test");

        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        dataKalendarz = (TextView) findViewById(R.id.dataKalendarz);
        dataKalendarz.setText(data);

        DaneDbAdapter daneDbAdapter = new DaneDbAdapter(this);
        daneDbAdapter.open();

        Cursor daneCursor = daneDbAdapter.szukajPoDacie(data);
        StringBuilder results = new StringBuilder();
        if(daneCursor.moveToFirst()){
            do{
                Dane dane = daneDbAdapter.getDaneFromCursor(daneCursor);
                results.append(dane.mCwiczenie+"\n"+ dane.mSeria + "\n" + "Powtórzenia: " + dane.mPowtorzenia+"\n"+ "Obciążenie: " + dane.mObciazenie+"\n\n" );

            }while (daneCursor.moveToNext());
        }
        daneCursor.close();
        daneDbAdapter.close();
        textView5.setText(results.toString());
    }
}
