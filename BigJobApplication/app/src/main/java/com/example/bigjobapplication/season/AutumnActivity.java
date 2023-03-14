package com.example.bigjobapplication.season;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.bigjobapplication.MainActivity;
import com.example.bigjobapplication.R;
import com.example.bigjobapplication.SeasonSolarAdapter;
import com.example.bigjobapplication.bean.SeasonSolar;

import java.util.ArrayList;
import java.util.List;

public class AutumnActivity extends AppCompatActivity {

    private ImageView ivBack;
    private List<SeasonSolar> seasonSolarList = new ArrayList<>();

    private String liqiuDesc = "“立”，是开始之意；“秋”，意为禾谷成熟。整个自然界的变化是循序渐进的过程，立秋是阳气渐收、阴气渐长，由阳盛逐渐转变为阴盛的转折。" ;

    private String bailuDesc = "白露基本结束了暑天的闷热，天气渐渐转凉，寒生露凝。古人以四时配五行，秋属金，金色白，以白形容秋露，故名“白露”。";

    private String shuangjiangDesc = "由于“霜”是天冷、昼夜温差变化大的表现，故以“霜降”命名这个表示“气温骤降、昼夜温差大”的节气。";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autumn);

        ivBack = findViewById(R.id.iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.iv_back:
                        Intent intent = new Intent(AutumnActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });

        initAutumnSolar();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        SeasonSolarAdapter seasonSolarAdapter = new SeasonSolarAdapter(seasonSolarList);
        recyclerView.setAdapter(seasonSolarAdapter);
    }

    // 立秋，处暑，白露，秋分，寒露，霜降。
    private void initAutumnSolar() {
        SeasonSolar liqiu = new SeasonSolar("立秋",R.drawable.liqiu,liqiuDesc);
        seasonSolarList.add(liqiu);

        SeasonSolar bailu = new SeasonSolar("白露",R.drawable.bailu01,bailuDesc);
        seasonSolarList.add(bailu);

        SeasonSolar shuangjiang = new SeasonSolar("霜降",R.drawable.shuangjiang,shuangjiangDesc);
        seasonSolarList.add(shuangjiang);
    }

}