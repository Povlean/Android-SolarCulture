package com.example.bigjobapplication;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bigjobapplication.bean.SolarItem;
import com.example.bigjobapplication.season.AutumnActivity;
import com.example.bigjobapplication.season.SpringActivity;
import com.example.bigjobapplication.season.SummerActivity;
import com.example.bigjobapplication.season.WinterActivity;

import java.util.List;

public class SolarItemsAdapter extends RecyclerView.Adapter<SolarItemsAdapter.ViewHolderR> {

    private List<SolarItem> mSolarList;
    public static final String TAG = "season";
    private Intent intent;

    public SolarItemsAdapter(List<SolarItem> mSolarList) {
        this.mSolarList = mSolarList;
    }

    @NonNull
    @Override
    public ViewHolderR onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.solar_item,parent,false);
        ViewHolderR holderR = new ViewHolderR(view);

        /*添加点击事件*/
        holderR.solarView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int position = holderR.getAdapterPosition();
                SolarItem solarItem = mSolarList.get(position);
                Toast.makeText(view.getContext(),"欢迎来到"+ solarItem.getSolarName() + "季",Toast.LENGTH_SHORT).show();
                switch (solarItem.getSolarName()){
                    case "春":
                        Log.d(TAG, "onClick: " + view.getContext());
                        intent = new Intent(view.getContext(), SpringActivity.class);
                        view.getContext().startActivity(intent);
                        break;
                    case "夏":
                        intent = new Intent(view.getContext(), SummerActivity.class);
                        view.getContext().startActivity(intent);
                        break;
                    case "秋":
                        intent = new Intent(view.getContext(), AutumnActivity.class);
                        view.getContext().startActivity(intent);
                        break;
                    case "冬":
                        intent = new Intent(view.getContext(), WinterActivity.class);
                        view.getContext().startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });

        return holderR;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderR holder, int position) {
        SolarItem solarItem = mSolarList.get(position);
        holder.solarImage.setImageResource(solarItem.getSolarImg());
        holder.solarName.setText(solarItem.getSolarName());
        holder.solarDesc.setText(solarItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return mSolarList.size();
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
