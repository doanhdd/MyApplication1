package com.example.lab4.Model;

public class MyUser {

public String username;
public String password;
public String hoTen;
public String numberPhone;

    public MyUser( String username, String password, String hoTen,String numberPhone) {

        this.username = username;
        this.password = password;
        this.hoTen = hoTen;
        this.numberPhone = numberPhone;
    }
    public MyUser( String username,String numberPhone) {

        this.username = username;

        this.numberPhone = numberPhone;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public MyUser() {
    }

    public MyUser( String username, String password, String hoTen) {

        this.username = username;
        this.password = password;
        this.hoTen = hoTen;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
}
