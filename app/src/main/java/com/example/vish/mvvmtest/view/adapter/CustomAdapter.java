package com.example.vish.mvvmtest.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bumptech.glide.Glide;
import com.example.vish.mvvmtest.R;
import com.example.vish.mvvmtest.databinding.ListRowBinding;
import com.example.vish.mvvmtest.service.model.Details;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    List<Details> mList;
    LayoutInflater mInflater;
    Context c;

    public CustomAdapter(Context context, List<Details> list){
        mList = list;
        c = context;
        mInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListRowBinding rowBinding ;
        if(convertView == null) {
            convertView = mInflater.inflate(R.layout.list_row, parent, false);
            rowBinding = DataBindingUtil.bind(convertView);
            convertView.setTag(rowBinding);
        }else{
            rowBinding = (ListRowBinding)convertView.getTag();
        }

        if(mList.get(position).getTitle() != null ) {

            rowBinding.setListRow(mList.get(position));
            //viewHolder.subtitle_tv2.setText(mList.get(i).getDescription());
            //Glide to load the images
            Glide.with(c.getApplicationContext()).load(mList.get(position).getImageHref()).into(rowBinding.imageView);
        }

        return  rowBinding.getRoot();
    }
}
