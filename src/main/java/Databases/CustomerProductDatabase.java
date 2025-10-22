package Databases;

import Records.CustomerProduct;
import Records.RecordsInterface;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomerProductDatabase extends  Databases {

    public CustomerProductDatabase(String fileName) {
        super(fileName);
    }

    public RecordsInterface createRecordFrom(String line) {


        String[] token = line.split(",");
        String customerSSN = token[0];
        String productID = token[1];
        String x = token[2].trim();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate purchaseDate = LocalDate.parse(token[2],format);
        return new CustomerProduct(customerSSN,productID,purchaseDate);
    }

}
