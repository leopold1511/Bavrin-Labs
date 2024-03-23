import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MyCsvReader {
    public static List readCsv(String file) {
        String line;
        List result = new ArrayList<String[]>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split(",");
                result.add(splitLine);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
}
