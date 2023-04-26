package com.example.bigjobapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "demo";
    private LinearLayout llHome,llFind,llMine;
    private ImageView ivHome,ivFind,ivMine;
    private TextView tvHome,tvFind,tvMine;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initEvent();
    }

    private void initEvent() {
        // 添加fragment
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        NavFragment02 navFragment02 = NavFragment02.newInstance("这是首页","");
        fragmentTransaction.replace(R.id.fcv_fragment, navFragment02).commit();
        tvHome.setTextColor(Color.BLUE);

        llHome.setOnClickListener(this);
        llFind.setOnClickListener(this);
        llMine.setOnClickListener(this);
    }

    private void initView() {
        llHome = findViewById(R.id.ll_home);
        llFind = findViewById(R.id.ll_find);
        llMine = findViewById(R.id.ll_mine);

        ivHome = findViewById(R.id.iv_home);
        ivFind = findViewById(R.id.iv_find);
        ivMine = findViewById(R.id.iv_mine);

        tvHome = findViewById(R.id.tv_home);
        tvFind = findViewById(R.id.tv_find);
        tvMine = findViewById(R.id.tv_mine);

    }

    // 重置点击状态
    private void resetBottomState() {
        tvHome.setTextColor(Color.BLACK);
        tvFind.setTextColor(Color.BLACK);
        tvMine.setTextColor(Color.BLACK);
    }

    @Override
    public void onClick(View view) {
        resetBottomState();
        switch (view.getId()){
            case R.id.ll_home:
                fragmentTransaction();
                NavFragment02 navFragment02 = NavFragment02.newInstance("这是首页","");
                fragmentTransaction.replace(R.id.fcv_fragment,navFragment02).commit();
                tvHome.setTextColor(Color.BLUE);
                break;
            case R.id.ll_find:
                fragmentTransaction();
                NavFragment01 navFragment01 = NavFragment01.newInstance("这是发现","");
                fragmentTransaction.replace(R.id.fcv_fragment,navFragment01).commit();
                tvFind.setTextColor(Color.BLUE);
                break;
            case R.id.ll_mine:
                fragmentTransaction();
                String username = getUsername();
                NavFragment03 navFragment03 = NavFragment03.newInstance(username,"");
                fragmentTransaction.replace(R.id.fcv_fragment,navFragment03).commit();
                tvMine.setTextColor(Color.BLUE);
                break;
            default:
                break;
        }
    }

    public void fragmentTransaction() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
    }

    public String getUsername() {
        SharedPreferences pref = getSharedPreferences("loginInfo", MODE_PRIVATE);
        username = pref.getString("loginUserName","");
        return username;
    }

}