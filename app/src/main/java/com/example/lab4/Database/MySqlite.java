package com.example.lab4.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySqlite extends SQLiteOpenHelper {
    public MySqlite(@Nullable Context context) {
        super(context, "mydata.sql",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String the_loai="CREATE TABLE theLoai(MaTheLoai char primary key,tenTheLoai nvachar(50) ,moTa nvachar(255),viTri interger)";
        String sach="CREATE TABLE sach(MaSach char(5) primary key not null,MaTheLoai char(50) ,NXB nvarchar(50),giaBia Float not null, soLuong int not null)";
        String hoa_don="CREATE TABLE hoaDon(MaHoaDon char(7) primary key not null,NgayMua Date not null)";
        String hoa_don_chi_tiet="CREATE TABLE hoaDonChiTiet(MaHDCT INT primary key,MaHoaDon NCHAR(7),MaSach NCHAR(5),SoLuongMua INT NOT NULL)";
        String nguoi_dung="CREATE TABLE nguoiDUng(userName NVARCHAR(50) primary key , PassWord NVACHAR(50) NOT NULL,Phone NCHAR(10) NOT NULL,hoTen NVARCHAR(50))";

        db.execSQL(the_loai);
        db.execSQL(sach);
        db.execSQL(hoa_don);
        db.execSQL(hoa_don_chi_tiet);
        db.execSQL(nguoi_dung);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

  }
