package com.example.yt.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.itheima.PullToRefreshView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private PullToRefreshView pullToRefreshView;
    private SimpleAdapter simpleAdapter;
    private List<Map<String,Object>> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);
        pullToRefreshView=findViewById(R.id.pulltorefreshView);
        for (int i=0;i<50;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("title","sunweiaho"+i);
            list.add(map);
        }

        simpleAdapter=new SimpleAdapter(MainActivity.this,list,R.layout.item_lv,new String[]{"title"},new int[]{R.id.tv});
        listView.setAdapter(simpleAdapter);
        pullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                list.clear();
                for (int i=0;i<50;i++){
                    Map<String,Object> map=new HashMap<>();
                    map.put("title","sunweiaho"+i+i);
                    list.add(map);
                }
                simpleAdapter.notifyDataSetChanged();
                pullToRefreshView.setRefreshing(false);
            }
        });
    }
}
