package com.example.jakub.fit_helper;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Dane_Trening extends AppCompatActivity {

    int iloscSerii;
    String iloscSeriiText;
    String nazwaCwiczenia;
    String nazwaCwiczeniadb;
    String nazwaPartii;
    TextView seria;
    EditText iloscPowtorzen;
    EditText iloscObciazenia;
    String rodzajCwiczenia;
    TextView partia;
    String rodzajPartii;
    TextView cwiczenie;
    int powtorzenia = 0;
    int obciazenie = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dane__trening);
        Intent intent= getIntent();
        int idCwiczenia= intent.getIntExtra("idCwiczenia", 0);
        String idPartii = intent.getStringExtra("idPartii");

        /**
         * sprawdzanie wybranej partii mięśni, oraz wybranego ćwiczenia.
         */
        switch (idPartii) {
            case "Barki":
                nazwaPartii = "Barki";
                switch (idCwiczenia) {
                    case 1:
                        nazwaCwiczenia = "Arnoldki";
                        nazwaCwiczeniadb = "Arnoldki";
                        break;
                    case 2:
                        nazwaCwiczenia = "Podciąganie\nsztangi do brody";
                        nazwaCwiczeniadb = "Podciąganie sztangi do brody";
                        break;
                    case 3:
                        nazwaCwiczenia = "Unoszenie\nsztangi w przód";
                        nazwaCwiczeniadb = "Unoszenie sztangi w przód";
                        break;
                    case 4:
                        nazwaCwiczenia = "Wiosłowanie\nsztangą";
                        nazwaCwiczeniadb = "Wiosłowanie sztangą";
                        break;
                    case 5:
                        nazwaCwiczenia = "Wyciskanie\nsztangielek";
                        nazwaCwiczeniadb = "Wyciskanie sztangielek";
                        break;
                    case 6:
                        nazwaCwiczenia = "Wyciskanie\nsztangi\nsprzed\ngłowy";
                        nazwaCwiczeniadb = "Wyciskanie sztangi sprzed głowy";
                        break;
                }
                    break;
            case "Klatka":
                nazwaPartii = "Klatka";
                switch (idCwiczenia) {
                    case 1:
                        nazwaCwiczenia = "Wyciskanie\nsztangielek\npoziomo";
                        nazwaCwiczeniadb = "Wyciskanie sztangielek poziomo";
                        break;
                    case 2:
                        nazwaCwiczenia = "Wyciskanie\nsztangi\npoziomo";
                        nazwaCwiczeniadb = "Wyciskanie sztangi poziomo";
                        break;
                    case 3:
                        nazwaCwiczenia = "Rozpiętki\npoziomo";
                        nazwaCwiczeniadb = "Rozpiętki poziomo";
                        break;
                    case 4:
                        nazwaCwiczenia = "Przenoszenie\nsztangielki w\npoprzek";
                        nazwaCwiczeniadb = "Przenoszenie sztangielki w poprzek";
                        break;
                    case 5:
                        nazwaCwiczenia = "Krzyżowanie\nlinek na\nwyciągu\ngórnym";
                        nazwaCwiczeniadb = "Krzyżowanie linek na wyciągu górnym";
                        break;
                    case 6:
                        nazwaCwiczenia = "Krzyżowanie\nlinek na\nwyciągu\ndolnym";
                        nazwaCwiczeniadb = "Krzyżowanie linek na wyciągu dolnym";
                        break;
                }
                break;
            case "Nogi":
                nazwaPartii = "Nogi";
                switch (idCwiczenia) {
                    case 1:
                        nazwaCwiczenia = "Prostowanie\nnóg\nna\nmaszynie";
                        nazwaCwiczeniadb = "Prostowanie nóg na maszynie";
                        break;
                    case 2:
                        nazwaCwiczenia = "Przysiad\nze\nsztangą";
                        nazwaCwiczeniadb = "Przysiad ze sztangą";
                        break;
                    case 3:
                        nazwaCwiczenia = "Wypychanie\nnóg\nna\nsuwnicy";
                        nazwaCwiczeniadb = "Wypychanie nóg na suwnicy";
                        break;
                    case 4:
                        nazwaCwiczenia = "Wykroki\nze\nsztangą";
                        nazwaCwiczeniadb = "Wykroki ze sztangą";
                        break;
                    case 5:
                        nazwaCwiczenia = "Wykroki\nze\nsztangielkami";
                        nazwaCwiczeniadb = "Wykroki ze sztangielkami";
                        break;
                    case 6:
                        nazwaCwiczenia = "Wypychanie\nnogi\nna\nmaszynie";
                        nazwaCwiczeniadb = "Wypychanie nogi na maszynie";
                        break;
                }
                break;
            case "Plecy":
                nazwaPartii = "Plecy";
                switch (idCwiczenia) {
                    case 1:
                        nazwaCwiczenia = "Martwy\nciąg";
                        nazwaCwiczeniadb = "Martwy ciąg";
                        break;
                    case 2:
                        nazwaCwiczenia = "Wiosłowanie\nwyciągu\ndolnego";
                        nazwaCwiczeniadb = "Wiosłowanie wyciągu dolnego";
                        break;
                    case 3:
                        nazwaCwiczenia = "Przenoszenie\nsztangi\nza\ngłowę";
                        nazwaCwiczeniadb = "Przenoszenie sztangi za głowę";
                        break;
                    case 4:
                        nazwaCwiczenia = "Wioslowanie\nsztanga";
                        nazwaCwiczeniadb = "Wioslowanie sztanga";
                        break;
                    case 5:
                        nazwaCwiczenia = "Wiosłowanie\nsztangielką";
                        nazwaCwiczeniadb = "Wiosłowanie sztangielką";
                        break;
                    case 6:
                        nazwaCwiczenia = "Ściąganie\ndrążka\nwyciągu\ndo\nklatki";
                        nazwaCwiczeniadb = "Ściąganie drążka wyciągu do klatki";
                        break;
                }
                break;
            case "Ramie":
                nazwaPartii = "Ramie";
                switch (idCwiczenia) {
                    case 1:
                        nazwaCwiczenia = "Wyciskanie\nfrancuskie\nsztangi\nleżąc";
                        nazwaCwiczeniadb = "Wyciskanie francuskie sztangi leżąc";
                        break;
                    case 2:
                        nazwaCwiczenia = "Pompki\nna\nmaszynie";
                        nazwaCwiczeniadb = "Pompki na maszynie";
                        break;
                    case 3:
                        nazwaCwiczenia = "Prostowanie\nprzedramion\nna\nwyciągu";
                        nazwaCwiczeniadb = "Prostowanie przedramion na wyciągu";
                        break;
                    case 4:
                        nazwaCwiczenia = "Uginanie\nprzedramion\nna\nmodlitewniku";
                        nazwaCwiczeniadb = "Uginanie przedramion na modlitewniku";
                        break;
                    case 5:
                        nazwaCwiczenia = "Uginanie\nnadgarstków\nz\nsztangą";
                        nazwaCwiczeniadb = "Uginanie nadgarstków z sztangą";
                        break;
                    case 6:
                        nazwaCwiczenia = "Uginanie\nprzedramion\nze\nsztangą";
                        nazwaCwiczeniadb = "Uginanie przedramion ze sztangą";
                        break;
                }
                break;
        }
        /**
         * wywołanie metody wypisującej dane do aktywności Dane_Trening.
         */
        wypelnienie(null);
    }

    /**
     * metoda wyświetlająca rodzaj ćwiczenia
     * @param view
     */
    public void wypelnienie(View view){
        partia = (TextView) findViewById(R.id.partia);
        partia.setText(nazwaPartii);
        rodzajPartii = nazwaPartii;
        cwiczenie = (TextView) findViewById(R.id.cwiczenie);
        cwiczenie.setText(nazwaCwiczenia);
        rodzajCwiczenia = nazwaCwiczeniadb;
    }

    /**
     * Metoda wywołana po naciśnięciu buttona "kolejna" sprawdza stan editText i zapisuje do bazy dane z formularza, czyści fromularz i zwiększa zeminną iloscSerii o 1.
     * @param view
     */
    public void kolejna(View view){
        seria = (TextView) findViewById(R.id.seria);
        SharedPreferences serie = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = serie.edit();
        int seriePref = serie.getInt("iloscSerii", 0);
        if(seriePref == 0){
            seriePref=1;
        }else {
            seriePref += 1;
        }

        editor.putInt("iloscSerii", seriePref);
        editor.commit();

        iloscSeriiText = "Seria: "+seriePref;


        iloscPowtorzen = (EditText) findViewById(R.id.ilosc_powtorzen);
        String powtorzeniaText = iloscPowtorzen.getText().toString();
        if(powtorzeniaText.length() == 0){
            Toast.makeText(getApplicationContext(), "Puste pole, uzupełnij dane! ", Toast.LENGTH_SHORT).show();
            return;
        }
        powtorzenia = Integer.parseInt(powtorzeniaText);
        iloscObciazenia = (EditText) findViewById(R.id.ilosc_obciazenia);
        String obciazenieText = iloscObciazenia.getText().toString();
        if(obciazenieText.length() == 0){
            Toast.makeText(getApplicationContext(), "Puste pole, uzupełnij dane! ", Toast.LENGTH_SHORT).show();
            return;
        }
        obciazenie = Integer.parseInt(obciazenieText);
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Dane.tworzDane().add(new Dane(rodzajCwiczenia, iloscSeriiText ,powtorzenia, obciazenie, date));
        seria.setText("seria: "+ Integer.toString(seriePref+1));
        DaneDbAdapter daneDbAdapter = new DaneDbAdapter(this);
        daneDbAdapter.open();

        //
        ContentValues newValues2 = new ContentValues();
        newValues2.put(DaneDbAdapter.CWICZENIE, rodzajCwiczenia);
        newValues2.put(DaneDbAdapter.SERIA, iloscSeriiText);
        newValues2.put(DaneDbAdapter.POWTORZENIA, powtorzenia);
        newValues2.put(DaneDbAdapter.OBCIAZENIE, obciazenie);
        newValues2.put(DaneDbAdapter.DATA, date);
        daneDbAdapter.insertDane(newValues2);

        Toast.makeText(getApplicationContext(), "dane zapisane: ", Toast.LENGTH_SHORT).show();
        daneDbAdapter.close();
        iloscPowtorzen.setText("");
        iloscObciazenia.setText("");
    }

    /**
     * Metoda wywołana po naciśnięciu buttona "zakoncz" sprawdza czy stan editText i zapisuje do bazy stan formularza,
     * po czym przechodzi do pierwszej aktywności.
     * @param view
     */
    public void zakoncz(View view){
        seria = (TextView) findViewById(R.id.ilosc_serii);

        SharedPreferences serie = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = serie.edit();
        int seriePref = serie.getInt("iloscSerii", 0);
        seriePref+=1;
        iloscSerii = 0;
        editor.putInt("iloscSerii",iloscSerii);
        editor.commit();

        iloscSeriiText = "Seria: "+seriePref;

        /**
         * pobranie ilosci powtórzeń z EditText, sprawdzenie czy jest pusty, oraz rzutowanie na int.
         */
        iloscPowtorzen = (EditText) findViewById(R.id.ilosc_powtorzen);
        String powtorzeniaText = iloscPowtorzen.getText().toString();
        if(powtorzeniaText.length() != 0){
            powtorzenia = Integer.parseInt(powtorzeniaText);
        }
        /**
         * pobranie ilosci obciazenia z EditText, sprawdzenie czy jest pusty, oraz rzutowanie na int.
         */
        iloscObciazenia = (EditText) findViewById(R.id.ilosc_obciazenia);
        String obciazenieText = iloscObciazenia.getText().toString();
        if(obciazenieText.length() != 0){
            obciazenie = Integer.parseInt(obciazenieText);
        }
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Dane.tworzDane().add(new Dane(rodzajCwiczenia, iloscSeriiText ,powtorzenia, obciazenie, date));

        if(powtorzenia == 0 && obciazenie == 0){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return;
        }else {


            DaneDbAdapter daneDbAdapter = new DaneDbAdapter(this);
            daneDbAdapter.open();

            //
            ContentValues newValues2 = new ContentValues();
            newValues2.put(DaneDbAdapter.CWICZENIE, rodzajCwiczenia);
            newValues2.put(DaneDbAdapter.SERIA, iloscSeriiText);
            newValues2.put(DaneDbAdapter.POWTORZENIA, powtorzenia);
            newValues2.put(DaneDbAdapter.OBCIAZENIE, obciazenie);
            newValues2.put(DaneDbAdapter.DATA, date);
            daneDbAdapter.insertDane(newValues2);


            Toast.makeText(getApplicationContext(), "dane zapisane: ", Toast.LENGTH_SHORT).show();
            daneDbAdapter.close();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

}
