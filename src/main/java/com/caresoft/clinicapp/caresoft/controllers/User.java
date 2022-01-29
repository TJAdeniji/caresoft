package com.caresoft.clinicapp.caresoft.controllers;

public class User {
    
    protected Integer id;
    protected int pin;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public int getPin() {
        return pin;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }

    public User(int id){
        this.id = id;
    }
}
