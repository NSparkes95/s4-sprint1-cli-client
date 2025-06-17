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
}
