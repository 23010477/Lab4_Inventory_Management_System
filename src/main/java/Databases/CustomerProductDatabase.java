package Databases;

import Records.CustomerProduct;
import Records.RecordsInterface;

import java.time.LocalDate;

public class CustomerProductDatabase extends  Databases {

    public CustomerProductDatabase(String fileName) {
        super(fileName);
    }

    public RecordsInterface createRecordFrom(String line) {

        String[] token = line.split(",");
        String customerSSN = token[0];
        String productID = token[1];
        LocalDate purchaseDate = LocalDate.parse(token[2]);

        return new CustomerProduct(customerSSN,productID,purchaseDate);
    }

}
