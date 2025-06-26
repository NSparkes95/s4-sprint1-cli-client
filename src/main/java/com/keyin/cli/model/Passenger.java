package com.keyin.cli.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Passenger {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private List<Aircraft> aircraftList;

    // No-arg constructor for Jackson (fixes your error!)
    public Passenger() {
    }

    // Your custom constructor
    public Passenger(String number, String john, String smith, String s) {
        // Optionally set fields here
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Aircraft> getAircraftList() {
        return aircraftList;
    }
    public void setAircraftList(List<Aircraft> aircraftList) {
        this.aircraftList = aircraftList;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + phoneNumber + ")";
    }

    // If you aren't using these, you can remove them:
    public void setAirports(List<Airport> airports) { }
    public Airport[] getAirports() { return new Airport[0]; }
}
