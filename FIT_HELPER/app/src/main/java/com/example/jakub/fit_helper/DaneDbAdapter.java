package com.example.jakub.fit_helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Jakub on 26.05.2016.
 */
public class DaneDbAdapter {
    private static final String DATEBASE_NAME = "BAZA_CWICZEN.db";
    private static final String DANE_TABLE = "DANE_TABLE";
    private static final int DATEBASE_VERSION = 213;
    private final Context mCtx;
    public static String TAG = DaneDbAdapter.class.getSimpleName();


    private DatabaseHelper mDbHelper;
    SQLiteDatabase mDb;

    public static final String KEY_ROWID = "_id";
    public static final String CWICZENIE = "cwiczenie";
    public static final String SERIA = "seria";
    public static final String POWTORZENIA = "powtorzenia";
    public static final String OBCIAZENIE = "obciazenie";
    public static final String DATA = "data";

    public static final String[] DANE_FIELDS = new String[]{
            KEY_ROWID,
            CWICZENIE,
            SERIA,
            POWTORZENIA,
            OBCIAZENIE,
            DATA
    };

    private static final String CREATE_TABLE_DANE = " CREATE TABLE "+ DANE_TABLE + " ( "+ KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+ CWICZENIE + " TEXT, " + SERIA + " TEXT, " + POWTORZENIA + " INTEGER, " + OBCIAZENIE + " INTEGER, "+ DATA + " TEXT " + " ); ";

    private static class DatabaseHelper extends SQLiteOpenHelper{

        public DatabaseHelper(Context context) {
            super(context, DATEBASE_NAME, null, DATEBASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE_DANE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, " Aktualizacja bazy danych z wersji: "+ oldVersion + " na wersję: " + newVersion + " co spowoduje usuniecie wszystkich danych z bazy ");
            db.execSQL(" DROP TABLE IF EXISTS " + DANE_TABLE);
            onCreate(db);
        }
    }

    public DaneDbAdapter(Context mCtx) {
        this.mCtx = mCtx;
    }

    public DaneDbAdapter open() throws SQLException {
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }
    public void close(){
        if(mDbHelper!=null){
            mDbHelper.close();
        }
    }
    public void upgrade() throws SQLException{
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        mDbHelper.onUpgrade(mDb, 1, 0);
    }

    public long insertDane(ContentValues initialValues){
        return mDb.insertWithOnConflict(DANE_TABLE, null,
                initialValues, SQLiteDatabase.CONFLICT_IGNORE);
    }

    public boolean updateDane(int id, ContentValues newValues){
        String[] selectionArgs = {String.valueOf(id)};
        return mDb.update(DANE_TABLE, newValues, KEY_ROWID + " =? ", selectionArgs) > 0;
    }

    public boolean deleteDane(int id){
        String[] selectionArgs = {String.valueOf(id)};
        return mDb.delete(DANE_TABLE, KEY_ROWID + " =? ", selectionArgs) > 0;
    }

    public Cursor getDane(){
        return mDb.query(DANE_TABLE, DANE_FIELDS, null, null, null, null, null);
    }

    public static Dane getDaneFromCursor(Cursor cursor){
        Dane dane = new Dane();
        dane.mId = cursor.getInt(cursor.getColumnIndex(KEY_ROWID));
        dane.mCwiczenie = cursor.getString(cursor.getColumnIndex(CWICZENIE));
        dane.mSeria = cursor.getString(cursor.getColumnIndex(SERIA));
        dane.mPowtorzenia = cursor.getInt(cursor.getColumnIndex(POWTORZENIA));
        dane.mObciazenie = cursor.getInt(cursor.getColumnIndex(OBCIAZENIE));
        dane.mData = cursor.getString(cursor.getColumnIndex(DATA));
        return dane;

    }

    public Cursor szukajPoDacie(String inputText) throws SQLException {

        String query = "SELECT *"
                +  " FROM " + DANE_TABLE +
                " WHERE " + DATA + " = '" + inputText+"'"  ;

        Log.d("DBAdapter","Szukanie po dacie " + query.toString());

        Cursor mCursor = mDb.rawQuery(query,null);
        List<String[]> list = new ArrayList<String[]>();


        if (mCursor != null) {
            mCursor.moveToFirst();
        }

        Log.d("DBAdapter","przez Cursor");
        return mCursor;

    }


}
