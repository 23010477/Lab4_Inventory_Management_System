
package Records;

public class Product implements RecordsInterface {
    @Override
    public String lineRepresentation(){return null;}

    @Override
    public String getSearchKey() {
        return "";
    }

    ;
    public Product(String productID, String productName, String manufacturerName, String supplierName, int quantity, float price) {
    }
}
