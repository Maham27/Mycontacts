package com.example.mycontacts;

import androidx.annotation.NonNull;

public class person {
    String name;
    String surname;
    String preference;
    String no;

    public person() {
    }

    public person(String name,String surname,String preference,String no) {
        this.name = name;
        this.surname=surname;
        this.preference=preference;
        this.no=no;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", preference='" + preference + '\'' +
                ", no='" + no + '\'' +
                '}';
    }
}
