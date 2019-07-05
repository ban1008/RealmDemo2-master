package com.example.realmdemo2;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Person extends RealmObject {
    //@PrimaryKey
   // private long id;
    private String name;
    private String dept;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    private int roll;
    private long phone;


}
