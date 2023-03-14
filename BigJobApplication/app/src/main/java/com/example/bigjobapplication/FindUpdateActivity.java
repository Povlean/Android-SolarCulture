package com.example.bigjobapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bigjobapplication.bean.SolarItem;
import com.example.bigjobapplication.utils.ConvertType;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FindUpdateActivity extends AppCompatActivity {

    private Button btnSave,btnExit;
    private EditText etTitle,etContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_update);

        btnSave = findViewById(R.id.btn_save);
        btnExit = findViewById(R.id.btn_exit);
        etTitle = findViewById(R.id.edit_title);
        etContent = findViewById(R.id.edit_content);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("findInfo");

        String solarname = bundle.getString("solarname");
        Integer solarImg = bundle.getInt("solarImg");
        String description = bundle.getString("description");

        etTitle.setText(solarname);
        etContent.setText(description);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strTitle = etTitle.getText().toString();
                String strContent = etContent.getText().toString();

                SolarItem solarItem = new SolarItem(strTitle,strContent);
                updateFinditem(solarItem);
            }
        });

    }

    public void updateFinditem(SolarItem solarItem) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String json = ConvertType.beanToJson(solarItem);
                    OkHttpClient client = new OkHttpClient();

                    Request request = new Request.Builder()
                            .url("http://192.168.31.88:8080/solaritem/update")
                            .post(RequestBody.create(MediaType.parse("application/json"),json))
                            .build();

                    Response response = client.newCall(request).execute();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(FindUpdateActivity.this,"更新成功",Toast.LENGTH_SHORT).show();
                        }
                    });
                }catch (Exception e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(FindUpdateActivity.this,"网络连接失败",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        }).start();
    }
}