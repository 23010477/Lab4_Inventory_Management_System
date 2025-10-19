package Roles;

import Databases.EmployeeUserDatabase;
import Records.EmployeeUser;
import Records.RecordsInterface;
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
     public void addEmployee(String employeeId, String name, String email, String address, String phoneNumber) {
        EmployeeUser newEmployee = new EmployeeUser(employeeId, name, email, address, phoneNumber);
        database.addEmployee(newEmployee);
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
