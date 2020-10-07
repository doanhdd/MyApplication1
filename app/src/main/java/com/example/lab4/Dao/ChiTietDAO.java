package com.example.lab4.Dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lab4.Database.MySqlite;
import com.example.lab4.Model.MyBill;
import com.example.lab4.Model.MyBillCT;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.List;

public class ChiTietDAO {
    private MySqlite mySqlite;
  //  String hoa_don_chi_tiet="CREATE TABLE hoaDonChiTiet(MaHDCT INT primary key
    //  ,MaHoaDon NCHAR(7)
    //  ,MaSach NCHAR(5),
    //  SoLuongMua INT NOT NULL)";

    public ChiTietDAO(MySqlite mySqlite) {
        this.mySqlite = mySqlite;
    }
    public long insertChiTietHoaDon(MyBillCT myBillCT){
        SQLiteDatabase sqLiteDatabase =mySqlite.getWritableDatabase();
        ContentValues ctv=new ContentValues();
        ctv.put("MaHDCT",myBillCT.getMaHDCT());
        ctv.put("MaHoaDon",myBillCT.getMaHoaDon());
        ctv.put("MaSach",myBillCT.getMaSach());
        ctv.put("SoLuongMua",myBillCT.getSoLuongMua());
        long resul=sqLiteDatabase.insert("hoaDonChiTiet",null,ctv);
        sqLiteDatabase.close();
        return resul;
    }
    public long updateChiTietHoaDon(MyBillCT myBillCT){
        SQLiteDatabase sqLiteDatabase= mySqlite.getWritableDatabase();
        ContentValues ctv=new ContentValues();
        ctv.put("MaHoaDon",myBillCT.getMaHoaDon());
        ctv.put("MaSach",myBillCT.getMaSach());
        ctv.put("SoLuongMua",myBillCT.getSoLuongMua());
        long resul=sqLiteDatabase.update("hoaDonChiTiet",ctv,"MaHDCT=?",new String[]{myBillCT.maHDCT});
        sqLiteDatabase.close();
        return resul;
    }
    public long deleteChiTietHoaDon(String id){
        SQLiteDatabase sqLiteDatabase=mySqlite.getWritableDatabase();
        long resul=sqLiteDatabase.delete("hoaDonChiTiet","MaHDCT=?",new String[]{id});
        sqLiteDatabase.close();
        return resul;
    }
    public List<MyBillCT> getAllBillCT(){
        List<MyBillCT> list=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=mySqlite.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM hoaDonChiTiet",null);
        if( cursor!=null&&cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                String MaHDCT=cursor.getString(cursor.getColumnIndex("MaHDCT"));
                String MaHoaDon=cursor.getString(cursor.getColumnIndex(" MaHoaDon"));
                String MaSach=cursor.getString(cursor.getColumnIndex("MaSach"));
                int SoLuongMua=cursor.getInt(cursor.getColumnIndex("SoLuongMua"));
                MyBillCT myBillCT=new MyBillCT(MaHDCT,MaHoaDon,MaSach,SoLuongMua);
                list.add(myBillCT);
            }while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return list;
    }
}
