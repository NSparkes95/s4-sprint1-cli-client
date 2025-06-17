package com.keyin.cli;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ApiServiceTest {

    private final ApiService apiService = new ApiService();

    @Test
    public void testGetAirportsByCity() {
        String result = apiService.getAirportsByCity("St. John's");
        assertNotNull(result);
        assertTrue(result.contains("YYT"));
        assertTrue(result.contains("St. John's"));
    }

    @Test
    public void testGetAircraftPerPassenger() {
        String result = apiService.getAircraftPerPassenger("test");
        assertNotNull(result);
        assertTrue(result.contains("aircraft"));
    }

    @Test
    public void testGetAirportsPerAircraft() {
        String result = apiService.getAirportsPerAircraft("C-GJKL");
        assertNotNull(result);
        assertTrue(result.contains("YYT"));
        assertTrue(result.contains("YUL"));
        assertTrue(result.contains("\"departures\""));
        assertTrue(result.contains("\"arrivals\""));
    }

    @Test
    public void testGetAirportsPerPassenger() {
        String result = apiService.getAirportsPerPassenger("test");
        assertNotNull(result);
        assertTrue(result.contains("passenger"));
        assertTrue(result.contains("airports"));
    }

    // Added Additional test coverage below

    @Test
    public void testGetAirportsByCity_withEmptyInput() {
        String result = apiService.getAirportsByCity("");
        assertNotNull(result);
        assertFalse(result.isEmpty(), "Response should not be empty even with empty input.");
    }

    @Test
    public void testGetAirportsByCity_withNullInput() {
        String result = apiService.getAirportsByCity(null);
        assertNotNull(result);
        assertFalse(result.isEmpty(), "Response should not be empty even with null input.");
    }

    @Test
    public void testGetAircraftPerPassenger_withNonsenseInput() {
        String result = apiService.getAircraftPerPassenger("!@#$%^");
        assertNotNull(result);
        assertTrue(result.contains("aircraft") || result.contains("model"));
    }

    @Test
    public void testGetAirportsPerAircraft_withEmptyInput() {
        String result = apiService.getAirportsPerAircraft("");
        assertNotNull(result);
        assertTrue(result.contains("departures") || result.contains("arrivals"));
    }

    @Test
    public void testGetAirportsPerPassenger_withNullInput() {
        String result = apiService.getAirportsPerPassenger(null);
        assertNotNull(result);
        assertTrue(result.contains("passenger") || result.contains("airports"));
    }
}
