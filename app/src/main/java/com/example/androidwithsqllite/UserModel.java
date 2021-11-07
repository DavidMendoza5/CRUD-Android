package com.example.androidwithsqllite;

public class UserModel {
    private String rfc, name, email, phone;

    public UserModel(){

    }

    public UserModel(String rfc, String name, String phone, String email) {
        this.rfc = rfc;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getRfc() {
        return rfc;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
