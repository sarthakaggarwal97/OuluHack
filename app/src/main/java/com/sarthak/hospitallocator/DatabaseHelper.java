package com.sarthak.hospitallocator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME  = "appointment.db";
    public static final String TABLE_NAME  = "appointment_table";
    public static final String COL_ONE  = "PLACE";
    public static final String COL_TWO = "DATE";
    public static final String COL_THREE  = "TIME";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
             sqLiteDatabase.execSQL("create table " + TABLE_NAME+ " (PLACE TEXT, DATE TEXT, TIME TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

            sqLiteDatabase.execSQL("drop table if exists " + TABLE_NAME);
            onCreate(sqLiteDatabase);
    }

    public boolean insertData(String place, String date, String time){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ONE, place);
        contentValues.put(COL_TWO, date);
        contentValues.put(COL_THREE, time);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }

    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from "+ TABLE_NAME, null);
    }
}
