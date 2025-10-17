package Databases;
import java.util.ArrayList;

public abstract class Databases  {
    String fileName;
    ArrayList<RecordsInterface> records;

    public abstract  RecordsInterface createRecordFrom(String line);
}
