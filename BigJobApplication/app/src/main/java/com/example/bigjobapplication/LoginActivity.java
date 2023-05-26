package com.example.bigjobapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bigjobapplication.bean.LoginRequest;
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

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "Login";

    private Button login;
    private TextView tvRegister, tvFindPas;
    private EditText etUsername, etPwd;
    private String userName,password,spPsw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    private void init() {

        etUsername = findViewById(R.id.username);
        etPwd = findViewById(R.id.password);
        tvFindPas = findViewById(R.id.tv_find_pas);
        login = findViewById(R.id.loginBtn);
        tvRegister = findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getEditString();

                String md5Psw = MD5Utils.md5(password);
                spPsw = readPsw(userName);
                if(TextUtils.isEmpty(userName)){
                    Toast.makeText( LoginActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText( LoginActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(md5Psw.equals(spPsw)) {
                    //登录成功
                    //保存登录状态，在界面保存登录的用户名和密码
                    saveLoginStatus(true, userName);
                    Log.d(TAG, "onClick: " + spPsw);
                    //调用后端的登录接口
                    loginToBackend(userName,spPsw);
                    if(flag){
                        //跳转到下一个界面
                        startActivity(new Intent( LoginActivity.this, MainActivity.class));
                        return;
                        //如果用户名或者账号错误会提示错误
                    }
                } else if ((spPsw!=null&&!TextUtils.isEmpty(spPsw)&&!md5Psw.equals(spPsw))){
                    Toast.makeText( LoginActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Toast.makeText( LoginActivity.this, "此用户名不存在", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // 跳转到找回密码
        tvFindPas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,FindPasActivity.class);
                startActivity(intent);
                LoginActivity.this.finish();
            }
        });

        // 跳转到register页面。
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到注册界面
                Intent intent=new Intent( LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                LoginActivity.this.finish();
            }
        });
    }

    //保存登录状态
    private void saveLoginStatus(boolean status,String userName){
        SharedPreferences sp = getSharedPreferences("loginInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("isLogin", status);
        editor.putString("loginUserName", userName);
        editor.commit();
    }

    private String readPsw(String userName) {
        SharedPreferences sp  = getSharedPreferences("loginInfo", MODE_PRIVATE);
        return sp.getString(userName , "");
    }

    //获取用户名和密码
    private void getEditString(){
        userName = etUsername.getText().toString().trim();
        password = etPwd.getText().toString().trim();
    }

    // 前后端交互校验登录数据
    JSONObject jsonObject;
    boolean flag = true;
    public void loginToBackend(String loginName,String loginPas) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    LoginRequest loginRequest = new LoginRequest(loginName,loginPas);
                    String json = ConvertType.beanToJson(loginRequest);
                    // 创建一个user对象
                    // 创建HTTP客户端
                    OkHttpClient client = new OkHttpClient()
                            .newBuilder()
                            .connectTimeout(60000, TimeUnit.MILLISECONDS)
                            .readTimeout(60000, TimeUnit.MILLISECONDS)
                            .build();
                    // 创建HTTP请求
                    Request request = new Request.Builder()
                            .url("http://"+ Constant.IP_ADDRESS +"/user/login")
                            .post(RequestBody.create(MediaType.parse("application/json"),json))
                            .build();
                    // 执行发送的指令
                    Response response = client.newCall(request).execute();

                    String data = response.body().string();

                    if (data == null){
                        flag = false;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LoginActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        });
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText( LoginActivity.this, "欢迎" + userName + "用户", Toast.LENGTH_SHORT).show();
                        }
                    });
                }catch (Exception e){
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(LoginActivity.this,"网络或进程问题",Toast.LENGTH_SHORT).show();
                            return;
                        }
                    });
                }
            }
        }).start();
    }


}