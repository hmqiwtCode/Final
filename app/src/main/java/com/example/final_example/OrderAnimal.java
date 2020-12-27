package com.example.final_example;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "orders")
public class OrderAnimal implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String des;
    private int dala;
    private int sl;
    private double prices;

    public OrderAnimal(int id, String name, String des, int dala, int sl,double prices) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.dala = dala;
        this.sl = sl;
        this.prices = prices;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getDala() {
        return dala;
    }

    public void setDala(int dala) {
        this.dala = dala;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }
}
