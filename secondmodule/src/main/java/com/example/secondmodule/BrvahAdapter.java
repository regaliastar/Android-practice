package com.example.secondmodule;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by 艾德米 on 2018/3/8.
 */

public class BrvahAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public BrvahAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

        helper.setText(R.id.tv, item)
                .setText(R.id.tv1, item);

        helper.addOnClickListener(R.id.tv)
                .addOnClickListener(R.id.tv1);
    }
}