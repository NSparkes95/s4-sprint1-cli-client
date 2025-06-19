package com.keyin.cli;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private void simulateInputAndAssertOutput(String input, String... expectedContents) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Main.main(new String[]{});  
        String result = output.toString();

        for (String expected : expectedContents) {
            assertTrue(result.contains(expected), "Expected output to contain: " + expected);
        }
    }

    @Test
    public void testMenuOption1DisplaysAirportsByCity() {
        // 7 = St. John's
        simulateInputAndAssertOutput("1\n7\n5\n\n", "=== Airport CLI ===", "YYT", "St. John's");
    }

    @Test
    public void testMenuOption2DisplaysAircraftPerPassenger() {
        simulateInputAndAssertOutput("2\n1\n5\n\n", "=== Airport CLI ===", "Boeing", "Airbus");
    }

    @Test
    public void testMenuOption3DisplaysAirportsPerAircraft() {
        simulateInputAndAssertOutput("3\n3\n5\n\n", "=== Airport CLI ===", "YHZ", "YOW");
    }

    @Test
    public void testMenuOption4DisplaysAirportsPerPassenger() {
        simulateInputAndAssertOutput("4\n1\n5\n\n", "=== Airport CLI ===", "YYZ", "YVR");
    }

    @Test
    public void testInvalidOptionThenExit() {
        simulateInputAndAssertOutput("99\n5\n\n", "Invalid input", "Exiting CLI");
    }
}
