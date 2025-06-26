package com.keyin.cli;

import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        ApiService apiService = new ApiService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Airport CLI ===");
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. List airports by city");
            System.out.println("2. List aircraft per passenger");
            System.out.println("3. List airports per aircraft");
            System.out.println("4. List airports per passenger");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter City ID: ");
                    String cityId = scanner.nextLine().trim();
                    String airports = apiService.getAirportsByCity(cityId);
                    System.out.println(airports);
                    break;

                case "2":
                    System.out.print("Enter Passenger ID: ");
                    String passengerId = scanner.nextLine().trim();
                    String aircraft = apiService.getAircraftPerPassenger(passengerId);
                    System.out.println(aircraft);
                    break;

                case "3":
                    System.out.print("Enter Aircraft ID: ");
                    String aircraftId = scanner.nextLine().trim();
                    String airportsPerAircraft = apiService.getAirportsPerAircraft(aircraftId);
                    System.out.println(airportsPerAircraft);
                    break;

                case "4":
                    System.out.print("Enter Passenger ID: ");
                    String passId = scanner.nextLine().trim();
                    String airportsPerPassenger = apiService.getAirportsPerPassenger(passId);
                    System.out.println(airportsPerPassenger);
                    break;

                case "5":
                    System.out.println("Exiting CLI");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}
