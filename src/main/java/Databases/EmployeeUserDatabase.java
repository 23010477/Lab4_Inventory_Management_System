package Databases;

import persons.EmployeeUser;

public class EmployeeUserDatabase extends Databases{

    public EmployeeUserDatabase(String fileName) {
        super(fileName);
    }
@Override
    public RecordsInterface createRecordFrom(String line){

    String[] token = line.split(",");
    String employeeID = token[0];
    String name = token[1];
    String email = token[2];
    String address = token[3];
    String number = token[4];


    return new EmployeeUser(employeeID,name,email,address,number);

     }


}
