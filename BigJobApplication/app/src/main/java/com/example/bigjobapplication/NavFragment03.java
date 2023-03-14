package com.example.bigjobapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bigjobapplication.bean.Solar;
import com.example.bigjobapplication.bean.User;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NavFragment03#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NavFragment03 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_PARAM1 = "param1";
    public static final String ARG_PARAM2 = "param2";
    private static final String TAG = "method";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Integer id;
    private String username;

    private EditText etUsername,etAge,etFavor,etBron;
    private Button btnUpdate,btnExit;
    private TextView tvContent;

    public NavFragment03() {
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
    public static NavFragment03 newInstance(String param1, String param2) {
        NavFragment03 fragment = new NavFragment03();
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
        return inflater.inflate(R.layout.fragment_nav03, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        etUsername = getActivity().findViewById(R.id.et_username);
        etBron = getActivity().findViewById(R.id.et_bron);
        etFavor = getActivity().findViewById(R.id.et_favor);
        etAge = getActivity().findViewById(R.id.et_age);

        btnUpdate = getActivity().findViewById(R.id.btn_update);
        btnExit = getActivity().findViewById(R.id.btn_exit);

        mParam1 = getArguments().getString(ARG_PARAM1);
        etUsername.setText(mParam1);

        dataCallback();
        updateData();

        loginOut();

        Log.d(TAG, "onActivityCreated: " + mParam1);
    }

    // 向主线程中回传数据
    JSONObject jsonObject;
    boolean isSame = false;
    // 数据更新
    public void updateData() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            String strId = String.valueOf(id);
                            User user = initUser();

                            if(isSame) {
                                return;
                            }else{
                                user.setId(Integer.valueOf(strId));
                                String json = beanToJson(user);
                                // 创建一个user对象
                                // 创建HTTP客户端
                                OkHttpClient client = new OkHttpClient();
                                // 创建HTTP请求

                                Request request = new Request.Builder()
                                        .url("http://192.168.31.88:8080/user/updateByUsername")
                                        .post(RequestBody.create(MediaType.parse("application/json"),json))
                                        .build();
                                // 执行发送的指令
                                Response response = client.newCall(request).execute();
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getActivity(),"发送成功",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getActivity(),"修改失败，网络波动或修改参数错误",Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                }).start();
            }
        });
    }

    // 数据回显
    public void dataCallback() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String subName = mParam1;
                    OkHttpClient client = new OkHttpClient();

                    Request request = new Request.Builder()
                            .url("http://192.168.31.88:8080/user/searchByUsername/" + subName)
                            .get()
                            .build();

                    Response response = client.newCall(request).execute();

                    String data = response.body().string();
                    jsonObject = new JSONObject(data);

                    Log.d(TAG, "return json: " + jsonObject);

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                id = jsonObject.getInt("id");
                                etAge.setText(String.valueOf(jsonObject.getInt("age")));
                                etFavor.setText(jsonObject.getString("foodFavor"));
                                etBron.setText(jsonObject.getString("bronSeason"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
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


    public User initUser() {
        User user = new User();

        String username = etUsername.getText().toString();
        String favor = etFavor.getText().toString();
        String bron = etBron.getText().toString();
        String age = etAge.getText().toString();

        if(!username.equals(mParam1)) {
            isSame = true;
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getActivity(),"昵称唯一不可变",Toast.LENGTH_SHORT).show();
                }
            });
        }


        user.setAge(Integer.valueOf(age));
        user.setFoodFavor(favor);
        user.setBronSeason(bron);

        return user;
    }

    public void loginOut() {
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"已退出",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public static String beanToJson(Object bean) {
        Gson gson = new Gson();
        String jsonStr = gson.toJson(bean);
        System.out.println(jsonStr);
        return jsonStr;
    }



}