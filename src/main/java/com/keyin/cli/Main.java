package com.keyin.cli;

import java.util.Scanner;

public class  Main {
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

            if (!scanner.hasNextLine()) break;
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.println("\n> Airports by City");
                    System.out.println("Tip: Not sure of the city ID? Type 'menu' and select Option 5 to view all cities.");
                    System.out.print("Enter city ID or type 'menu': ");
                    if (!scanner.hasNextLine()) break;
                    String cityId = scanner.nextLine().trim();
                    if (cityId.equalsIgnoreCase("menu")) break;
                    if (!isValidId(cityId)) {
                        System.out.println("Invalid input. Please enter a numeric city ID.");
                        break;
                    }
                    System.out.println("Result:\n" + apiService.getAirportsByCity(cityId));
                    break;

                case "2":
                    System.out.println("\n> Aircraft per Passenger");
                    System.out.println("Tip: Not sure of the passenger ID? Type 'menu' and select Option 6 to view all passengers.");
                    System.out.print("Enter passenger ID or type 'menu': ");
                    if (!scanner.hasNextLine()) break;
                    String passengerId = scanner.nextLine().trim();
                    if (passengerId.equalsIgnoreCase("menu")) break;
                    if (!isValidId(passengerId)) {
                        System.out.println("Invalid input. Please enter a numeric passenger ID.");
                        break;
                    }
                    System.out.println("Result:\n" + apiService.getAircraftPerPassenger(passengerId));
                    break;

                case "3":
                    System.out.println("\n> Airports per Aircraft");
                    System.out.println("Tip: Not sure of the aircraft ID? Type 'menu' and select Option 7 to view all aircraft.");
                    System.out.print("Enter aircraft ID or type 'menu': ");
                    if (!scanner.hasNextLine()) break;
                    String aircraftId = scanner.nextLine().trim();
                    if (aircraftId.equalsIgnoreCase("menu")) break;
                    if (!isValidId(aircraftId)) {
                        System.out.println("Invalid input. Please enter a numeric aircraft ID.");
                        break;
                    }
                    System.out.println("Result:\n" + apiService.getAirportsPerAircraft(aircraftId));
                    break;

                case "4":
                    System.out.println("\n> Airports per Passenger");
                    System.out.println("Tip: Not sure of the passenger ID? Type 'menu' and select Option 6 to view all passengers.");
                    System.out.print("Enter passenger ID or type 'menu': ");
                    if (!scanner.hasNextLine()) break;
                    String pId = scanner.nextLine().trim();
                    if (pId.equalsIgnoreCase("menu")) break;
                    if (!isValidId(pId)) {
                        System.out.println("Invalid input. Please enter a numeric passenger ID.");
                        break;
                    }
                    System.out.println("Result:\n" + apiService.getAirportsPerPassenger(pId));
                    break;

                case "5":
                    System.out.println("\n> List of All Cities:\n");
                    System.out.println(apiService.listAllCities());
                    break;

                case "6":
                    System.out.println("\n> List of All Passengers:\n");
                    System.out.println(apiService.listAllPassengers());
                    break;

                case "7":
                    System.out.println("\n> List of All Aircraft:\n");
                    System.out.println(apiService.listAllAircraft());
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

    // Helper to validate ID input
    private static boolean isValidId(String input) {
        return input != null && input.matches("\\d+");
    }
}
