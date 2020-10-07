package com.example.lab4.Dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lab4.Database.MySqlite;
import com.example.lab4.Model.MyBook;

import java.util.ArrayList;
import java.util.List;

public class SachDAO {
    private MySqlite mySqlite;

    public SachDAO(MySqlite mySqlite) {
        this.mySqlite = mySqlite;
    }
    //    String sach="CREATE TABLE sach(MaSach char(5) primary key not null,
    //    MaTheLoai char(50) ,
    //    NXB nvarchar(50),
    //    giaBia Float not null,
    //    soLuong int not null)";
    //
    public long insertSach(MyBook myBook){
        SQLiteDatabase sqLiteDatabase=mySqlite.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("MaSach",myBook.getMaSach());
        contentValues.put("MaTheLoai",myBook.getMaTheLoai());
        contentValues.put("NXB",myBook.getNXB());
        contentValues.put("giaBia",myBook.getGiaBia());
        contentValues.put("soLuong",myBook.getSoLuong());
        long resul=sqLiteDatabase.insert("sach",null,contentValues);
        sqLiteDatabase.close();
        return resul;
    }
    public long updateSach(MyBook myBook){
        SQLiteDatabase sqLiteDatabase=mySqlite.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("MaTheLoai",myBook.getMaTheLoai());
        contentValues.put("NXB",myBook.getNXB());
        contentValues.put("giaBia",myBook.getGiaBia());
        contentValues.put("soLuong",myBook.getSoLuong());
        long resul=sqLiteDatabase.update("sach",contentValues,"MaSach=?",new String[]{myBook.maSach});
        sqLiteDatabase.close();
        return resul;
    }
    public long delete(String id){
        SQLiteDatabase sqLiteDatabase=mySqlite.getWritableDatabase();
        long resul=sqLiteDatabase.delete("sach","MaSach=?",new String[]{id});
        sqLiteDatabase.close();
        return resul;

    }
    public List<MyBook> getAllBook(){
        SQLiteDatabase sqLiteDatabase=mySqlite.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM sach",null);
        List<MyBook> list=new ArrayList<>();
        if(cursor!=null&&cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                String MaSach=cursor.getString(cursor.getColumnIndex("MaSach"));
                String MaTheLoai=cursor.getString(cursor.getColumnIndex("MaTheLoai"));
                String NXB=cursor.getString(cursor.getColumnIndex("NXB"));
                Double giaBia=cursor.getDouble(cursor.getColumnIndex("giaBia"));
               int soLuong=cursor.getInt(cursor.getColumnIndex("soLuong"));
                MyBook book=new MyBook(MaSach,MaTheLoai,NXB,giaBia,soLuong);
                list.add(book);
            }while (cursor.moveToNext());


        }
        sqLiteDatabase.close();
        return list;
}}
