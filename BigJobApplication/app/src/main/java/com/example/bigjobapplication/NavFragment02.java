package com.example.bigjobapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.bigjobapplication.bean.Solar;
import com.example.bigjobapplication.bean.SolarItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NavFragment02#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NavFragment02 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_PARAM1 = "param1";
    public static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private TextView tvContent;

    private List<SolarItem> solarItemList = new ArrayList<>();

    public NavFragment02() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NavFragment01.
     */
    // TODO: Rename and change types and number of parameters
    public static NavFragment02 newInstance(String param1, String param2) {
        NavFragment02 fragment = new NavFragment02();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nav02, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initSolarItems();
        RecyclerView recyclerView = getActivity().findViewById(R.id.recycler_view);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        SolarItemsAdapter solarItemsAdapter = new SolarItemsAdapter(solarItemList);
        recyclerView.setAdapter(solarItemsAdapter);
    }

    private void initSolarItems() {
        SolarItem spring = new SolarItem("春",R.drawable.spring,"阳春布德泽，万物生光辉");
        solarItemList.add(spring);
        SolarItem summer = new SolarItem("夏",R.drawable.summer,"接天莲叶无穷碧，映日荷花别样红");
        solarItemList.add(summer);
        SolarItem autumn = new SolarItem("秋",R.drawable.autumn,"停车坐爱枫林晚，霜叶红于二月花");
        solarItemList.add(autumn);
        SolarItem winter = new SolarItem("冬",R.drawable.winter,"柴门闻犬吠，风雪夜归人");
        solarItemList.add(winter);
    }
}