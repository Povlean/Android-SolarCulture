package com.example.bigjobapplication.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class SolarDao {

    private final MySQLiteOpenHelper mhelper;
    public static final String TAG = "SolarDao";

    public SolarDao(Context context) {
        mhelper = new MySQLiteOpenHelper(context);
    }

    public void insert() {
        SQLiteDatabase db = mhelper.getWritableDatabase();
//        String sql = "insert into "+ Constant.TABLE_NAME +"(id,solar_name,date,description,url,food) values(?,?,?,?,?,?)";
//        db.execSQL(sql,new Object[]{1,"立春","公历2月3－5日交节","立春是干支历寅月的起始","1","萝卜、姜、葱、面饼"});

        ContentValues values = new ContentValues();

        values.put("id",2);
        values.put("solar_name","立夏");
        values.put("date","公历5月05－07日交节");
        values.put("description","立夏是干支历巳月的起始");
        values.put("url","2");
        values.put("food","立夏蛋");

        db.insert(Constant.TABLE_NAME,null,values);
        db.close();
    }

    public void delete() {
        SQLiteDatabase db = mhelper.getWritableDatabase();
        String sql = "delete from "+ Constant.TABLE_NAME + " where id = 1";
        db.execSQL(sql);
        db.close();
    }

    public void update() {
        SQLiteDatabase db = mhelper.getWritableDatabase();
//        String sql = "update "+Constant.TABLE_NAME +" set solar_name = '立夏' where id = 1";
//        db.execSQL(sql);

        ContentValues values = new ContentValues();
        values.put("solar_name","立春");

        db.update(Constant.TABLE_NAME,values,"id = 1",null);
        db.close();
    }

    public void query() {
        SQLiteDatabase db = mhelper.getWritableDatabase();
        String sql = "select * from "+ Constant.TABLE_NAME;
        Cursor cursor = db.rawQuery(sql,null);

        while(cursor.moveToNext()){
            int index = cursor.getColumnIndex("solar_name");
            String solarName = cursor.getString(index);
            Log.d(TAG, "solar_name == "+ solarName);
        }
        cursor.close();
        db.close();
    }

}
