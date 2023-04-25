package com.example.bigjobapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bigjobapplication.bean.SeasonSolar;

import java.util.List;

public class SeasonSolarAdapter extends RecyclerView.Adapter<SeasonSolarAdapter.ViewHolderR> {

    private List<SeasonSolar> mSeasonSolarList;
    public static final String TAG = "season";

    public SeasonSolarAdapter(List<SeasonSolar> mSeasonSolarList) {
        this.mSeasonSolarList = mSeasonSolarList;
    }

    @NonNull
    @Override
    public ViewHolderR onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.season_solar,parent,false);
        ViewHolderR holderR = new ViewHolderR(view);

        /*添加点击事件*/
        holderR.solarView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int position = holderR.getAdapterPosition();
                SeasonSolar seasonSolar = mSeasonSolarList.get(position);
                Toast.makeText(view.getContext(),"欢迎来到"+ seasonSolar.getSsName() + "节气",Toast.LENGTH_SHORT).show();
            }
        });

        return holderR;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderR holder, int position) {
        SeasonSolar seasonSolar = mSeasonSolarList.get(position);
        holder.solarImage.setImageResource(seasonSolar.getSsImg());
        holder.solarName.setText(seasonSolar.getSsName());
        holder.solarDesc.setText(seasonSolar.getSsDesc());
    }

    @Override
    public int getItemCount() {
        return mSeasonSolarList.size();
    }

    static class ViewHolderR extends RecyclerView.ViewHolder {
        // 为点击事件做准备
        View solarView;
        ImageView solarImage;
        TextView solarName;
        TextView solarDesc;

        public ViewHolderR(@NonNull View itemView) {
            super(itemView);
            solarView = itemView;
            solarImage = itemView.findViewById(R.id.solar_img);
            solarName = itemView.findViewById(R.id.solar_name);
            solarDesc = itemView.findViewById(R.id.solar_desc);
        }

    }

}
