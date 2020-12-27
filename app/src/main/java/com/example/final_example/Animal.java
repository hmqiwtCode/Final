package com.example.final_example;

import java.io.Serializable;

public class Animal implements Serializable {
    private int id;
    private String name;
    private String des;
    private int bala;
    private double prices;


    public Animal(int id, String name, String des, int bala,double prices) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.bala = bala;
        this.prices = prices;
    }

    public Animal() {
    }

    public Animal(String name, String des, int bala,double prices) {
        this.name = name;
        this.des = des;
        this.bala = bala;
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

    public int getBala() {
        return bala;
    }

    public void setBala(int bala) {
        this.bala = bala;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }
}

