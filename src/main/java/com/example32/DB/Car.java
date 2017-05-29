package com.example32.DB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Linus on 08.04.2017.
 */
@Entity
public class Car {
    @GeneratedValue
    @Id
    private long id;
    @Column
    private String Model;
    @Column
    private String Color;
    @Column
    private String Nr;
    @Column
    private Boolean rent;

    public Car(String model, String color, String nr) {
        Model = model;
        Color = color;
        Nr = nr;
        this.rent = false;
    }

    public Car() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getNr() {
        return Nr;
    }

    public void setNr(String nr) {
        Nr = nr;
    }

    public Boolean getRent() {
        return rent;
    }

    public void setRent(Boolean rent) {
        this.rent = rent;
    }
}
