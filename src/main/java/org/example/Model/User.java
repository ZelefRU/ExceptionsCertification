package org.example.Model;

public class User {

    protected String name;
    protected String lastName;
    protected String surName;
    protected String birthDay;
    protected long number;
    protected char gender;

    public User() {}

    public User(String name, String lastName, String surName, String birthDay, long number, char gender) {
        this.name = name;
        this.lastName = lastName;
        this.surName = surName;
        this.birthDay = birthDay;
        this.number = number;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s",name, lastName, surName, birthDay, number, gender);
    }
}
