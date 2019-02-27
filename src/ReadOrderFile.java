import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadOrderFile {
    public static void main(String[] args) throws IOException {
        List<List<String>> orders = new ArrayList<>();

        System.out.println("Order file contain: ");
        FileReader fileReader = new FileReader("OrdersFile.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line= null;

        while((line= bufferedReader.readLine()) != null) {
            System.out.println(line);}
        bufferedReader.close();
    }
}
