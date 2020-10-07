package com.example.lab4.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lab4.Model.MyBill;

import com.example.lab4.R;

import java.util.List;

public class AdtBill extends BaseAdapter {
    private List<MyBill> list;
    private Context context;

    public AdtBill( Context context,List<MyBill> list) {
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
        View v= LayoutInflater.from(context).inflate(R.layout.rowbill,parent,false);
        TextView tv=v.findViewById(R.id.txt_1);
        TextView tv1=v.findViewById(R.id.txt_2);

        tv.setText(list.get(position).getMaHoaDon());
        tv1.setText((CharSequence) list.get(position).ngayMua);


        return v;
    }
}


