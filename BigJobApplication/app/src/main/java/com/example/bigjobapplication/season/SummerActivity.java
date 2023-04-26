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

public class SummerActivity extends AppCompatActivity {

    private ImageView ivBack;
    private List<SeasonSolar> seasonSolarList = new ArrayList<>();

    private String lixiaDesc = "斗指东南，维为立夏，万物至此皆长大，故名立夏也。" ;

    private String xiaomanDesc = "民谚云“小满小满，江河渐满”。小满中的“满”，指雨水之盈。";

    private String xiazhiDesc = "古时也是民间“四时八节”中的一个节日，自古民间有在夏至拜神祭祖的习俗。";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summer);

        ivBack = findViewById(R.id.iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.iv_back:
                        Intent intent = new Intent(SummerActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });

        initSummerSolar();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        SeasonSolarAdapter seasonSolarAdapter = new SeasonSolarAdapter(seasonSolarList);
        recyclerView.setAdapter(seasonSolarAdapter);
    }


    public void initSummerSolar() {
        SeasonSolar lixia = new SeasonSolar("立夏",R.drawable.lixia,lixiaDesc);
        seasonSolarList.add(lixia);

        SeasonSolar xiaoman = new SeasonSolar("小满",R.drawable.xiaoman,xiaomanDesc);
        seasonSolarList.add(xiaoman);

        SeasonSolar xiazhi = new SeasonSolar("夏至",R.drawable.xiazhi,xiazhiDesc);
        seasonSolarList.add(xiazhi);
    }

}