package Databases;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class Databases  {
    String fileName;
    ArrayList<RecordsInterface> records = new ArrayList<RecordsInterface>();

    public Databases(String fileName){
        this.fileName = fileName;
    }

    public abstract  RecordsInterface createRecordFrom(String line);

    public void readFromFile(){
        records.clear();
        try (BufferedReader file = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = file.readLine()) != null) {

                if (records != null){

                }


            }

        }

    }














}
