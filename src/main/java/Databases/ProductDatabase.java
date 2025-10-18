package Databases;

import products.Product;

public class ProductDatabase extends Databases {
    public ProductDatabase(String fileName) {
        super(fileName);
    }
    @Override
    public RecordsInterface createRecordFrom(String line) {
        String[] token = line.split(",");
        String productID = token[0];
        String productName = token[1];
        String manufacturerName = token[2];
        String supplierName = token[3];
        int quantity = Integer.parseInt(token[4]);
        float price = Float.parseFloat(token[5]);

        return new Product(productID, productName, manufacturerName, supplierName, quantity, price);
    }

}
