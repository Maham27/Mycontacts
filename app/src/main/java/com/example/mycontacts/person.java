package com.example.mycontacts;

import androidx.annotation.NonNull;

public class person {
    String name;
    String email;
    String preference;
    String no;
    String adress;
    String dateofbirth;


    public person() {
    }

    public person(String name,String email,String preference,String no,String dateofbirth,String adress) {
        this.name = name;
        this.email=email;
        this.preference=preference;
        this.no=no;
        this.dateofbirth=dateofbirth;
        this.adress=adress;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", preference='" + preference + '\'' +
                ", no='" + no + '\'' +
                ", adress='" + adress + '\'' +
                ", dateofbirth='" + dateofbirth + '\'' +
                '}';
    }
}
