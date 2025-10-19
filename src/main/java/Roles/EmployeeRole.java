package Roles;

import Databases.CustomerProductDatabase;
import Databases.ProductDatabase;
import Records.CustomerProduct;
import Records.Product;
import Records.RecordsInterface;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class EmployeeRole {
    private ProductDatabase ProductsDatabase;
    private CustomerProductDatabase customerProductDatabase;

    public EmployeeRole() {
        ProductsDatabase = new ProductDatabase("Products.txt");
        customerProductDatabase = new CustomerProductDatabase("CustomersProducts.txt");

    }

    public void addProduct(String productID, String productName, String manufacturerName,
            String supplierName, int quantity, float price) {

        Product newProduct = new Product(productID, productName, manufacturerName, supplierName, quantity, price);
        ProductsDatabase.insertRecord(newProduct);
        ProductsDatabase.saveToFile();
    }

    public Product[] getListOfProducts() {
        ArrayList<RecordsInterface> recs = ProductsDatabase.returnAllRecords();
        Product[] products = new Product[recs.size()];
        for (int i = 0; i < recs.size(); i++) {
            products[i] = (Product) recs.get(i);
        }
        return products;
    }

    public CustomerProduct[] getListOfPurchasingOperations() {

        ArrayList<RecordsInterface> recs = customerProductDatabase.returnAllRecords();
        CustomerProduct[] ops = new CustomerProduct[recs.size()];
        for (int i = 0; i < recs.size(); i++) {
            ops[i] = (CustomerProduct) recs.get(i);
        }
        return ops;
    }

    /*
     * private int findProductIndex(String productID) {
     * RecordsInterface[] recs = ProductsDatabase.returnAllRecords();
     * for (int i = 0; i < recs.length; i++) {
     * Product p = (Product) recs[i];
     * if (p.getProductID().equals(productID)) return i;
     * }
     * return -1;
     * }
     */

    public boolean purchaseProduct(String customerSSN, String productID, LocalDate purchaseDate) {

        Product[] products = getListOfProducts();
        Product target = null;

        for (Product p : products) {
            if (p.getProductID().equals(productID)) {
                target = p;
                break;
            }
        }

        if (target == null || target.getQuantity() == 0) {
            return false;
        }

        else {
            target.setQuantity(target.getQuantity() - 1);
        }

        CustomerProduct newPurchase = new CustomerProduct(customerSSN, productID, purchaseDate);
        customerProductDatabase.insertRecord(newPurchase);

        ProductsDatabase.saveToFile();
        customerProductDatabase.saveToFile();

        return true;
    }

    public double returnProduct(String customerSSN, String productID, LocalDate purchaseDate, LocalDate returnDate) {

        if (returnDate.isBefore(purchaseDate)) {
            return -1;
        }

        Product[] products = getListOfProducts();
        Product target = null;
        for (Product p : products) {
            if (p.getProductID().equals(productID)) {
                target = p;
                break;
            }
        }
        if (target == null) {
            return -1;
        }

        CustomerProduct[] purchases = getListOfPurchasingOperations();
        CustomerProduct foundPurchase = null;
        for (CustomerProduct cp : purchases) {
            if (cp.getCustomerSSN().equals(customerSSN)
                    && cp.getProductID().equals(productID)
                    && cp.getPurchaseDate().equals(purchaseDate)) {
                foundPurchase = cp;
                break;
            }
        }
        if (foundPurchase == null) {
            return -1;
        }

        long daysBetween = ChronoUnit.DAYS.between(purchaseDate, returnDate);
        if (daysBetween > 14) {
            return -1;
        }

        target.setQuantity(target.getQuantity() + 1);
        customerProductDatabase.deleteRecord(customerSSN + "," + productID + "," + purchaseDate.toString());
        ProductsDatabase.saveToFile();

        return target.getPrice();
    }

    public boolean applyPayment(String customerSSN, LocalDate purchaseDate) {
        CustomerProduct[] purchases = getListOfPurchasingOperations();

        for (CustomerProduct purchase : purchases) {
            if (purchase.getCustomerSSN().equals(customerSSN)
                    && purchase.getPurchaseDate().equals(purchaseDate)) {

                if (!purchase.isPaid()) {
                    purchase.setPaid(true);

                    customerProductDatabase.saveToFile();

                    System.out.println("Payment applied successfully for customer " + customerSSN);
                    return true;
                } else {
                    System.out.println("Payment was already applied before!");
                    return false;
                }
            }
        }

        System.out.println("No purchase found for customer " + customerSSN + " on " + purchaseDate);
        return false;
    }

    public void logout() {
        ProductsDatabase.saveToFile();
        customerProductDatabase.saveToFile();
    }

}