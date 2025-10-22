import java.util.*;
import Records.*;
import Databases.*;
import Roles.*;
public class Main {
    public static void main(String[] args){
        AdminRole admin = new AdminRole();
        admin.addEmployee("E001", "mohammed", "mohammed@gmail.com", "123 Main St", "0100000000");
        admin.addEmployee("E002", "ahmed", "ahmed@gmail.com", "122 Main St", "0111111111");
        admin.addEmployee("E003", "mahmoud", "mahmoud@gmail.com", "121 Main St", "0122222222");
        EmployeeUser[] employees = admin.getListOfEmployees();
        for (EmployeeUser emp : employees) {
            System.out.println("ID: " + emp.getEmployeeId() + ", Name: " + emp.getName() + ", Email: " + emp.getEmail() + ", Address: " + emp.getAddress() + ", Phone: " + emp.getPhoneNumber());
        }
        admin.removeEmployee("E002");
        System.out.println("*****************************************************:");
        System.out.println("After removing employee E002:");
        employees = admin.getListOfEmployees();
        for (EmployeeUser emp : employees) {
            System.out.println("ID: " + emp.getEmployeeId() + ", Name: " + emp.getName() + ", Email: " + emp.getEmail() + ", Address: " + emp.getAddress() + ", Phone: " + emp.getPhoneNumber());
        }
        admin.logout();

        System.out.println("#######################################################################");
        EmployeeRole employee = new EmployeeRole();
        employee.addProduct("P001", "Dell G15", "Dell", "USA", 1000);
        employee.addProduct("P002", "HP notebook", "HP", "USA", 800);
        Product[] products = employee.getListOfProducts();
        System.out.println("*****************************************************:");
        System.out.println("List of Products:");
        for (Product prod : products) {
            System.out.println("ID: " + prod.getProductID() + ", Name: " + prod.getProductName() + ", Manufacturer: " + prod.getManufacturerName() + ", Supplier: " + prod.getSupplierName() + ", Quantity: " + prod.getQuantity() + ", Price: " + prod.getPrice());
        }
        employee.purchaseProduct("123456789", "P001", java.time.LocalDate.now());
        employee.logout();

        System.out.println("*****************************************************:");
        System.out.println("List of Purchasing Operations:");
        CustomerProduct[] operations = employee.getListOfPurchasingOperations();
        for (CustomerProduct op : operations) {
            System.out.println("Customer SSN: " + op.getCustomerSSN() + ", Product ID: " + op.getProductID() + ", Purchase Date: " + op.getPurchaseDate());
        }
    }


}
