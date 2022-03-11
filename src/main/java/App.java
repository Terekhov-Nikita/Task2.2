import parser.CSVParser;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

        CSVParser parser = new CSVParser();
        parser.parseCSVIntoData("src/main/resources/source.csv");
        parser.printData();

    }

}
