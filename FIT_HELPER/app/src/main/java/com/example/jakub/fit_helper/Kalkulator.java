package com.example.jakub.fit_helper;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Kalkulator extends AppCompatActivity {

    static int wynikPlec;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);

        Spinner staticSpinner = (Spinner) findViewById(R.id.spinnerAktywnosc);
        Spinner staticSpinner2 = (Spinner) findViewById(R.id.spinnerCel);
        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.aktywność,
                        android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> staticAdapter2 = ArrayAdapter
                .createFromResource(this, R.array.cel,
                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        staticAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        staticSpinner.setAdapter(staticAdapter);
        staticSpinner2.setAdapter(staticAdapter2);
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton:
                if (checked)
                    wynikPlec = 1;
                //Toast.makeText(this, "kobieta", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.radioButton2:
                if (checked)
                    wynikPlec = 2;
                //Toast.makeText(this, "mezczyzna", Toast.LENGTH_SHORT).show();
                    break;
        }
    }


    public void oblicz(View v)
    {
        double BMR = 0.0;
        double EPOC = 0.0;
        double trening = 0.0;
        double TEA = 0.0;
        double cell = 0.0;
        double TEF = 0.0;
        double TDEE = 0.0;

        EditText editMasa = (EditText) findViewById(R.id.masa);
        String masa = editMasa.getText().toString();

        EditText editWzrost = (EditText) findViewById(R.id.wzrost);
        String wzrost = editWzrost.getText().toString();

        EditText editWiek = (EditText) findViewById(R.id.wiek);
        String wiek = editWiek.getText().toString();

        if (masa.matches("")||wzrost.matches("")||wiek.matches("")) {
            Toast.makeText(this, "Zostawiłeś puste pole.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(wynikPlec == 1) {
            BMR = (9.99 * Double.parseDouble(masa)) + (6.25*Double.parseDouble(wzrost)) - (4.92*Double.parseDouble(wiek)) - 161;
        }else if(wynikPlec == 2){
            BMR = (9.99 * Double.parseDouble(masa)) + (6.25*Double.parseDouble(wzrost)) - (4.92*Double.parseDouble(wiek)) + 5;
        }

        //Toast.makeText(this, "Twoje podstawowe zapotrzebowanie kaloryczne to: "+BMR, Toast.LENGTH_SHORT).show();


        Spinner spinnerAktywnosc =(Spinner) findViewById(R.id.spinnerAktywnosc);
        String aktywnosc = spinnerAktywnosc.getSelectedItem().toString();

        switch(aktywnosc)
        {
            case "Wybierz rodzaj aktywności fizycznej":
                Toast.makeText(this, "Wybierz rodzaj aktywności fizycznej", Toast.LENGTH_SHORT).show();
                return;
            case "Znikoma (brak ćwiczeń, praca siedząca, szkoła)":
                trening = 0.0;
                break;
            case "Bardzo mała (ćwiczenia raz na tydzień, praca lekka)":
                trening = 1.0;
                break;
            case "Umiarkowana (ćwiczenia 2 razy w tygodniu)":
                trening = 2.0;
                break;
            case "Duża (dość ciężki trening kilka razy w tygodniu)":
                trening = 3.0;
                break;
            case "Bardzo duża (przynajmniej 4 treningi w tygodniu, praca fizyczna)":
                trening = 4.0;
                break;
        }




        EPOC = trening * (0.07 * BMR);

        TEA = ((8*(trening*60))+EPOC)/7;

        TEF = 0.08*(BMR+TEA+550);

        TDEE = BMR + TEA + TEF + 550;

        Spinner spinnerCel =(Spinner) findViewById(R.id.spinnerCel);
        String cel = spinnerCel.getSelectedItem().toString();
        switch(cel)
        {
            case "Wybierz co chcesz osiągnąć":
                Toast.makeText(this, "Wybierz cel który chcesz osiągnąć!", Toast.LENGTH_SHORT).show();
                return;
            case "Chcę przytyć":
                cell = 1.2*TDEE;
                break;
            case "Chcę utrzymać wagę":
                cell = TDEE;
                break;
            case "Chcę schudnąć":
                cell = 0.8*TDEE;
                break;
        }

        DecimalFormat precision = new DecimalFormat("0");



        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        // set title
        alertDialogBuilder.setTitle("Twoje dzienne zapotrzebowanie kaloryczne: ");
        //alertDialogBuilder.setMessage(precision.format(cell));

        // set dialog message
        alertDialogBuilder
                .setMessage(precision.format(cell)+" kcal" + "\n"+"\n" + "Chcesz powtórzyć?")
                //.setMessage("Chcesz powtórzyć?")
                .setCancelable(false)
                .setPositiveButton("Nie",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity
                        Kalkulator.this.finish();
                    }
                })
                .setNegativeButton("Tak", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        Kalkulator.this.onRestart();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();


        if (masa.matches("")||wzrost.matches("")||wiek.matches("")) {
            Toast.makeText(this, "Zostawiłeś puste pole.", Toast.LENGTH_SHORT).show();

        }
    }
}
