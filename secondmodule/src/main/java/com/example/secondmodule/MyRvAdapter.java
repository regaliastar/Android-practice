package com.example.secondmodule;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 艾德米 on 2018/3/7.
 */


public class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.VH>{

    List<String> mList;

    public MyRvAdapter(List<String> mList) {
        this.mList = mList;
    }

    //返回的绑定的holer
    @NonNull
    @Override
    public MyRvAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        VH vh = new VH(view);

        return vh;
    }
    //对界面绑定
    @Override
    public void onBindViewHolder(@NonNull MyRvAdapter.VH holder, int position) {

        holder.mTextView.setText(mList.get(position));
    }
    //返回item的个数
    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        TextView mTextView;
        public VH(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.tv);
        }
    }
}
