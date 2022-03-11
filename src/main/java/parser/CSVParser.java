package parser;

import au.com.bytecode.opencsv.CSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVParser {


    public ArrayList<String> addresses;

    public void parseCSVIntoData(String filepath) throws IOException {
        addresses = new ArrayList<>();
        File source = new File(filepath);
        CSVReader reader = new CSVReader(new FileReader(source),'\n','\0','\0');
        String[] nextLine;
        String[] tmp;

        while ((nextLine = reader.readNext())!=null){
            if(nextLine !=null ){
                tmp= Arrays.toString(nextLine).split("\n");
                tmp[0].trim().toLowerCase();
                addresses.add(tmp[0]);

            }

        }
    }

    public void printData(){
        for (int i = 0; i < addresses.size(); i++) {
            System.out.println(addresses.get(i).toString());
        }
    }
}
