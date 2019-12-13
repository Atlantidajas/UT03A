package com.practices.jorge.ut03a.Models;

public class City {
    private int id;
    private String name;
    private Double latitude;
    private Double loyalty;

    public City( String name ) {
        this.name = name;
    }

    public City(int id, String nombre, Double latitude, Double loyalty ) {
        this.id = id;
        this.name = nombre;
        this.latitude = latitude;
        this.loyalty = loyalty;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLoyalty(Double loyalty) {
        this.loyalty = loyalty;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLoyalty() {
        return loyalty;
    }
}