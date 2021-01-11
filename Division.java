package com.company;

public class Division {
    private int id; //id рандомится в программе
    private String title; //название

    public Division(String title) {
        this.title = title;
        this.id=(int)(Math.random()*((50000-20000)+1)+20000);//тк при рандомизации у нас получится нецелое число типа double, преобразуем в int, тк такой тип данных у нас имеет поле ID
    }

    public void set_ID(double v) {
        this.id = id;
    }
    public int get_ID(){
        return id;
    }

    public void set_Title(String divisionName) {
        this.title = divisionName;
    }
    public String get_Title(){
        return title;
    }
}
