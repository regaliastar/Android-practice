package com.example.secondmodule;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
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

        Glide.with(mContext)
                .load(item.img)
                .error(R.drawable.animation_img3)//加载出错的图片
                .placeholder(R.mipmap.ic_launcher)//加载时候的图片
                .transform(new GlideCircleTransform(mContext))//加载圆角
                .into((ImageView) helper.getView(R.id.iv));
    }
}