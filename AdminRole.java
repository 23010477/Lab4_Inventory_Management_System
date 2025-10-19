package Roles;

import Databases.EmployeeUserDatabase;
import Records.EmployeeUser;
import Records.RecordsInterface;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SEIF ELDEEN
 */

public class AdminRole {
    private EmployeeUserDatabase database;
    
     public AdminRole() {
        database = new EmployeeUserDatabase("Employees.txt");
    }
    public void addEmployee(EmployeeUser employee) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("Employees.txt", true))) {
        writer.write(
            employee.getEmployeeId() + "," +
            employee.getName() + "," +
            employee.getEmail() + "," +
            employee.getAddress() + "," +
            employee.getPhoneNumber()
        );
        writer.newLine(); 
        System.out.println("Employee added successfully!");
    } catch (IOException e) {
        System.out.println("Error writing to file: " + e.getMessage());
    }
}
     
    public EmployeeUser[] getListOfEmployees() {
        ArrayList<RecordsInterface> records = database.returnAllRecords();
        EmployeeUser[] employees = new EmployeeUser[records.size()];
        for (int i = 0; i < records.size(); i++) {
            employees[i] = (EmployeeUser) records.get(i);
        }
        return employees;
    }
    
    public void removeEmployee(String key) {
        database.deleteRecord(key); 
    }
    
    public void logout() {
        database.saveToFile();
        System.out.println("All unsaved data has been written to Employees.txt");
    }
   
}
