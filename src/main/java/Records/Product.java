
package Records;

public class Product implements RecordsInterface {
    
    private String productID;
    private String productName;
    private String manufacturerName;
    private String supplierName;
    private int quantity;
    private float price;

    public Product(String productID, String productName, String manufacturerName, String supplierName, int quantity, float price) {
        this.productID = productID;
        this.productName = productName;
        this.manufacturerName = manufacturerName;
        this.supplierName = supplierName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String lineRepresentation(){
        String line = this.manufacturerName+","+
                        this.supplierName+","+
                        this.productID+","+
                        this.productName+","+
                        this.quantity+","+
                        this.price; 
        return line;
    }

    @Override
    public String getSearchKey() {
        return this.productID;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity >= 0) {
            this.quantity = quantity;
        }
        else {
            System.out.println("Quantity cannot be negative.");
            this.quantity = 0;
        }
    }
}
