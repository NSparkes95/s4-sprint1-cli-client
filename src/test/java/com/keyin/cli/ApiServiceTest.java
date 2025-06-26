package com.keyin.cli;

import com.keyin.cli.model.Aircraft;
import com.keyin.cli.model.Airport;
import com.keyin.cli.model.City;
import com.keyin.cli.model.Passenger;

import java.util.*;

public class ApiServiceTest {
    // Data structures
    private Map<String, City> cities = new HashMap<>();
    private Map<String, Airport> airports = new HashMap<>();
    private Map<String, Aircraft> aircraft = new HashMap<>();
    private Map<String, Passenger> passengers = new HashMap<>();

    public ApiServiceTest() {
        // 1. Create City
        City stJohns = new City("7", "St. John's");
        cities.put(String.valueOf(stJohns.getId()), stJohns);

        // 2. Create Airports
        Airport yyt = new Airport("1", "YYT", stJohns);
        Airport yyz = new Airport("2", "YYZ", null);
        Airport yvr = new Airport("3", "YVR", null);
        Airport yul = new Airport("4", "YUL", null);
        Airport yyc = new Airport("5", "YYC", null);
        Airport yhz = new Airport("6", "YHZ", null);
        Airport yow = new Airport("7", "YOW", null);
        airports.put(String.valueOf(yyt.getId()), yyt);
        airports.put(String.valueOf(yyz.getId()), yyz);
        airports.put(String.valueOf(yvr.getId()), yvr);
        airports.put(String.valueOf(yul.getId()), yul);
        airports.put(String.valueOf(yyc.getId()), yyc);
        airports.put(String.valueOf(yhz.getId()), yhz);
        airports.put(String.valueOf(yow.getId()), yow);

        // Link YYT to St. John's
        stJohns.setAirports(List.of(yyt));

        // 3. Create Aircraft
        Aircraft boeing = new Aircraft("1", "Boeing");
        Aircraft airbus = new Aircraft("2", "Airbus");
        Aircraft dash = new Aircraft("3", "Dash");
        // Aircraft 3 is linked to YHZ and YOW
        dash.setAirports(List.of(yhz, yow));
        aircraft.put(String.valueOf(boeing.getId()), boeing);
        aircraft.put(String.valueOf(airbus.getId()), airbus);
        aircraft.put(String.valueOf(dash.getId()), dash);

        // 4. Create Passenger
        Passenger passenger1 = new Passenger("1", "John", "Smith", "555-1234");
        passenger1.setAircraftList(List.of(boeing, airbus, dash));
        passenger1.setAirports(List.of(yyz, yvr, yul, yyc)); // Been to these airports
        passengers.put(String.valueOf(passenger1.getId()), passenger1);
    }

    // Your methods to match the tests

    public String getAirportsByCity(String cityId) {
        City city = cities.get(cityId);
        if (city != null && city.getAirports() != null) {
            StringBuilder sb = new StringBuilder();
            for (Airport airport : city.getAirports()) {
                sb.append(airport.getCode()).append(" - ").append(city.getName()).append("\n");
            }
            return sb.toString();
        }
        return "No airports found for this city.";
    }

    public String getAircraftPerPassenger(String passengerId) {
        Passenger passenger = passengers.get(passengerId);
        if (passenger != null && passenger.getAircraftList() != null) {
            StringBuilder sb = new StringBuilder();
            for (Aircraft a : passenger.getAircraftList()) {
                sb.append(a.getType()).append("\n");
            }
            return sb.toString();
        }
        return "No aircraft found for this passenger.";
    }

    public String getAirportsPerAircraft(String aircraftId) {
        Aircraft a = aircraft.get(aircraftId);
        if (a != null && a.getAirports() != null) {
            StringBuilder sb = new StringBuilder();
            for (Airport airport : a.getAirports()) {
                sb.append(airport.getCode()).append("\n");
            }
            return sb.toString();
        }
        return "No airports found for this aircraft.";
    }

    public String getAirportsPerPassenger(String passengerId) {
        Passenger passenger = passengers.get(passengerId);
        if (passenger != null && passenger.getAirports() != null) {
            StringBuilder sb = new StringBuilder();
            for (Airport airport : passenger.getAirports()) {
                sb.append(airport.getCode()).append("\n");
            }
            return sb.toString();
        }
        return "No airports found for this passenger.";
    }
}
