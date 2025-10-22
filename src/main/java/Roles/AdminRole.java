package Roles;

import Databases.EmployeeUserDatabase;
import Records.EmployeeUser;
import Records.RecordsInterface;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AdminRole {
    private EmployeeUserDatabase database;

    public AdminRole() {
        database = new EmployeeUserDatabase("Employees.txt");
        database.readFromFile();
    }

    public void addEmployee(String employeeId, String name, String email, String address, String phoneNumber) {
        if (database.contains(employeeId)) {
            System.out.println("ID already exists, Operation Rejected.");
            return;
        }

        EmployeeUser employee = new EmployeeUser(employeeId, name, email, address, phoneNumber);

        database.insertRecord(employee);
        System.out.println("Employee inserted successfully in database");
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
                System.out.println("Employee removed successfully");
    }

    public void logout() {
        database.saveToFile();
        System.out.println("**** Data Saved Successfully and logged out! ****");
    }

}
