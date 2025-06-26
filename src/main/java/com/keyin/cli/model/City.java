package com.keyin.cli.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class City {
    private long id;
    private String name;
    private String state;
    private int population;

    
    public City() {
    }

    public City(String number, String s) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "City{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", state='" + state + '\'' +
               ", population=" + population +
               '}';
    }

    public void setAirports(List<Airport> yyt) {
    }

    public Airport[] getAirports() {
        return new Airport[0];
    }
}
