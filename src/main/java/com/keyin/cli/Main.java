package com.keyin.cli;

import java.util.Scanner;

public class Main {
    private static final ApiService apiService = new ApiService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Airport CLI ===");
            System.out.println("1. Airports by city");
            System.out.println("2. Aircraft per passenger");
            System.out.println("3. Airports per aircraft");
            System.out.println("4. Airports per passenger");
            System.out.println("5. List all cities");
            System.out.println("6. List all passengers");
            System.out.println("7. List all aircraft");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("\nAvailable cities:");
                    System.out.println(apiService.listAllCities());
                    System.out.print("Enter city ID: ");
                    String cityId = scanner.nextLine();
                    System.out.println("Result:\n" + apiService.getAirportsByCity(cityId));
                    break;
                case "2":
                    System.out.println("\nAvailable passengers:");
                    System.out.println(apiService.listAllPassengers());
                    System.out.print("Enter passenger ID: ");
                    String passengerId = scanner.nextLine();
                    System.out.println("Result:\n" + apiService.getAircraftPerPassenger(passengerId));
                    break;
                case "3":
                    System.out.println("\nAvailable aircraft:");
                    System.out.println(apiService.listAllAircraft());
                    System.out.print("Enter aircraft ID: ");
                    String aircraftId = scanner.nextLine();
                    System.out.println("Result:\n" + apiService.getAirportsPerAircraft(aircraftId));
                    break;
                case "4":
                    System.out.println("\nAvailable passengers:");
                    System.out.println(apiService.listAllPassengers());
                    System.out.print("Enter passenger ID: ");
                    String pId = scanner.nextLine();
                    System.out.println("Result:\n" + apiService.getAirportsPerPassenger(pId));
                    break;
                case "5":
                    System.out.println("\n" + apiService.listAllCities());
                    break;
                case "6":
                    System.out.println("\n" + apiService.listAllPassengers());
                    break;
                case "7":
                    System.out.println("\n" + apiService.listAllAircraft());
                    break;
                case "8":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }
        }

        scanner.close();
        System.out.println("Exiting CLI.");
    }
}
