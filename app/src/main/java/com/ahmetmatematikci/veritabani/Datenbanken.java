package com.ahmetmatematikci.veritabani;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by a on 2/1/17.
 */

public class Datenbanken extends Activity {

    private SQLiteDatabase mVeritabani;
    private MainActivity mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHelper = new MainActivity(this);


    }

    @Override
    protected void onPause() {
        mVeritabani.close();
        Toast.makeText(this, "Veri Tabanı Kapandı", Toast.LENGTH_SHORT).show();
        super.onPause();
    }


    @Override
    protected void onResume() {
        super.onResume();
        mVeritabani = mHelper.getReadableDatabase();
        Toast.makeText(this, "Veri Tabanı Açıldı", Toast.LENGTH_SHORT).show();

    }
}
