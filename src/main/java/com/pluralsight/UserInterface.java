package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    private Dealership dealership;

    public UserInterface() {

    }

    private void init(){
        DealershipFileManager dealershipFile = new DealershipFileManager();
        this.dealership = dealershipFile.getDealership();
    }

    public void display(){
        init();
        boolean running = true;
        while(running) {
            System.out.println("Welcome to D & B Used Cars!");
            System.out.println("What would you like to do today?\n");
            System.out.println("\t[1] Find vehicles within a price range\n\t [2] Find vehicles by make / model\n\t [3] Find vehicles by year range\n\t [4] Find vehicles by color\n\t [5] Find vehicles by mileage range \n\t [6] Find vehicles by type (car, truck, SUV, van) \n\t [7] List all vehicles \n\t [8] Add a vehicle\n\t [9] Remove a vehicle\n\t [99] Quit\n\t");
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
                default -> System.out.println("Invalid input please try again.");
            }
        }

    }
    //helper method
    private void displayVehicles(List<Vehicle> vehicleList){
        for (Vehicle vehicle : vehicleList) {
            System.out.println(vehicle.toString());
        }
    }
    //filters
    public void processGetByPriceRequest(){

    }

    public void processGetByMakeModelRequest(){

    }

    public void processGetByYearRequest(){

    }

    public void processGetByColorRequest(){

    }

    public void processGetByMileageRequest(){

    }

    public void processGetByVehicleTypeRequest(){

    }

    public void processGetAllVehiclesRequest(){
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest(){

    }

    public void processRemoveVehicleRequest(){

    }
}
