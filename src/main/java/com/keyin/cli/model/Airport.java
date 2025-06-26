package com.keyin.cli.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Airport {
    private Long id;
    private String name;
    private String code;

    // No-arg constructor for Jackson (required for deserialization)
    public Airport() {
    }

    // Custom constructor (you can use this in your mock data setup)
    public Airport(String id, String code, City city) {
        // Convert id to Long (if needed) and set fields
        try {
            this.id = Long.parseLong(id);
        } catch (Exception e) {
            this.id = null; // or 0L if you prefer
        }
        this.code = code;
        this.name = city != null ? city.getName() + " Airport" : code + " Airport";
        // (If you want more control over the name, feel free to adjust)
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    @Override
    public String toString() {
        return name + " (" + code + ")";
    }
}
