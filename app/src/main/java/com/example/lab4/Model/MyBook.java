package com.example.lab4.Model;

public class MyBook {
    public  String tenSach;
    public  String tacGia;
    public  String maSach;
    public  String maTheLoai;
    public String NXB;
    public double giaBia;
    public int soLuong;

    public MyBook(String maSach, String maTheLoai, String NXB, double giaBia, int soLuong) {
        this.maSach = maSach;
        this.maTheLoai = maTheLoai;
        this.NXB = NXB;
        this.giaBia = giaBia;
        this.soLuong = soLuong;
    }

    public MyBook() {
    }

    public MyBook(String maSach, String maTheLoai, String tenSach, String tacGia, String NXB, double giaBia, int soLuong) {
        this.maSach = maSach;
        this.maTheLoai = maTheLoai;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.NXB = NXB;
        this.giaBia = giaBia;
        this.soLuong = soLuong;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNXB() {
        return NXB;
    }

    public void setNXB(String NXB) {
        this.NXB = NXB;
    }

    public double getGiaBia() {
        return giaBia;
    }

    public void setGiaBia(double giaBia) {
        this.giaBia = giaBia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
