package com.example.lab4.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab4.R;

public class LoginActivity extends AppCompatActivity {


    EditText user, password;
    TextView taotk;
    Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = findViewById(R.id.editText2);
        password = findViewById(R.id.editText);
        taotk=findViewById(R.id.textView14);
        final String admin = "doanh";
        final String pass = "123";

        btnlogin = findViewById(R.id.button);
        taotk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, CreateAcc.class));
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getText().toString().isEmpty() || !user.getText().toString().equalsIgnoreCase(admin) || password.getText().toString().isEmpty()|| !password.getText().toString().equalsIgnoreCase(pass)) {
                    //  user.setErrorEnabled(true);
                    user.setError("Nhập Lại  username");
                    password.setError(" Nhập lại Password");
                } else {
//                    user.getEditText().setError("");
//                    password.getEditText().setError("");
                    Toast.makeText(getApplicationContext(), "Đăng Nhập Thành Công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                }
            }
        });
    }
}
