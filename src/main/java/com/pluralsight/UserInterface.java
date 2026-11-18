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
            System.out.println("Welcome to D & B Used Cars!");
            System.out.println("What would you like to do today?\n");
            System.out.println("\t[1] Find vehicles within a price range\n\t [2] Find vehicles by make / model\n\t [3] Find vehicles by year range\n\t [4] Find vehicles by color\n\t [5] Find vehicles by mileage range \n\t [6] Find vehicles by type (car, truck, SUV, van) \n\t [7] List all vehicles \n\t [8] Add a vehicle\n\t [9] Remove a vehicle\n\t [99] Quit\n\t\nYour Choice:\n");
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
                default -> System.out.println("Invalid input please try again.\n");
            }
        }

    }

    //helper method
    private void displayVehicles(List<Vehicle> vehicleList) {
        if (vehicleList.isEmpty()) {
            System.out.println("No vehicles found.\n");
        }

        for (Vehicle vehicle : vehicleList) {
            System.out.println(vehicle.toString());
        }
    }

    //filters
    public void processGetByPriceRequest() {
        System.out.println("Enter the minimum price:\n");
        BigDecimal minPrice = scanner.nextBigDecimal();
        scanner.nextLine();
        System.out.println("Enter the maximum price:\n");
        BigDecimal maxPrice = scanner.nextBigDecimal();
        scanner.nextLine();
        dealership.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(dealership.getVehiclesByPrice(minPrice, maxPrice));
    }

    public void processGetByMakeModelRequest() {
        System.out.println("Enter the make of the vehicle:\n");
        String vehicleMake = scanner.nextLine().trim();
        System.out.println("Enter the model of the vehicle:\n");
        String vehicleModel = scanner.nextLine().trim();
        dealership.getVehiclesByMakeModel(vehicleMake, vehicleModel);
        displayVehicles(dealership.getVehiclesByMakeModel(vehicleMake, vehicleModel));
    }

    public void processGetByYearRequest() {
        System.out.println("Enter the minimum year:\n");
        int minYear = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the maximum year:\n");
        int maxYear = scanner.nextInt();
        scanner.nextLine();
        displayVehicles(dealership.getVehiclesByYear(minYear, maxYear));
    }

    public void processGetByColorRequest() {
        System.out.println("Enter the vehicle color:\n");
        String vehicleColor = scanner.nextLine().trim();
        displayVehicles(dealership.getVehiclesByColor(vehicleColor));
    }

    public void processGetByMileageRequest() {
        System.out.println("Enter the minimum mileage:\n");
        int minMileage = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the maximum mileage:\n");
        int maxMileage = scanner.nextInt();
        scanner.nextLine();
    }

    public void processGetByVehicleTypeRequest() {
        System.out.println("Enter the vehicle type:\n");
        String type = scanner.nextLine();
        displayVehicles(dealership.getVehiclesByType(type));
    }

    public void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest() {
System.out.println("Enter the VIN of the vehicle:\n");
int vin = scanner.nextInt();
scanner.nextLine();
System.out.println("Enter the year of the vehicle:\n");
int year = scanner.nextInt();
scanner.nextLine();
System.out.println("Enter the make of the vehicle:\n");
String make = scanner.nextLine();
        System.out.println("Enter the model of the vehicle:\n");
        String model = scanner.nextLine();
        System.out.println("Enter the type of the vehicle:\n\t(ex.SUV, Car, Truck)\n");
        String type = scanner.nextLine();
        System.out.println("Enter the color of the vehicle:\n");
        String color = scanner.nextLine();
        System.out.println("Enter the vehicle mileage:\n");
        int mileage = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the price of the vehicle:\n");
        BigDecimal price = scanner.nextBigDecimal();
        scanner.nextLine();

        dealership.addVehicle(new Vehicle(vin,year,make,model,type,color,mileage,price));
    }

    public void processRemoveVehicleRequest() {

    }
}
