package com.example.lab4.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.lab4.Adapter.AdtBook;
import com.example.lab4.Adapter.AdtUser;
import com.example.lab4.Model.MyBook;
import com.example.lab4.Model.MyUser;
import com.example.lab4.R;

import java.util.ArrayList;
import java.util.List;

public class TopActivity extends AppCompatActivity {
    ListView lv;
    List<MyBook> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        lv=findViewById(R.id.lv_top);
        list =new ArrayList<>();
        for (int i=0;i<10;i++) {
            MyBook myBook=new MyBook("1","2","java1",
                    "190000","doanh",20001,23);
            list.add(myBook);
        }
        AdtBook adtUser=new AdtBook(TopActivity.this,list);
        lv.setAdapter(adtUser);
    }
}
