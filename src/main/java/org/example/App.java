package org.example;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        TruckService truckService = new TruckService();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("---------------------------------------");
            System.out.println("1. Add Truck");
            System.out.println("2. Fetch truck detail by id");
            System.out.println("3. All Trucks details");
            System.out.println("4. Update Truck details");
            System.out.println("5. Delete Truck");
            System.out.println("Enter your choice:");

            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch){
                case 1: {
                    System.out.println("Enter truck name:");
                    String name = sc.nextLine();
                    System.out.println("Enter Model:");
                    String model = sc.nextLine();
                    System.out.println("Enter Capacity:");
                    int capacity = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Driver Name:");
                    String driver_name = sc.nextLine();
                    Truck truck = new Truck(name, model, capacity, driver_name);
                    truckService.addTruck(truck);
                    break;
                }
                case 2: {
                    System.out.println("Enter truck id:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Truck truck= truckService.getTruckById(id);
                    if(truck != null){
                        System.out.println(truck);
                    }
                    else{
                        System.out.println("Truck not Present!");
                    }
                    break;
                }

                case 3:{
                    List<Truck> trucks = truckService.getAllTrucks();
                    for(Truck truck: trucks){
                        System.out.println(truck);
                    }
                    break;
                }

                case 4:{
                    System.out.println("Enter truck id:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Truck truck = truckService.getTruckById(id);
                    System.out.println("Enter new truck name:");
                    String name = sc.nextLine();
                    System.out.println("Enter new Driver Name:");
                    String driver_name = sc.nextLine();
                    truck.setDriver_Name(driver_name);
                    truck.setName(name);
                    truckService.updateTruck(truck);
                    break;
                }

                case 5:{
                    System.out.println("Enter truck id:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    truckService.deleteTruck(id);
                    break;
                }
            }
        }
    }
}
