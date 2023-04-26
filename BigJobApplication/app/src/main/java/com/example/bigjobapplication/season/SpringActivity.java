package com.example.bigjobapplication.season;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.bigjobapplication.MainActivity;
import com.example.bigjobapplication.R;
import com.example.bigjobapplication.SeasonSolarAdapter;
import com.example.bigjobapplication.bean.SeasonSolar;

import java.util.ArrayList;
import java.util.List;

public class SpringActivity extends AppCompatActivity {

    private ImageView ivBack;
    private List<SeasonSolar> seasonSolarList = new ArrayList<>();

    private String lichunDesc = "立春，为廿四节气之首，又名正月节、岁节、改岁、岁旦等。立，" +
            "是“开始”之意；春，代表着温暖、生长。" ;

    private String yushuiDesc = "雨水，是二十四节气之一，一岁四时，春夏秋冬各三个月，每月两个节气，" +
            "每个节气均有其独特的含义。雨水节气的涵义是降雨开始，雨量渐增。";

    private String jingzheDesc = "惊蛰，又名“启蛰”，是二十四节气中的第三个节气。斗指丁，太阳到达黄经" +
            "345°，于公历3月5-6日交节。惊蛰反映的是自然生物受节律变化影响而出现萌发生长的现象。";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spring);

        ivBack = findViewById(R.id.iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.iv_back:
                        Intent intent = new Intent(SpringActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });

        initSpringSolar();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        SeasonSolarAdapter seasonSolarAdapter = new SeasonSolarAdapter(seasonSolarList);
        recyclerView.setAdapter(seasonSolarAdapter);

    }

    // 立春、雨水、惊蛰、春分、清明、谷雨

    public void initSpringSolar() {
        SeasonSolar lichun = new SeasonSolar("立春",R.drawable.lichun01,lichunDesc);
        seasonSolarList.add(lichun);

        SeasonSolar yushui = new SeasonSolar("雨水",R.drawable.yushui,yushuiDesc);
        seasonSolarList.add(yushui);

        SeasonSolar jingzhe = new SeasonSolar("惊蛰",R.drawable.jingzhe01,jingzheDesc);
        seasonSolarList.add(jingzhe);

    }
}