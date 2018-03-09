package com.example.secondmodule;

import android.app.Activity;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class BrvahActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener{
    RecyclerView mRecyclerView;
    SwipeRefreshLayout mSwipeRefreshLayout;
    InfosBean bean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        initHttp();

    }

    public void initHttp(){
        String url = "http://www.mfcsjk.com/get?id=447";
        OkGo.post(url)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //s 即为json
                        bean = new Gson().fromJson(s,InfosBean.class);
                        //请求成功后再进行初始化recyclerview
                        initRv();
                    }
                });
    }

    public void initRv(){
        mRecyclerView = findViewById(R.id.rv);
        mSwipeRefreshLayout = findViewById(R.id.srf);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorAccent), Color.parseColor("#ffff00"));

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);


        BrvahAdapter adapter = new BrvahAdapter(R.layout.item, bean.news);

        adapter.isFirstOnly(false);
        adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);

        adapter.addHeaderView(getHeaderView(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BrvahActivity.this, "点击了头部", Toast.LENGTH_SHORT).show();
            }
        }));
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showShort("点击了第" + position + "个Item");
            }
        });

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.tv:
                        ToastUtils.showShort("点击了第"+position+"个tv");
                        break;
                    case R.id.tv1:
                        ToastUtils.showShort("点击了第"+position+"个tv1");
                        break;
                }
            }
        });

        mRecyclerView.setAdapter(adapter);
    }

    /**
     *  刷新
     * */
    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(BrvahActivity.this, "刷新成功", Toast.LENGTH_SHORT).show();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        },1000);
    }

    private View getHeaderView(View.OnClickListener listener) {
        View view = getLayoutInflater().inflate(R.layout.head_view, (ViewGroup) mRecyclerView.getParent(), false);
        view.setOnClickListener(listener);
        return view;
    }
}
