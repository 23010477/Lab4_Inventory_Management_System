package Databases;
import Records.RecordsInterface;


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

                RecordsInterface record  = createRecordFrom(line);
                records.add(record);

                }


            } catch (IOException e) {

            System.out.println("Error reading file" + e);


              }

        }

    public void saveToFile(){
        try(FileWriter file = new FileWriter(fileName);
        PrintWriter printIntoFile = new PrintWriter(file) ){
            for(RecordsInterface i : records){
              printIntoFile.println(i.lineRepresentation());
            }
        }catch (IOException e) {System.out.println("Error Writing into File"+e);}
    }


    public void deleteRecord(String key){
        for (int i = 0 ; i < records.size(); i++){
            if (records.get(i).getSearchKey().equals(key)){
                records.remove(i);
                break;
            }
        }
    }


    public RecordsInterface getRecord(String key){
        for ( RecordsInterface i : records){
            if(i.getSearchKey().equals(key))
                return i;
        }
        return null;
    }

    public Boolean contains(String key){
        for (RecordsInterface i : records){
            if(i.getSearchKey().equals(key))
                return true;
        }
        return false;
    }


    public ArrayList<RecordsInterface> returnAllRecords(){
                return records;
        }

        public void insertRecord(RecordsInterface record){
        records.add(record);
        }



    }








