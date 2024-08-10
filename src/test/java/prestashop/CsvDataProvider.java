package prestashop;

import org.testng.annotations.DataProvider;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;


public class CsvDataProvider {

    @DataProvider(name = "randomLoginData")
    public Object[][] randomLoginData() throws IOException, CsvException {
        String path = "src/test/resources/validUserData.csv";  // Adjust the path to your file location

        try (CSVReader csvReader = new CSVReader(new FileReader(path))) {
            List<String[]> allData = csvReader.readAll();
            // Skip the header row
            allData.removeFirst();

            // Generate a random index within the list
            Random random = new Random();
            int randomIndex = random.nextInt(allData.size());

            // Get the random row
            String[] randomUserData = allData.get(randomIndex);
            String firstName = randomUserData[0];
            String lastName = randomUserData[1];
            String email = randomUserData[2];
            String password = randomUserData[3];

            // Return the selected firstname, lastname, email, and password
            return new Object[][]{{firstName, lastName, email, password}};
        }
    }
}

