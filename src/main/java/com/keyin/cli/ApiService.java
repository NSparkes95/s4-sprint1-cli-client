package com.keyin.cli;

public class ApiService {

    public static String getAirportsByCity(String city) {
        return """
            [
              {
                "id": 1,
                "name": "St. John's International Airport",
                "code": "YYT",
                "city": "St. John's"
              },
              {
                "id": 2,
                "name": "Deer Lake Regional Airport",
                "code": "YDF",
                "city": "Deer Lake"
              }
            ]
            """;
    }

    public static String getAircraftPerPassenger(String passengerName) {
        return """
            [
              {
                "passenger": "Jane Doe",
                "aircraft": [
                  {
                    "model": "Boeing 737",
                    "registration": "C-GJKL"
                  },
                  {
                    "model": "Airbus A320",
                    "registration": "C-ABCD"
                  }
                ]
              }
            ]
            """;
    }
}
