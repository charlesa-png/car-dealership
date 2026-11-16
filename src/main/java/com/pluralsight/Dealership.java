package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name,
                      String address,
                      String phone,
                      ArrayList<Vehicle> inventory) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = inventory;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){

    }

    public void getAllVehicles(){
        System.out.println("VIN | Year | Make | Model | Vehicle Type | Color | Odometer | Price");
        System.out.println("--------------------------------------------------------------------");
        for (Vehicle vehicle : inventory) {
            System.out.println(vehicle.getVin() + " " + vehicle.getYear() + " " + vehicle.getMake() + " " + vehicle.getModel() + " " + vehicle.getVehicleType() + " " + vehicle.getColor() + " " + vehicle.getOdometer() + " " + vehicle.getPrice() + "\n");
        }
    }

    //Search methods
    public void getVehiclesByPrice (BigDecimal min, BigDecimal max){
//        for (Vehicle car : inventory) {
//
//        }
    }

    public void getVehiclesByMakeModel(String make, String model){

    }

    public void getVehiclesByYear (int year){

    }

    public void getVehiclesByColor(String color){

    }

    public void getVehiclesByMileage(int min, int max){

    }

    public void getVehiclesByType(String vehicleType){

    }

}
