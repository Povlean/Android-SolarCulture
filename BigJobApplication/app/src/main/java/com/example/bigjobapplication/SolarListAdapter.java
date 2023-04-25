package com.example.bigjobapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bigjobapplication.bean.SolarItem;

import java.util.List;

public class SolarListAdapter extends ArrayAdapter<SolarItem> {

    private final int resourceId;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        SolarItem solar = getItem(position);
        /*为子项加载传入的布局*/
        View view;
        ViewHolder viewHolder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.solarImg = view.findViewById(R.id.solar_img);
            viewHolder.solarName = view.findViewById(R.id.solar_name);
            view.setTag(viewHolder);
        } else{
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.solarImg.setImageResource(solar.getSolarImg());
        viewHolder.solarName.setText(solar.getSolarName());
        return view;
    }

    public SolarListAdapter(@NonNull Context context, int resource, @NonNull List<SolarItem> objects) {
        super(context, resource, objects);
        this.resourceId = resource;
    }
    class ViewHolder{
        ImageView solarImg;
        TextView solarName;
    }
}
