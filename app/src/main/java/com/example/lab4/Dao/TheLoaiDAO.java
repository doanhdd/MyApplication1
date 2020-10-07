package com.example.lab4.Dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lab4.Database.MySqlite;
import com.example.lab4.Model.MyCategory;

import java.util.ArrayList;
import java.util.List;

public class TheLoaiDAO {
    private MySqlite mySqlite;

    public TheLoaiDAO(MySqlite mySqlite) {
        this.mySqlite = mySqlite;
    }
   // String the_loai="CREATE TABLE theLoai(MaTheLoai char primary key,
    // tenTheLoai nvachar(50) ,moTa nvachar(255),viTri interger)";

    public long insertTheLoai(MyCategory myCategory){
        SQLiteDatabase sqLiteDatabase=mySqlite.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("MaTheLoai",myCategory.getMaTheLoai());
        contentValues.put("tenTheLoai",myCategory.getTenTheLoai());
        contentValues.put("moTa",myCategory.getMoTa());
        contentValues.put("viTri",myCategory.getViTri());
        long resul=sqLiteDatabase.insert("theLoai",null,contentValues);
        sqLiteDatabase.close();
        return resul;
    }
    public long updateTheLoai(MyCategory myCategory){
        SQLiteDatabase sqLiteDatabase=mySqlite.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("tenTheLoai",myCategory.getTenTheLoai());
        contentValues.put("moTa",myCategory.getMoTa());
        contentValues.put("viTri",myCategory.getViTri());
        long resul=sqLiteDatabase.update("theLoai",contentValues,"MaTheLoai=?",new String[]{myCategory.maTheLoai});
        sqLiteDatabase.close();
        return resul;
    }
    public long deleteTheLoai(String id){
        SQLiteDatabase sqLiteDatabase=mySqlite.getWritableDatabase();
        long resul=sqLiteDatabase.delete("theLoai","MaTheLoai=?",new String[]{id});
        sqLiteDatabase.close();
        return resul;
    }
    public List<MyCategory> getAllCategory(){
        SQLiteDatabase sqLiteDatabase=mySqlite.getWritableDatabase();
        List<MyCategory> list=new ArrayList<>();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM theLoai",null);
        if(cursor!=null&&cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                String MaTheLoai=cursor.getString(cursor.getColumnIndex("MaTheLoai"));
                String tenTheLoai=cursor.getString(cursor.getColumnIndex("tenTheLoai"));
                String moTa=cursor.getString(cursor.getColumnIndex("moTa"));
                String viTri=cursor.getString(cursor.getColumnIndex("viTri"));
                MyCategory myCategory=new MyCategory(MaTheLoai,tenTheLoai,moTa,viTri);
                list.add(myCategory);
        }while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return list;
    }
}
