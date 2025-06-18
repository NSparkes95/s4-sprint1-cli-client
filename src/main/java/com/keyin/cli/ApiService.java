package com.keyin.cli;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keyin.cli.model.Airport;
import com.keyin.cli.model.City;
import com.keyin.cli.model.Aircraft;
import com.keyin.cli.model.Passenger;

public class ApiService {

    private final String BASE_URL = "http://localhost:8080";

    private String getJsonFromUrl(String endpoint) {
        try {
            URL url = new URL(BASE_URL + endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                return "Error: HTTP " + responseCode + " returned from " + endpoint;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder json = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                json.append(line).append("\n");
            }

            reader.close();
            conn.disconnect();
            return json.toString();
        } catch (IOException e) {
            return "Error while connecting to API: " + e.getMessage();
        }
    }

    public String listAllCities() {
        try {
            String json = getJsonFromUrl("/cities");
            if (json.startsWith("Error:")) {
                return json;
            }

            ObjectMapper mapper = new ObjectMapper();
            City[] cities = mapper.readValue(json, City[].class);

            if (cities.length == 0) {
                return "No cities found.";
            }

            StringBuilder result = new StringBuilder("Available Cities:\n");
            for (City city : cities) {
                result.append("ID: ").append(city.getId())
                      .append(" | Name: ").append(city.getName())
                      .append(" | State: ").append(city.getState())
                      .append(" | Population: ").append(city.getPopulation())
                      .append("\n");
            }

            return result.toString();
        } catch (Exception e) {
            return "Error parsing city list: " + e.getMessage();
        }
    }

    public String listAllPassengers() {
        try {
            String json = getJsonFromUrl("/passengers"); 
            if (json.startsWith("Error:")) {
                return json;
            }

            ObjectMapper mapper = new ObjectMapper();
            Passenger[] passengers = mapper.readValue(json, Passenger[].class);

            if (passengers.length == 0) {
                return "No passengers found.";
            }

            StringBuilder result = new StringBuilder("Available Passengers:\n");
            for (Passenger p : passengers) {
                result.append("ID: ").append(p.getId())
                      .append(" | Name: ").append(p.getFirstName()).append(" ").append(p.getLastName())
                      .append(" | Phone: ").append(p.getPhoneNumber())
                      .append("\n");
            }

            return result.toString();
        } catch (Exception e) {
            return "Error parsing passenger list: " + e.getMessage();
        }
    }

    public String listAllAircraft() {
        try {
            String json = getJsonFromUrl("/aircrafts"); 
            if (json.startsWith("Error:")) {
                return json;
            }

            ObjectMapper mapper = new ObjectMapper();
            Aircraft[] aircraftList = mapper.readValue(json, Aircraft[].class);

            if (aircraftList.length == 0) {
                return "No aircraft found.";
            }

            StringBuilder result = new StringBuilder("Available Aircraft:\n");
            for (Aircraft a : aircraftList) {
                result.append("ID: ").append(a.getId())
                      .append(" | Type: ").append(a.getType())
                      .append(" | Airline: ").append(a.getAirlineName())
                      .append(" | Capacity: ").append(a.getNumberOfPassengers())
                      .append("\n");
            }

            return result.toString();
        } catch (Exception e) {
            return "Error parsing aircraft list: " + e.getMessage();
        }
    }

    public String getAirportsByCity(String cityId) {
        try {
            String rawJson = getJsonFromUrl("/city/" + cityId + "/airports");

            if (rawJson.startsWith("Error:")) {
                return rawJson;
            }

            ObjectMapper mapper = new ObjectMapper();
            Airport[] airports = mapper.readValue(rawJson, Airport[].class);

            if (airports.length == 0) {
                return "No airports found for city ID " + cityId + ".";
            }

            StringBuilder result = new StringBuilder("Airports in city ID " + cityId + ":\n");
            for (Airport a : airports) {
                result.append("- ").append(a.toString()).append("\n");
            }

            return result.toString();

        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String getAircraftPerPassenger(String passengerId) {
    try {
        String rawJson = getJsonFromUrl("/passenger/" + passengerId + "/aircraft");

        if (rawJson.startsWith("Error:")) return rawJson;

        ObjectMapper mapper = new ObjectMapper();
        Aircraft[] aircraftList = mapper.readValue(rawJson, Aircraft[].class);

        if (aircraftList.length == 0) return "No aircraft found for passenger ID " + passengerId;

        StringBuilder result = new StringBuilder("Aircraft flown:\n");
        for (Aircraft a : aircraftList) {
            result.append("- ").append(a.getType())
                  .append(" (").append(a.getAirlineName()).append(")")
                  .append(" with ").append(a.getNumberOfPassengers()).append(" passengers\n");
        }

        return result.toString();
    } catch (Exception e) {
        return "Error: " + e.getMessage();
    }
}


    public String getAirportsPerAircraft(String aircraftId) {
    try {
        String rawJson = getJsonFromUrl("/aircraft/" + aircraftId + "/airports");

        if (rawJson.startsWith("Error:")) return rawJson;

        ObjectMapper mapper = new ObjectMapper();
        Airport[] airports = mapper.readValue(rawJson, Airport[].class);

        if (airports.length == 0) return "No airports found for aircraft ID " + aircraftId;

        StringBuilder result = new StringBuilder("Airports used:\n");
        for (Airport a : airports) {
            result.append("- ").append(a.getName()).append(" (").append(a.getCode()).append(")\n");
        }

        return result.toString();
    } catch (Exception e) {
        return "Error: " + e.getMessage();
    }
}


    public String getAirportsPerPassenger(String passengerId) {
    try {
        String rawJson = getJsonFromUrl("/passenger/" + passengerId + "/airports");

        if (rawJson.startsWith("Error:")) {
            return rawJson;
        }

        ObjectMapper mapper = new ObjectMapper();
        Airport[] airports = mapper.readValue(rawJson, Airport[].class);

        if (airports.length == 0) {
            return "No airports found for passenger ID " + passengerId + ".";
        }

        StringBuilder result = new StringBuilder("Airports used by passenger ID " + passengerId + ":\n");
        for (Airport a : airports) {
            result.append("- ").append(a.toString()).append("\n");
        }

        return result.toString();
    } catch (Exception e) {
        return "Error: " + e.getMessage();
    }
}

      public String getAllPassengers() {
        try {
            String rawJson = getJsonFromUrl("/passengers");

            if (rawJson.startsWith("Error:")) {
                return rawJson;
            }

            ObjectMapper mapper = new ObjectMapper();
            Passenger[] passengers = mapper.readValue(rawJson, Passenger[].class);

            if (passengers.length == 0) {
                return "No passengers found.";
            }

            StringBuilder result = new StringBuilder("Passengers:\n");
            for (Passenger p : passengers) {
                result.append("- ").append(p.getFirstName())
                      .append(" ").append(p.getLastName())
                      .append(" | Phone: ").append(p.getPhoneNumber())
                      .append("\n");
            }

            return result.toString();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

}