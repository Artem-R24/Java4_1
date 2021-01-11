package com.company;
import java.time.LocalDate;

public class Human {
    private int id; //хранит id
    private String name; //хранит имя
    private String gender; //хранит пол
    private Division division;//подразделение
    private int salary;//зарплата
    private LocalDate BirtDate;//хранит ДР

    //сеттеры
    public Human(int id, String name, String gender, LocalDate BirtDate, int salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.BirtDate = BirtDate;
        Division division = new Division(" ");
        this.division = division;
        this.salary = salary;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void SetName(int id) {
        this.name = name;
    }

    public void SetGender(String gender) {
        this.gender = gender;
    }

    public void setDivision(String divisionName) {
        division.set_Title(divisionName);
        division.set_ID((int)(Math.random()*((50000-20000)+1)+20000));//тк при рандомизации у нас получится нецелое число типа double, преобразуем в int, тк такой тип данных у нас имеет поле ID
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void SetBDay(LocalDate BirtDate) {
        this.BirtDate = BirtDate;
    }

    //геттеры
    public Integer getID() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public Division getDivision() {
        return division;
    }
    public int getSalary(){
        return salary;
    }
    public LocalDate getBirtDate() {
        return BirtDate;
    }

}
