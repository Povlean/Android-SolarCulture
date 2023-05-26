package com.example.bigjobapplication.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    public static final String TAG = "MySQLiteOpenHelper";

    public MySQLiteOpenHelper(@Nullable Context context) {
        super(context, Constant.DATABASE_NAME, null, Constant.VERSION_CODE);
    }

    // 在第一次创建数据库的时候被调用
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate() 方法被执行，创建数据库");
        String sql = "create table "+ Constant.TABLE_NAME + "(id Integer,solar_name varchar,date varchar,description varchar,url varchar,food varchar);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
