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
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter city name: ");
                    String city = scanner.nextLine();
                    System.out.println("Result:\n" + apiService.getAirportsByCity(city));
                    break;
                case "2":
                    System.out.print("Enter passenger name: ");
                    String passenger = scanner.nextLine();
                    System.out.println("Result:\n" + apiService.getAircraftPerPassenger(passenger));
                    break;
                case "3":
                    System.out.print("Enter aircraft code: ");
                    String aircraft = scanner.nextLine();
                    System.out.println("Result:\n" + apiService.getAirportsPerAircraft(aircraft));
                    break;
                case "4":
                    System.out.print("Enter passenger name: ");
                    String pName = scanner.nextLine();
                    System.out.println("Result:\n" + apiService.getAirportsPerPassenger(pName));
                    break;
                case "5":
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
