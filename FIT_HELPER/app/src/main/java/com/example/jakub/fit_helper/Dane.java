package com.example.jakub.fit_helper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Jakub on 26.05.2016.
 */
public class Dane {

    int mId;
    String mCwiczenie;
    String mSeria;
    int mObciazenie;
    int mPowtorzenia;
    String mData;


    public Dane(){

    }

    public Dane(String cwiczenie, String seria, int obciazenie, int powtorzenia, String data){
        this.mCwiczenie = cwiczenie;
        this.mSeria = seria;
        this.mObciazenie = obciazenie;
        this.mPowtorzenia = powtorzenia;
        this.mData = data;
    }

    public static ArrayList<Dane>tworzDane(){
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        ArrayList<Dane> wszystkieDane = new ArrayList<>();
        return wszystkieDane;
    }
}
