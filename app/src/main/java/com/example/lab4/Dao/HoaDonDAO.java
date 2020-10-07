package com.example.lab4.Dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lab4.Database.MySqlite;
import com.example.lab4.Model.MyBill;


import java.util.ArrayList;
import java.util.List;

public class HoaDonDAO {
    private MySqlite mySqlite;

    public HoaDonDAO(MySqlite mySqlite) {
        this.mySqlite = mySqlite;
    }
  public long insertHoaDon(MyBill m){
      SQLiteDatabase sqLiteDatabase=mySqlite.getWritableDatabase();
      ContentValues ctv=new ContentValues();
      ctv.put("MaHoaDon",m.getMaHoaDon());
      ctv.put("NgayMua",m.getNgayMua());
      long resul = sqLiteDatabase.insert(" hoaDon",null,ctv);
      sqLiteDatabase.close();

        return resul;
  }
  public long updateBill(MyBill bill){
        SQLiteDatabase sqLiteDatabase=mySqlite.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("NgayMua",bill.ngayMua);
        long result = sqLiteDatabase.update
                ("hoaDon",contentValues,"MaHoaDon=?",new String[]{bill.maHoaDon});
        sqLiteDatabase.close();
        return result;
  }
 public long deleteBill(String id){
        SQLiteDatabase sqLiteDatabase=mySqlite.getWritableDatabase();
        long result = sqLiteDatabase.delete("hoaDon","MaHoaDon=?",new String[]{id});
        sqLiteDatabase.close();
        return result;
 }
 public List<MyBill> getAllBills(){
       List<MyBill> billList =new ArrayList<>();
       SQLiteDatabase sqLiteDatabase=mySqlite.getWritableDatabase();

       Cursor cursor=sqLiteDatabase.rawQuery("SELECT*FROM hoaDon",null);
        if(cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                String id=cursor.getString(cursor.getColumnIndex("MaHoaDon"));
                String date=cursor.getString(cursor.getColumnIndex("NgayMua"));
                MyBill myBill=new MyBill(id,date);
                billList.add(myBill);
            }while (cursor.moveToNext());
        }
     sqLiteDatabase.close();
        return billList;
 }



}



