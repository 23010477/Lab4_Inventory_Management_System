
package persons;

import Databases.RecordsInterface;

public class EmployeeUser implements RecordsInterface {
    @Override
    public String lineRepresentation(){return null;}

    @Override
    public String getSearchKey() {
        return "";
    }

    public EmployeeUser(String employeeId, String name, String email, String address, String phoneNumber){

    }
}
