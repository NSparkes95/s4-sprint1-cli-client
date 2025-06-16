package com.keyin.cli;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ApiServiceTest {

    @Test
    public void testGetAirportsByCity() {
        String result = ApiService.getAirportsByCity("St. John's");
        assertNotNull(result);
        assertTrue(result.contains("YYT"));
        assertTrue(result.contains("St. John's"));
    }

    @Test
    public void testGetAircraftPerPassenger() {
        String result = ApiService.getAircraftPerPassenger("test");
        assertNotNull(result);
        assertTrue(result.contains("aircraft"));
    }

    @Test
    public void testGetAirportsPerAircraft() {
    String result = ApiService.getAirportsPerAircraft("C-GJKL");
    assertNotNull(result);
    assertTrue(result.contains("YYT"));
    assertTrue(result.contains("YUL"));
    assertTrue(result.contains("\"departures\""));
    assertTrue(result.contains("\"arrivals\""));

}


    @Test
    public void testGetAirportsPerPassenger() {
        String result = ApiService.getAirportsPerPassenger("test");
        assertNotNull(result);
        assertTrue(result.contains("passenger"));
    }
}
