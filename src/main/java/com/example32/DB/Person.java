package com.example32.DB;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Linus on 08.04.2017.
 */
@Entity
public class Person {
    @GeneratedValue
    @Id
    private long id;

    public Person(String name, String password, String surname, int number) {
        Name = name;
        Password = password;
        Surname = surname;
        this.number = number;
    }

    public Person() {
    }

    @Column
    @NotEmpty
    private String Name;
    @Column
    @NotEmpty
    private String Password;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Column
    @NotEmpty
    private String Surname;

    @Column
    @NotNull
    @Range(min=1000,max=9999)
    private int number;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Password='" + Password + '\'' +
                ", Surname='" + Surname + '\'' +
                ", number=" + number +
                '}';
    }
}