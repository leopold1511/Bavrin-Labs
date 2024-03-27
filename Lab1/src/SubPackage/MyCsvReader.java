package SubPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MyCsvReader {
    public static List<String[]> readCsv(String file) {
        String line;
        List<String[]> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split(",");
                result.add(splitLine);
            }
        } catch (Exception e) {
            System.out.println("Error with reading csv");
        }
        return result;
    }
}
