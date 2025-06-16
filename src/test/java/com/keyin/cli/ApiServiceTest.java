package com.keyin.cli;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ApiServiceTest {

    @Test
    public void testGetAirportsByCityReturnsMockData() {
        String response = ApiService.getAirportsByCity("St. John's");
        assertNotNull(response);
        assertTrue(response.contains("YYT"));
        assertTrue(response.contains("St. John's International Airport"));
    }
}
