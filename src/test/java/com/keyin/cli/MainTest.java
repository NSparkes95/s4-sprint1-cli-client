package com.keyin.cli;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testMenuOption1DisplaysAirportResults() {
        // Simulate user input: "1", "St. John's", "5" (to exit)
        String simulatedInput = "1\nSt. John's\n5\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        // Capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputStream);
        System.setOut(out);

        // Run the main method
        Main.main(new String[]{});

        // Convert captured output to string
        String output = outputStream.toString();

        // Assertions
        assertTrue(output.contains("=== Airport CLI ==="));
        assertTrue(output.contains("Result:"));
        assertTrue(output.contains("YYT")); // From mock data
    }

    @Test
    public void testMenuOption2DisplaysAircraftResults() {
        String simulatedInput = "2\nJane Doe\n5\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Main.main(new String[]{});
        String output = outputStream.toString();

        assertTrue(output.contains("Boeing 737") || output.contains("Airbus A320"));
        assertTrue(output.contains("C-GJKL") || output.contains("C-ABCD"));
    }

    @Test
    public void testMenuOption3DisplaysAirportPerAircraftResults() {
        String simulatedInput = "3\nC-GJKL\n5\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Main.main(new String[]{});
        String output = outputStream.toString();

        assertTrue(output.contains("departures") && output.contains("arrivals"));
        assertTrue(output.contains("YYT") && output.contains("YUL"));
    }

    @Test
    public void testMenuOption4DisplaysAirportsPerPassenger() {
        String simulatedInput = "4\nJane Doe\n5\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Main.main(new String[]{});
        String output = outputStream.toString();

        assertTrue(output.contains("Toronto Pearson") || output.contains("St. John's International"));
        assertTrue(output.contains("YYT") || output.contains("YYZ"));
    }

    @Test
    public void testInvalidOptionThenExit() {
        String simulatedInput = "99\n5\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Main.main(new String[]{});
        String output = outputStream.toString();

        assertTrue(output.contains("Invalid input. Try again."));
        assertTrue(output.contains("Exiting CLI."));
    }

}