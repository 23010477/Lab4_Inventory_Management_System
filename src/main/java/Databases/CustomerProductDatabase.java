package Databases;

import Records.RecordsInterface;

public class CustomerProductDatabase extends  Databases {

    public CustomerProductDatabase(String fileName) {
        super(fileName);
    }

    public RecordsInterface createRecordFrom(String line) {

        String[] token = line.split(",");
        String customerSSN = token[0];
        String productID = token[1];
        String manufacturerName = token[2];
        Boolean purchased = Boolean.parseBoolean(token[3]);

        return null;
    }

}
