package com.example.lab4.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lab4.Model.MyCategory;
import com.example.lab4.Model.MyUser;
import com.example.lab4.R;

import java.util.List;

public class AdtC  extends BaseAdapter {
    private List<MyCategory> list;
    private Context context;

    public AdtC( Context context,List<MyCategory> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v= LayoutInflater.from(context).inflate(R.layout.rowc,parent,false);
        TextView tv=v.findViewById(R.id.textView43);
        TextView tv1=v.findViewById(R.id.textView44);
        tv1.setText(list.get(position).getMaTheLoai());
        tv.setText(list.get(position).getTenTheLoai());
        return v;
    }
}
