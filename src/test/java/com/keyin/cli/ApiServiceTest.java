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
}
