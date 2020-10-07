package com.example.lab4.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lab4.Model.MyBook;
import com.example.lab4.Model.MyUser;
import com.example.lab4.R;

import java.util.List;

public class AdtBook extends BaseAdapter {
    private List<MyBook> list;
    private Context context;

    public AdtBook( Context context,List<MyBook> list) {
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
        View v= LayoutInflater.from(context).inflate(R.layout.myrowbook2,parent,false);
        TextView tv=v.findViewById(R.id.txt_1);
        TextView tv1=v.findViewById(R.id.txt_2);
        TextView tv2=v.findViewById(R.id.txt_3);
        TextView tv3=v.findViewById(R.id.txt_4);
        TextView tv4=v.findViewById(R.id.txt_5);

        tv.setText(list.get(position).getMaSach());
        tv1.setText(list.get(position).getMaTheLoai());
        tv2.setText(list.get(position).getNXB());
        tv3.setText(list.get(position).getTenSach());
        tv4.setText(list.get(position).getTacGia());

        return v;
    }
}


