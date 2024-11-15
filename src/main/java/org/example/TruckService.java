package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TruckService {
    public void addTruck(Truck truck){
        String query = "insert into truck (name,model,capacity,driver_name) values (?,?,?,?)";
        try{
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,truck.getName());
            statement.setString(2,truck.getModel());
            statement.setInt(3,truck.getCapacity());
            statement.setString(4,truck.getDriver_Name());
            int i = statement.executeUpdate();
            System.out.println(i +" row inserted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Truck getTruckById(int id){
        String query = "select * from truck where id=?";
        Truck truck = new Truck();
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                truck.setId(rs.getInt("id"));
                truck.setName(rs.getString("name"));
                truck.setCapacity(rs.getInt("capacity"));
                truck.setModel(rs.getString("model"));
                truck.setDriver_Name(rs.getString("driver_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return truck;
    }

    public List<Truck> getAllTrucks(){
        String query = "select * from truck";
        List<Truck> trucks = new ArrayList<>();
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Truck truck=new Truck();
                truck.setId(rs.getInt("id"));
                truck.setName(rs.getString("name"));
                truck.setModel(rs.getString("model"));
                truck.setCapacity(rs.getInt("capacity"));
                truck.setDriver_Name(rs.getString("driver_name"));
                trucks.add(truck);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return trucks;
    }

    public void updateTruck(Truck truck){
        String query = "update truck set name=?,model=?,capacity=?,driver_name=? where id=?";
        try{
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,truck.getName());
            preparedStatement.setString(2,truck.getModel());
            preparedStatement.setInt(3,truck.getCapacity());
            preparedStatement.setString(4,truck.getDriver_Name());
            preparedStatement.setInt(5,truck.getId());

            int update = preparedStatement.executeUpdate();
            System.out.println("row updated : "+update);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void deleteTruck(int id)
    {
        String deleteQuery="delete from truck where id= ?";
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1,id);
            int update = preparedStatement.executeUpdate();
            System.out.println("Row Deleted : "+update);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
