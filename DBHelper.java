package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.LinkedList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final String MY_TABLE = "MY_TABLE";
    private static final String COLUMN_NAME = "COLUMN_NAME";
    private static final String COLUMN_PROG = "COLUMN_PROG";

    public DBHelper(@Nullable Context context) {
        super(context, "wish.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + MY_TABLE + " (" + COLUMN_NAME + " TEXT, " + COLUMN_PROG + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void DelAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(MY_TABLE,null,null);
        db.close();
    }

    public void AddOne(Data data){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, data.name);
        cv.put(COLUMN_PROG, data.prog);

        db.insert(MY_TABLE,null, cv);
        db.close();
    }

    public LinkedList<Data> GetAll(){
        LinkedList<Data> list = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(MY_TABLE, null, null, null, null,null, null);

        if (cursor.moveToFirst())
            do{
                int id_n = cursor.getColumnIndex(COLUMN_NAME);
                int id_p = cursor.getColumnIndex(COLUMN_PROG);

                Data data = new Data(cursor.getString(id_n), cursor.getString(id_p));
                list.add(data);
            } while (cursor.moveToNext());

        db.close();
        return list;
    }
}
