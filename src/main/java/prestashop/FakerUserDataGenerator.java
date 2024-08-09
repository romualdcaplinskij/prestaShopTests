package prestashop;

import com.github.javafaker.Faker;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FakerUserDataGenerator {

    protected Faker faker;
    protected SimpleDateFormat dateFormat;
    private String firstname;
    private String lastname;

    public FakerUserDataGenerator() {
        this.faker = new Faker();
        this.dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    }

    public String generateFirstName() {
        firstname = faker.name().firstName();
        return firstname;
    }

    public String generateLastName() {
        lastname = faker.name().lastName();
        return lastname;
    }

    public String generateEmail(String firstname, String lastname) {
        return faker.internet()
                .emailAddress(firstname.toLowerCase() +
                        "." + lastname.toLowerCase());
    }

    public String generateBirthdate() {
        Date birthday = faker.date().birthday();
        return dateFormat.format(birthday);
    }

    public String generatePassword() {
        return faker.internet().password(8, 10, true, true, true);
    }

    public Map<String, String> generateUserDataToMap() {
        Map<String, String> userData = new HashMap<>();
        userData.put("firstname", generateFirstName());
        userData.put("lastname", generateLastName());
        userData.put("email", generateEmail(firstname, lastname));
        userData.put("password", generatePassword());
        userData.put("birthdate", generateBirthdate());
        return userData;
    }

    public void saveUserDataToCSV(Map<String, String> userData, String filePath) throws IOException {
        boolean fileExists = new java.io.File(filePath).exists();
        //append: true allows to add new lines to the file
        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            if (!fileExists) {
                //creates header if file does not exist
                fileWriter.append("firstName,lastName,email,password,birthdate\n");
            }
            // Write data
            fileWriter.append(String.join(",",
                    userData.get("firstname"),
                    userData.get("lastname"),
                    userData.get("email"),
                    userData.get("password"),
                    userData.get("birthdate")
            ));
            //appends new data to the new line
            fileWriter.append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        FakerUserDataGenerator generator = new FakerUserDataGenerator();
        Map<String, String> userData = generator.generateUserDataToMap();
        generator.saveUserDataToCSV(userData, "src/test/resources/validUserData.csv");

    }

}