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

public class WinterActivity extends AppCompatActivity {

    private ImageView ivBack;
    private List<SeasonSolar> seasonSolarList = new ArrayList<>();

    private String lidongDesc = "立，建始也；冬，终也，万物收藏也。立冬，意味着生气开始闭蓄，万物进入休养、收藏状态。" ;

    private String dongzhiDesc = "冬至，又称日南至、冬节、亚岁等，兼具自然与人文两大内涵，既是二十四节气中一个重要的节气，也是中国民间的传统祭祖节日。";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winter);

        ivBack = findViewById(R.id.iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.iv_back:
                        Intent intent = new Intent(WinterActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });

        initWinterSolar();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        SeasonSolarAdapter seasonSolarAdapter = new SeasonSolarAdapter(seasonSolarList);
        recyclerView.setAdapter(seasonSolarAdapter);
    }

    // 立冬、小雪、大雪、冬至、小寒、大寒
    private void initWinterSolar() {
        SeasonSolar lidong = new SeasonSolar("立夏",R.drawable.lidong,lidongDesc);
        seasonSolarList.add(lidong);

        SeasonSolar dongzhi = new SeasonSolar("冬至",R.drawable.dongzhi,dongzhiDesc);
        seasonSolarList.add(dongzhi);
    }


}