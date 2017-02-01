package com.ahmetmatematikci.veritabani;

import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

/**
 * Created by a on 2/1/17.
 */

public class VeriTabani extends ListActivity {

    private SQLiteDatabase mVeritabani;
    private MainActivity mHelper;
    private  static final String sinif_select ="Select _id, isim from sinif";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_veritabani);
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
        veriYukle();



    }

    private void veriYukle() {
        Cursor sinifCursor = mVeritabani.rawQuery(sinif_select, null);
        startManagingCursor(sinifCursor);

        SimpleCursorAdapter sinifAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_expandable_list_item_1,
                sinifCursor, new String[] {"isim"}, new int[]{android.R.id.text1});
        setListAdapter(sinifAdapter);
    }

    public void onButtonClick(View view) {
        EditText et = (EditText)findViewById(R.id.ed_veritabanina_yaz);
        ContentValues deger = new ContentValues();
        deger.put("isim", et.getText().toString());
        mVeritabani.insert("sinif", null,deger);
        veriYukle();
    }
}
