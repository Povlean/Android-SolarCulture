package com.example.bigjobapplication;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bigjobapplication.bean.LoginRequest;
import com.example.bigjobapplication.bean.RegisterRequest;
import com.example.bigjobapplication.constants.Constant;
import com.example.bigjobapplication.utils.ConvertType;
import com.example.bigjobapplication.utils.MD5Utils;

import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity {

    private TextView toLogin;
    private Button register;
    private EditText et_username,et_password,et_check;
    private String userName,password,checkPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_username = findViewById(R.id.re_username);
        et_password = findViewById(R.id.re_password);
        et_check = findViewById(R.id.re_check);

        toLogin = findViewById(R.id.to_login);
        toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toLoginActivity();
            }
        });

        register = findViewById(R.id.re_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getEditString();
                if(TextUtils.isEmpty(userName)){
                    Toast.makeText(RegisterActivity.this, "请输入您的昵称", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(RegisterActivity.this, "请输入您的密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(checkPassword)){
                    Toast.makeText(RegisterActivity.this, "请确认您的密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!password.equals(checkPassword)){
                    Toast.makeText(RegisterActivity.this, "两次密码不一致", Toast.LENGTH_SHORT).show();
                    return;
                }

                String md5Pas = MD5Utils.md5(password);
                RegisterRequest registerRequest = new RegisterRequest(userName,md5Pas,md5Pas);
                registerToBackend(registerRequest,md5Pas);

                Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                // 保存注册成功的账号和密码
                saveRegisterInfo(userName,md5Pas);
                Intent data = new Intent();
                data.putExtra("userName", userName);
                setResult(RESULT_OK, data);
                //跳转到登录界面中
                toLoginActivity();
                RegisterActivity.this.finish();


            }
        });

    }

    private String readPsw(String userName) {
        SharedPreferences sp  = getSharedPreferences("loginInfo", MODE_PRIVATE);
        return sp.getString(userName , "");
    }

    private boolean flag = true;
    public void registerToBackend(RegisterRequest registerRequest, String md5Pas) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    String json = ConvertType.beanToJson(registerRequest);
                    // 创建一个user对象
                    // 创建HTTP客户端
                    OkHttpClient client = new OkHttpClient()
                            .newBuilder()
                            .connectTimeout(60000, TimeUnit.MILLISECONDS)
                            .readTimeout(60000, TimeUnit.MILLISECONDS)
                            .build();
                    // 创建HTTP请求
                    Request request = new Request.Builder()
                            .url("http://"+ Constant.IP_ADDRESS +"/user/register")
                            .post(RequestBody.create(MediaType.parse("application/json"),json))
                            .build();
                    // 执行发送的指令
                    Response response = client.newCall(request).execute();

                    String data = response.body().string();
                    Integer intData = Integer.valueOf(data);
                    Log.d(TAG, "run: " + intData);
                    if (intData < 0) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(intData == -1) {
                                    Toast.makeText(RegisterActivity.this,"用户名或密码格式有误",Toast.LENGTH_SHORT).show();
                                    return;
                                }
                                if(intData == -2) {
                                    Toast.makeText(RegisterActivity.this,"用户名重复，请修改",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                    if(intData > 0) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                                // 保存注册成功的账号和密码
                                saveRegisterInfo(userName,md5Pas);
                                Intent data = new Intent();
                                data.putExtra("userName", userName);
                                setResult(RESULT_OK, data);
                                //跳转到登录界面中
                                toLoginActivity();
                                RegisterActivity.this.finish();
                            }
                        });
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(RegisterActivity.this,"网络问题，注册失败",Toast.LENGTH_SHORT).show();
                            return;
                        }
                    });
                }
            }
        }).start();
    }

    private void saveRegisterInfo(String userName, String md5Psw) {
        SharedPreferences sp = getSharedPreferences("loginInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(userName, md5Psw);
        editor.commit();
    }

    private void getEditString(){
        userName = et_username.getText().toString().trim();
        password = et_password.getText().toString().trim();
        checkPassword = et_check.getText().toString().trim();
    }

    private void toLoginActivity(){
        Intent intent = new Intent();
        intent.setClass(RegisterActivity.this,LoginActivity.class);
        startActivity(intent);
    }

}