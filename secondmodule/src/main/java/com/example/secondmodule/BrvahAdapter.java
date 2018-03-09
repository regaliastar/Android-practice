package com.example.secondmodule;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by 艾德米 on 2018/3/8.
 */

public class BrvahAdapter extends BaseQuickAdapter<InfosBean.NewsBean, BaseViewHolder> {

    public BrvahAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, InfosBean.NewsBean item) {
        helper.setText(R.id.tv, item.title)
                .setText(R.id.tv1, item.from);

        helper.addOnClickListener(R.id.tv)
                .addOnClickListener(R.id.tv1);
    }
}