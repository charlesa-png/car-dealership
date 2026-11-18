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
        inventory.remove(vehicle);
    }

    public List<Vehicle> getAllVehicles(){
        return inventory;
    }

    //Search methods
    public List<Vehicle> getVehiclesByPrice (BigDecimal min, BigDecimal max){
        List<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (min.compareTo(vehicle.getPrice()) <= 0 && max.compareTo(vehicle.getPrice()) >= 0) {
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        List<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (!vehicle.getMake().isEmpty() && vehicle.getMake().equalsIgnoreCase(make) && !vehicle.getModel().isEmpty() && vehicle.getModel().equalsIgnoreCase(model)){
                matchingVehicles.add(vehicle);
            }else if(vehicle.getModel().isEmpty() && vehicle.getMake().equalsIgnoreCase(make)){
                matchingVehicles.add(vehicle);
            }else if(vehicle.getMake().isEmpty() && vehicle.getModel().equalsIgnoreCase(model)) {
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    public List<Vehicle> getVehiclesByYear (int minYear, int maxYear){
        List<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
           if(vehicle.getYear() >= minYear && vehicle.getYear() <= maxYear){
               matchingVehicles.add(vehicle);
           }
        }
        return matchingVehicles;
    }

    public List<Vehicle> getVehiclesByColor(String color){
        List<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)){
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max){
        List<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer()>= min && vehicle.getOdometer() <= max){
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType){
        List<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

}
