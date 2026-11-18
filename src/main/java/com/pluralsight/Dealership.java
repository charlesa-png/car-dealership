package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory;

    public Dealership(String name,
                      String address,
                      String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

//getters && setters
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

    public List<Vehicle> getAllVehicles(){
//        System.out.println("VIN | Year | Make | Model | Vehicle Type | Color | Odometer | Price");
//        System.out.println("--------------------------------------------------------------------");
//        for (Vehicle vehicle : inventory) {
//            System.out.println(vehicle.getVin() + " " + vehicle.getYear() + " " + vehicle.getMake() + " " + vehicle.getModel() + " " + vehicle.getVehicleType() + " " + vehicle.getColor() + " " + vehicle.getOdometer() + " " + vehicle.getPrice() + "\n");
//        }
        return inventory;
    }

    //Search methods
    public List<Vehicle> getVehiclesByPrice (BigDecimal min, BigDecimal max){
//        for (Vehicle car : inventory) {
//
//        }
        return null;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){

        return null;
    }

    public List<Vehicle> getVehiclesByYear (int minYear, int maxYear){

        return null;
    }

    public List<Vehicle> getVehiclesByColor(String color){

        return null;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max){

        return null;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType){

        return null;
    }

}
