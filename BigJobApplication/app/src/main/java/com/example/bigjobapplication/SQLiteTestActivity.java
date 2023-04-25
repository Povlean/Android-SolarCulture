package com.example.bigjobapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.bigjobapplication.utils.MySQLiteOpenHelper;

public class SQLiteTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_test);

        // 创建数据库
        MySQLiteOpenHelper helper = new MySQLiteOpenHelper(this);
        helper.getWritableDatabase();
    }
}