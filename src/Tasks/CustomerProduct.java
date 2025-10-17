package Tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomerProduct implements RecordsInterface{

private String customerSSN,productID;
private LocalDate purchaseDate;
private boolean paid;

public String getCustomerSSN() { 
    return customerSSN;
}


public String getProductID() { 
    return productID;
}

public LocalDate getPurchaseDate() { 
    return purchaseDate;
}

public boolean isPaid() { 
   return paid;
}

public void setPaid(boolean paid) { 
    this.paid = paid;
}


public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate) {
    this.customerSSN=customerSSN;
    this.productID=productID;
    this.purchaseDate=purchaseDate;
    this.paid=false;
}

public String lineRepresentation() {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("day-month-year");
      return customerSSN + "," + productID + "," + purchaseDate.format(formatter) + "," + paid;
}
public String getSearchKey() {
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("day-month-year");
     return customerSSN + "," + productID + "," + purchaseDate.format(formatter);

}

}