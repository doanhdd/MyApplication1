package com.example.lab4.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lab4.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void clickUser(View v){
        Intent i=new Intent(this,UserActivity.class);
        startActivity(i);
    }
    public void clickBook(View v){
        Intent i=new Intent(this,BookActivity.class);
        startActivity(i);
    }
    public void clickCategory(View v){
        Intent i=new Intent(this,CategoryActivity.class);
        startActivity(i);
    }
    public void clickBill(View v){
        Intent i=new Intent(this,BillActivity.class);
        startActivity(i);
    }
    public void clickTop(View v){
        Intent i=new Intent(this,TopActivity.class);
        startActivity(i);
    }
    public void clickStatistics(View v){
        Intent i=new Intent(this,StatisticsActivity.class);
        startActivity(i);
    }
}
