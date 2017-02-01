package com.ahmetmatematikci.veritabani;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends SQLiteOpenHelper {

    private static final String DB_NAME = "kullanici.db";
    private static final int DB_VERSION= 1;
    private static final String SINIC_CREATE =
            "CREATE TABLE sinif (" + "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "isim TEXT NOT NULL" + ")";

    private static final String SINIF_DROP = "DROP TABLE IF EXISTS sinif";


    public MainActivity(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SINIC_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SINIF_DROP);
        onCreate(sqLiteDatabase);

    }
}
