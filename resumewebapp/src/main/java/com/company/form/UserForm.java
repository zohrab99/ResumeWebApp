package com.company.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserForm {


    @Size(min=3 , message="name cant less than 3")
    private String name;

    @NotEmpty
    private String surname;


    private Integer nationality;

    public UserForm(){

    }

     public UserForm(String name,String surname,Integer nationality){
        this.name=name;
        this.surname=surname;
        this.nationality=nationality;

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

    public Integer getNationality() {
        return nationality;
    }

    public void setNationality(Integer nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "UserForm{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nationality=" + nationality +
                '}';
    }
}
