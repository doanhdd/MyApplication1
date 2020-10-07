package com.example.lab4.Dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lab4.Database.MySqlite;
import com.example.lab4.Model.MyUser;

import java.util.ArrayList;
import java.util.List;

public class NguoiDungDAO {
    private MySqlite mySqlite;

    public NguoiDungDAO(MySqlite mySqlite) {
        this.mySqlite = mySqlite;
    }
//  String nguoi_dung="CREATE TABLE nguoiDUng(userName NVARCHAR(50) primary key ,
//  PassWord NVACHAR(50) NOT NULL,
//  Phone NCHAR(10) NOT NULL,
//  hoTen NVARCHAR(50))";
   public long insertNguoiDung(MyUser myUser){
       SQLiteDatabase sqLiteDatabase=mySqlite.getWritableDatabase();
       ContentValues ctv=new ContentValues();
       ctv.put("userName",myUser.getUsername());
       ctv.put("PassWord",myUser.getPassword());
       ctv.put("Phone",myUser.getHoTen());
       ctv.put("hoTen",myUser.getNumberPhone());
       long resul=sqLiteDatabase.insert("nguoiDUng",null,ctv);
       sqLiteDatabase.close();
       return resul;
   }
   public long updateNguoiDung(MyUser myUser){
        SQLiteDatabase sqLiteDatabase=mySqlite.getWritableDatabase();
        ContentValues ctv=new ContentValues();
       ctv.put("PassWord",myUser.getPassword());
       ctv.put("Phone",myUser.getHoTen());
       ctv.put("hoTen",myUser.getNumberPhone());
       long resul=sqLiteDatabase.update("nguoiDUng",ctv,"userName=?",new String[]{myUser.username});
       sqLiteDatabase.close();
       return resul;
   }
   public long deleteNguoiDung(String username){
        SQLiteDatabase sqLiteDatabase=mySqlite.getWritableDatabase();
        long resul=sqLiteDatabase.delete("nguoiDUng","userName=?",new String[]{username});
        sqLiteDatabase.close();
        return resul;
   }
   public List<MyUser> getAllUser(){
        SQLiteDatabase sqLiteDatabase=mySqlite.getWritableDatabase();
       Cursor cursor=sqLiteDatabase.rawQuery("SELECT*FROM nguoiDUng",null);
       List<MyUser> list=new ArrayList<>();
       if(cursor!=null&&cursor.getCount()>0){
           cursor.moveToFirst();
           do {
           String userName =cursor.getString(cursor.getColumnIndex("userName"));
           String PassWord=cursor.getString(cursor.getColumnIndex("PassWord"));
           String Phone=cursor.getString(cursor.getColumnIndex("Phone"));
           String hoTen=cursor.getString(cursor.getColumnIndex("hoTen"));
           MyUser myUser=new MyUser(userName,PassWord,Phone,hoTen);
           list.add(myUser);


           }while (cursor.moveToNext());

       }
       sqLiteDatabase.close();
       return list;
   }
}
