package com.example.bigjobapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bigjobapplication.bean.SolarItem;
import com.example.bigjobapplication.constants.Constant;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NavFragment01#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NavFragment01 extends Fragment{

    private List<SolarItem> solarItemList = new ArrayList<>();
    private Intent intent;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_PARAM1 = "param1";
    public static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView tvContent;
    private Button btnSearch;

    public NavFragment01() {
        // Required empty public constructor
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
    public static NavFragment01 newInstance(String param1, String param2) {
        NavFragment01 fragment = new NavFragment01();
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

    private ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nav01, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private FloatingActionButton newFind;
    public static final String TAG = "method";
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        SolarListAdapter solarListAdapter = new SolarListAdapter(getActivity(), R.layout.findsolar_item,solarItemList);

        listView = getActivity().findViewById(R.id.list_view);
        listView.setAdapter(solarListAdapter);

        newFind = getActivity().findViewById(R.id.new_find);
        newFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(),FindAddActivity.class);
                startActivity(intent);
            }
        });

        initSolar();



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SolarItem solarItem =  solarItemList.get(i);
                String solarName = solarItem.getSolarName();

                Bundle bundle = new Bundle();
                bundle.putString("solarname",solarItem.getSolarName());
                bundle.putInt("solarImg",solarItem.getSolarImg());
                bundle.putString("description",solarItem.getDescription());

                intent = new Intent(getActivity(),FindItemActivity.class);
                intent.putExtra("findInfo",bundle);

                getActivity().startActivity(intent);
                Toast.makeText(getActivity(),solarName,Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                SolarItem solarItem =  solarItemList.get(i);
                String solarName = solarItem.getSolarName();

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("确认删除此项记录？");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        solarItemList.remove(i);
                        deleteItem(solarName);
                        initeNotes();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        return;
                    }
                });
                builder.create().show();
                return true;
            }
        });


    }

    private JSONArray jsonArray;
    public void dataCallBack() {
         new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();

                    Request request = new Request.Builder()
                            .url("http://" + Constant.IP_ADDRESS + "/solaritem/search")
                            .get()
                            .build();

                    Response response = client.newCall(request).execute();

                    String string = response.body().string();
                    jsonArray = new JSONArray(string);


                    Log.d(TAG, "return json: " + jsonArray);
                    for(int i = 0;i < jsonArray.length();i++) {
                        SolarItem solarItem = new SolarItem();
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        solarItem.setSolarImg(R.drawable.wulian);
                        solarItem.setSolarName(jsonObject.getString("solarname"));
                        solarItem.setDescription(jsonObject.getString("description"));
                        solarItemList.add(solarItem);
                    }

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getActivity(),"回显成功",Toast.LENGTH_SHORT).show();
                        }
                    });
                }catch (Exception e) {
                    e.printStackTrace();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getActivity(),"网络连接失败",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        }).start();
    }

    public void initSolar() {
        dataCallBack();
        try {
            Thread.sleep(1000);
            SolarItem item1 = new SolarItem("冬吃萝卜夏吃姜",R.drawable.luobu,"这条谚语多数人理解为冬天" +
                    "吃萝卜夏天吃姜，其实谚语采用了一个古代常用的修辞手法—互文，冬夏泛指一年四季，正确理解应为四季常吃萝卜和姜，不用医生开药方。");
            solarItemList.add(item1);
            SolarItem item2 = new SolarItem("咬春",R.drawable.yaochun,"立春这一日，中国民间讲究要买个萝卜来吃，叫做咬春。因为萝卜味辣，取古人“咬" +
                    "得草根断，则百事可做”之意。老北京人讲究时令吃食，立春这天要吃春饼，吃春饼就是咬春，也有叫吃春盘的，这一日从一大清早，就有人挑着担子在胡同里吆喝：萝卜赛梨。那时候，再穷的" +
                    "人家，也要买个萝卜给孩子咬咬春。");
            solarItemList.add(item2);
            SolarItem item3 = new SolarItem("冬至吃饺子",R.drawable.jiaozi,"冬至吃饺子 纪念医圣. 各地在冬至时有不同的风俗，北方地区有冬至宰羊、吃饺子、吃馄饨的习俗，南方地区在这一天则有吃" +
                    "冬至米团、冬至长线面的习惯，而苏北人在冬至时吃大葱炒豆腐。. 冬至吃饺子还有说是不忘\" 医圣 \" 张仲景 \" 祛寒娇耳汤 \"之恩。");
            solarItemList.add(item3);

            SolarItem item4 = new SolarItem("鞭春牛",R.drawable.bianchunniu,"立春日，民间还有“打春”习俗，又叫“鞭春牛”。春牛在塑制时，要在肚" +
                    "子里塞上五谷，当牛被打烂时，五谷就流了出来，拾起谷粒放回仓中，预示仓满粮足。");
            solarItemList.add(item4);
            SolarItem item5 = new SolarItem("接寿",R.drawable.jieshou,"在我国有些地区，雨水这一天女婿、女儿要去给岳父岳母送节。送" +
                    "礼的礼品通常是一丈二尺长的红棉带，这称为“接寿”，意思是希望岳父岳母“寿缘” 长，长命百岁。");
            solarItemList.add(item5);
            SolarItem item6 = new SolarItem("撞拜寄",R.drawable.zhuangbaiji,"雨水节，在川西民间是一个非常富有想象力和人情味的节气。这在川西民间" +
                    "称为“撞拜寄”，即事先没有预定的目标，撞着谁就是谁。");
            solarItemList.add(item6);

            SolarItem item7 = new SolarItem("祭白虎",R.drawable.jibaihu,"传说以前人们认为惊蛰这天，白虎会出来吃人，为保平安，便要在惊蛰日举行祭祀，" +
                    "求上天保佑，不要让白虎出来害人，还用猪肉去喂白虎，以求塞住虎口。");
            solarItemList.add(item7);
            SolarItem item8 = new SolarItem("打小人",R.drawable.daxiaoren,"一般在三叉路口、桥底、路旁、山边等阴暗的地方进行，相传这样的地方煞气大，" +
                    "较易招惹鬼神，克制小人。虽然打小人在平时也可以进行，但在惊蛰这天打小人，具有特别的寓意，据说效果也最好。");
            solarItemList.add(item8);
            SolarItem item9 = new SolarItem("竖鸡蛋",R.drawable.shujidan,"“春分到，蛋儿俏”，春分这一天最好玩的莫过于“竖鸡蛋”：选一个光滑匀称、" +
                    "没有冷藏或煮熟过的新鲜鸡蛋，轻手轻脚在桌上把大头朝下地竖起来。");
            solarItemList.add(item9);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void initeNotes() {
        solarItemList.clear();
        initSolar();
        SolarListAdapter noteAdapter = new SolarListAdapter(getActivity(), R.layout.findsolar_item,solarItemList);
        listView.setAdapter(noteAdapter);
    }

    public void deleteItem(String solarName) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();

                    Request request = new Request.Builder()
                            .url("http://192.168.31.88:8080/solaritem/delete/" + solarName)
                            .get()
                            .build();

                    Response response = client.newCall(request).execute();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getActivity(),"删除成功",Toast.LENGTH_SHORT).show();
                            initSolar();
                        }
                    });
                }catch (Exception e) {
                    e.printStackTrace();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getActivity(),"网络连接失败",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        }).start();
    }
}