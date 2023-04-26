package com.example.bigjobapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FindPasActivity extends AppCompatActivity {

    private ImageView ivBack01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_pas);

        ivBack01 = findViewById(R.id.iv_back01);
        ivBack01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindPasActivity.this,LoginActivity.class);
                startActivity(intent);
                FindPasActivity.this.finish();
            }
        });

    }
}