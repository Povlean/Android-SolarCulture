package com.example.bigjobapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FindItemActivity extends AppCompatActivity {

    private TextView txtTitle,txtDesc;
    private ImageView ivSolar;
    private Button btnBack,btnUpdate;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_item);

        btnBack = findViewById(R.id.btn_back);
        btnUpdate = findViewById(R.id.btn_update);

        intent = getIntent();
        Bundle bundle = intent.getBundleExtra("findInfo");

        txtTitle = findViewById(R.id.txt_title);
        txtTitle.setText(bundle.getString("solarname"));

        ivSolar = findViewById(R.id.iv_solarimg);
        ivSolar.setImageResource(bundle.getInt("solarImg"));

        txtDesc = findViewById(R.id.txt_desc);
        txtDesc.setText(bundle.getString("description"));

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(FindItemActivity.this,NavFragment01.class);
                startActivity(intent);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(FindItemActivity.this,FindUpdateActivity.class);
                intent.putExtra("findInfo",bundle);
                startActivity(intent);
            }
        });

    }
}