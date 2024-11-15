package org.example;

public class Truck {
    private int id;
    private String Name;
    private String Model;
    private int Capacity;
    private String Driver_Name;

    public Truck(){

    }
    public Truck(String name, String model, int capacity, String driver_Name) {
        Name = name;
        Model = model;
        Capacity = capacity;
        Driver_Name = driver_Name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    public String getDriver_Name() {
        return Driver_Name;
    }

    public void setDriver_Name(String driver_Name) {
        Driver_Name = driver_Name;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Model='" + Model + '\'' +
                ", Capacity=" + Capacity +
                ", Driver_Name='" + Driver_Name + '\'' +
                '}';
    }
}
