package com.example.lab4.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lab4.Adapter.AdtUser;
import com.example.lab4.Model.MyUser;
import com.example.lab4.R;

import java.util.ArrayList;
import java.util.List;

public class MySeeUser extends AppCompatActivity {
    ListView listView;
    List<MyUser> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_see_user);
        listView=findViewById(R.id.listview);
        list =new ArrayList<>();
        for (int i=0;i<100;i++) {
            MyUser myUser=new MyUser("User name : Doanh","Number phone : 0963094221");
            list.add(myUser);
        }
        AdtUser adtUser=new AdtUser(MySeeUser.this,list);
        listView.setAdapter(adtUser);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
   

        return super.onContextItemSelected(item);
    }
}
