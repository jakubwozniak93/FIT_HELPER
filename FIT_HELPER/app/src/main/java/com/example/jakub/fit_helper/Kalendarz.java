package com.example.jakub.fit_helper;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Kalendarz extends FragmentActivity {

    static TextView textData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalendarz);

        PickerDialogs pickerDialogs = new PickerDialogs();
        pickerDialogs.show(getSupportFragmentManager(), "date_picker");
        textData = (TextView) findViewById(R.id.wyswietlDate);
    }

    public void kalendarz_dane(View view){
        String data2 = textData.getText().toString();
        Intent intent = new Intent(this, Kalendarz_Dane.class);
        intent.putExtra("data", data2);
        startActivity(intent);
    }


    public static class PickerDialogs extends DialogFragment {

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            DateSettings dateSettings = new DateSettings(getActivity());
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog;
            dialog = new DatePickerDialog(getActivity(),dateSettings,year,month,day);

            return dialog;
        }
    }

    public static class DateSettings implements DatePickerDialog.OnDateSetListener {
        Context context;

        public DateSettings(Context context) {
            this.context = context;
        }

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            monthOfYear+=1;
            Toast.makeText(context, "Selected date: " + dayOfMonth + " / " + monthOfYear + " / " + year, Toast.LENGTH_LONG).show();
            if((monthOfYear<10 && dayOfMonth<10) || monthOfYear<10 || dayOfMonth<10 ){
                String data1 = Integer.toString(year) + "-0" + Integer.toString(monthOfYear) + "-0" + Integer.toString(dayOfMonth);
                String data = data1.toString();
                textData.setText(data);
            }else {
                String data1 = Integer.toString(year) + "-" + Integer.toString(monthOfYear) + "-" + Integer.toString(dayOfMonth);
                String data = data1.toString();
                textData.setText(data);
            }
        }
    }

    public void popraw(View view){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    public void onResume(){
        super.onResume();
    }
}
