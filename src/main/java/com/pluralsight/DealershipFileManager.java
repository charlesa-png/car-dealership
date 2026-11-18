package com.pluralsight;

import java.io.*;
import java.math.BigDecimal;
import java.util.List;

public class DealershipFileManager {
    public Dealership getDealership() {
        Dealership vehicleDealership = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"));
            String headerLine = reader.readLine();
            String[] dealershipInfo = headerLine.split("\\|");
            String name = dealershipInfo[0];
            String address = dealershipInfo[1];
            String phoneNumber = dealershipInfo[2];

            vehicleDealership = new Dealership(name, address, phoneNumber);

            String csvLine;
            while ((csvLine = reader.readLine()) != null) {
                String[] tokens = csvLine.split("\\|");
                int vin = Integer.parseInt(tokens[0]);
                int year = Integer.parseInt(tokens[1]);
                String make = tokens[2];
                String model = tokens[3];
                String type = tokens[4];
                String color = tokens[5];
                int odometer = Integer.parseInt(tokens[6]);
                BigDecimal price = new BigDecimal(tokens[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
                vehicleDealership.addVehicle(vehicle);

            }

            reader.close();

        } catch (Exception ex) {
            System.out.println("Something went wrong.");
        }
        return vehicleDealership;
    }

    public void saveDealership(Dealership dealership) {
        List<Vehicle> inventory = dealership.getAllVehicles();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.csv"));
            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            writer.newLine();

            for (Vehicle vehicle : inventory) {
                writer.write(vehicle.toString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Something went wrong.");
        }
    }
}


