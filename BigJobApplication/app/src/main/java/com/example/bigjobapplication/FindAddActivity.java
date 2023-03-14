package com.example.bigjobapplication;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bigjobapplication.bean.Solar;
import com.example.bigjobapplication.bean.SolarItem;
import com.example.bigjobapplication.utils.ConvertType;

import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FindAddActivity extends AppCompatActivity {

    private EditText etTitle,etDesc;
    private Button new_ok;
    private String title,content;
    private SolarItem solarItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_add);

        etTitle = findViewById(R.id.edit_title);
        etDesc = findViewById(R.id.edit_content);
        new_ok = findViewById(R.id.new_OK);

        new_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title = etTitle.getText().toString();
                content = etDesc.getText().toString();
                if (!TextUtils.isEmpty(content)){
                    solarItem = new SolarItem();
                    solarItem.setSolarName(title);
                    solarItem.setDescription(content);
                    insertData(solarItem);
                }else{
                    Toast.makeText(FindAddActivity.this,"内容为空，添加失败",Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });

    }

    public void insertData(SolarItem solarItem) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    String json = ConvertType.beanToJson(solarItem);
                    // 创建一个user对象
                    // 创建HTTP客户端
                    OkHttpClient client = new OkHttpClient()
                            .newBuilder()
                            .connectTimeout(60000, TimeUnit.MILLISECONDS)
                            .readTimeout(60000, TimeUnit.MILLISECONDS)
                            .build();
                    // 创建HTTP请求
                    Request request = new Request.Builder()
                            .url("http://192.168.31.88:8080/solaritem/add")
                            .post(RequestBody.create(MediaType.parse("application/json"),json))
                            .build();
                    // 执行发送的指令
                    Response response = client.newCall(request).execute();
                    Log.d(TAG, "run: " + response.body().toString());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(FindAddActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
                        }
                    });
                }catch (Exception e){
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(FindAddActivity.this,"网络问题，注册失败",Toast.LENGTH_SHORT).show();
                            return;
                        }
                    });
                }
            }
        }).start();
    }

}