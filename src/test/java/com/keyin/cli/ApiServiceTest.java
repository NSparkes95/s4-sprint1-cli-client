package com.keyin.cli;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ApiServiceTest {

    private final ApiService apiService = new ApiService();

    @Test
    public void testGetAirportsByCity_validCity() {
        // City ID 7 = St. John's
        String result = apiService.getAirportsByCity("7");
        System.out.println("API Response:\n" + result);
        assertNotNull(result);
        assertTrue(result.contains("YYT"), "Should contain YYT code for St. John's");
    }

    @Test
    public void testGetAirportsByCity_invalidCity() {
        String result = apiService.getAirportsByCity("9999");
        assertNotNull(result);
        assertTrue(result.contains("No airports") || result.contains("Error"), "Should handle unknown city ID");
    }

    @Test
    public void testGetAircraftPerPassenger_validPassenger() {
        // Passenger ID 1 has flown aircraft ID 1 and 2
        String result = apiService.getAircraftPerPassenger("1");
        System.out.println("Aircraft for Passenger 1:\n" + result);
        assertNotNull(result);
        assertTrue(result.contains("Boeing") || result.contains("Airbus") || result.contains("Dash"), "Should return known aircraft types");
    }

    @Test
    public void testGetAircraftPerPassenger_invalidPassenger() {
        String result = apiService.getAircraftPerPassenger("9999");
        assertNotNull(result);
        assertTrue(result.contains("No aircraft") || result.contains("Error"), "Should return empty or error for unknown passenger");
    }

    @Test
    public void testGetAirportsPerAircraft_validAircraft() {
        // Aircraft ID 3 is linked to airport IDs 5 and 6 (YHZ and YOW)
        String result = apiService.getAirportsPerAircraft("3");
        System.out.println("Airports for Aircraft 3:\n" + result);
        assertNotNull(result);
        assertTrue(result.contains("YHZ") || result.contains("YOW"), "Should contain valid airport codes");
    }

    @Test
    public void testGetAirportsPerAircraft_invalidAircraft() {
        String result = apiService.getAirportsPerAircraft("9999");
        assertNotNull(result);
        assertTrue(result.contains("No airports") || result.contains("Error"), "Should handle unknown aircraft ID");
    }

    @Test
    public void testGetAirportsPerPassenger_validPassenger() {
        // Passenger ID 1 has aircraft that flew to airport IDs 1, 2, 3, 4 (YYZ, YVR, YUL, YYC)
        String result = apiService.getAirportsPerPassenger("1");
        System.out.println("Airports for Passenger 1:\n" + result);
        assertNotNull(result);
        assertTrue(result.contains("YYZ") || result.contains("YVR") || result.contains("YUL") || result.contains("YYC"), "Should contain known airport codes");
    }

    @Test
    public void testGetAirportsPerPassenger_invalidPassenger() {
        String result = apiService.getAirportsPerPassenger("9999");
        assertNotNull(result);
        assertTrue(result.contains("No airports") || result.contains("Error"), "Should return empty or error for unknown passenger");
    }
}
