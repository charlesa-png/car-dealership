package com.pluralsight;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    private Dealership dealership;

    public UserInterface() {

    }

    private void init() {
        DealershipFileManager dealershipFile = new DealershipFileManager();
        this.dealership = dealershipFile.getDealership();
    }

    public void display() {
        init();
        boolean running = true;
        while (running) {
            System.out.println("\nWelcome to D & B Used Cars!");
            System.out.println("What would you like to do today?\n");
            System.out.println("\t [1] Find vehicles within a price range\n\t [2] Find vehicles by make / model\n\t [3] Find vehicles by year range\n\t [4] Find vehicles by color\n\t [5] Find vehicles by mileage range \n\t [6] Find vehicles by type (car, truck, SUV, van) \n\t [7] List all vehicles \n\t [8] Add a vehicle\n\t [9] Remove a vehicle\n\t [99] Quit\n\t\nYour Choice:\n");
            int choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processGetAllVehiclesRequest();
                case 8 -> processAddVehicleRequest();
                case 9 -> processRemoveVehicleRequest();
                case 99 -> running = false;
                default -> System.out.println("\nInvalid input please try again.\n");
            }
        }

    }

    //helper method
    private void displayVehicles(List<Vehicle> vehicleList) {
        if (vehicleList.isEmpty()) {
            System.out.println("\nNo vehicles found.\n");
        }

        for (Vehicle vehicle : vehicleList) {
            System.out.println("\n" + vehicle.toString());
        }
    }

    private int getValidInt(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a whole number.\n");
            }
        }
    }

    private BigDecimal getValidBigDecimal(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                return new BigDecimal(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid price.\n");
            }
        }
    }


    //filters
    public void processGetByPriceRequest() {
        BigDecimal minPrice = getValidBigDecimal("\nEnter the minimum price:\n");
        BigDecimal maxPrice = getValidBigDecimal("\nEnter the maximum price:\n");
        dealership.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(dealership.getVehiclesByPrice(minPrice, maxPrice));
    }

    public void processGetByMakeModelRequest() {
        System.out.println("\nEnter the make of the vehicle:\n");
        String vehicleMake = scanner.nextLine().trim();
        System.out.println("\nEnter the model of the vehicle:\n");
        String vehicleModel = scanner.nextLine().trim();
        dealership.getVehiclesByMakeModel(vehicleMake, vehicleModel);
        displayVehicles(dealership.getVehiclesByMakeModel(vehicleMake, vehicleModel));
    }

    public void processGetByYearRequest() {
        int minYear = getValidInt("\nEnter the minimum year:\n");
        int maxYear = getValidInt("\nEnter the maximum year:\n");
        displayVehicles(dealership.getVehiclesByYear(minYear, maxYear));
    }

    public void processGetByColorRequest() {
        System.out.println("\nEnter the vehicle color:\n");
        String vehicleColor = scanner.nextLine().trim();
        displayVehicles(dealership.getVehiclesByColor(vehicleColor));
    }

    public void processGetByMileageRequest() {
        int minMileage = getValidInt("\nEnter the minimum mileage:\n");
        int maxMileage = getValidInt("\nEnter the maximum mileage:\n");
        displayVehicles(dealership.getVehiclesByMileage(minMileage, maxMileage));
    }

    public void processGetByVehicleTypeRequest() {
        System.out.println("\nEnter the vehicle type:\n");
        String type = scanner.nextLine();
        displayVehicles(dealership.getVehiclesByType(type));
    }

    public void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }
//personal helper methods for add vehicle

    public void processAddVehicleRequest() {
        int vin = getValidInt("\nEnter the VIN of the vehicle:\n");
        int year = getValidInt("\nEnter the year of the vehicle:\n");
        System.out.println("\nEnter the make of the vehicle:\n");
        String make = scanner.nextLine();
        System.out.println("\nEnter the model of the vehicle:\n");
        String model = scanner.nextLine();
        System.out.println("\nEnter the type of the vehicle:\n\t(ex.SUV, Car, Truck)\n");
        String type = scanner.nextLine();
        System.out.println("\nEnter the color of the vehicle:\n");
        String color = scanner.nextLine();
        int mileage = getValidInt("\nEnter the vehicle mileage:\n");
        BigDecimal price = getValidBigDecimal("\nEnter the price of the vehicle:\n");

        dealership.addVehicle(new Vehicle(vin, year, make, model, type, color, mileage, price));
        new DealershipFileManager().saveDealership(dealership);
        System.out.println("\nVehicle added successfully.\n");
    }

    public void processRemoveVehicleRequest() {
        int vin = getValidInt("\nEnter the VIN of the Vehicle you'd like to remove:\n");
        List<Vehicle> inventory = dealership.getAllVehicles();
        for (Vehicle vehicle : inventory) {
            if (vin == vehicle.getVin()) {
                dealership.removeVehicle(vehicle);
                break;
            }
        }

        new DealershipFileManager().saveDealership(dealership);
        System.out.println("\nVehicle removed successfully.\n");
    }
}
