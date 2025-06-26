package com.keyin.cli.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class City {
    private long id;
    private String name;
    private String province;
    private int population;

    public City(String number, String s) {}

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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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
               ", province='" + province + '\'' +
               ", population=" + population +
               '}';
    }

    public void setAirports(List<Airport> yyt) {
    }

    public Airport[] getAirports() {
        return new Airport[0];
    }
}
