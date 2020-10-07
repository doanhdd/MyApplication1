package com.example.lab4.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.lab4.Model.MyUser;
import com.example.lab4.R;

import java.util.List;
import java.util.zip.Inflater;

public class AdtUser extends BaseAdapter {
    private List<MyUser> list;
    private Context context;

    public AdtUser( Context context,List<MyUser> list) {
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
       View v= LayoutInflater.from(context).inflate(R.layout.myrowuser,parent,false);
       TextView tv=v.findViewById(R.id.txt_name);
        TextView tv1=v.findViewById(R.id.txt_numberphone);
        tv1.setText(list.get(position).getNumberPhone());
        tv.setText(list.get(position).getUsername());
        return v;
    }
}
