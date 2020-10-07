package com.example.lab4.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.lab4.Adapter.AdtBook;
import com.example.lab4.Adapter.AdtC;
import com.example.lab4.Model.MyBook;
import com.example.lab4.Model.MyCategory;
import com.example.lab4.R;

import java.util.ArrayList;
import java.util.List;

public class SeeCategory extends AppCompatActivity {
    ListView lv;
    List<MyCategory> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_category);
        lv=findViewById(R.id.lv_c);
        list =new ArrayList<>();
        for (int i=0;i<5;i++) {
            MyCategory myBook=new MyCategory("1","java1");
            list.add(myBook);
        }
        AdtC adtUser=new AdtC( SeeCategory.this,list);
        lv.setAdapter(adtUser);
    }
}
