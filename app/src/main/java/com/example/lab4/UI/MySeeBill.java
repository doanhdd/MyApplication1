package com.example.lab4.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.lab4.Adapter.AdtBill;
import com.example.lab4.Adapter.AdtUser;
import com.example.lab4.Model.MyBill;
import com.example.lab4.Model.MyUser;
import com.example.lab4.R;

import java.util.ArrayList;
import java.util.List;

public class MySeeBill extends AppCompatActivity {
    ListView listView;
    List<MyBill> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_see_bill);
        listView=findViewById(R.id.lv_bill);
        list =new ArrayList<>();
        for (int i=0;i<100;i++) {
            MyBill myUser=new MyBill("Mã : 001","12/11/2019");
            list.add(myUser);
        }
        AdtBill adtUser=new AdtBill(MySeeBill.this,list);
        listView.setAdapter(adtUser);
    }
}
