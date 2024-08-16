package prestashop;
import com.github.javafaker.Faker;


import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FakerUserDataGenerator {

    protected Faker faker;
    protected SimpleDateFormat dateFormat;
    private String firstname;
    private String lastname;

    public FakerUserDataGenerator() {
        Locale locale = new Locale("en", "US");
        this.faker = new Faker(locale);
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
        return faker.internet().password(9, 10, true, true, true);
    }

    public String generateWeakPassword() {
        return faker.internet().password(6, 7, true, false, true);
    }

    public String generateCompanyName(){
        return faker.company().name();
    }

    public String generateAddress(){
        return faker.address().streetAddress();
    }

    public String generateCity(){
        return faker.address().cityName();
    }

    public String generatePostalCode(){
        return faker.address()
                .zipCodeByState(faker.address()
                        .stateAbbr()); //zipcode by state abbreviation is needed because it zip field accepts only 5 digit zipcodes
    }

    public String generatePhoneNumber(){
        return faker.phoneNumber().cellPhone();
    }

    public String generateAlias(){
        return faker.name().prefix();
    }

    public String generateState(){
        return faker.address().state();
    }

    public String generateCountry(){
        return faker.address().country();
    }

    public Map<String, String> generateUserDataToMap() {
        Map<String, String> userData = new HashMap<>();
        userData.put("firstname", generateFirstName());
        userData.put("lastname", generateLastName());
        userData.put("email", generateEmail(firstname, lastname));
        userData.put("password", generatePassword());
        userData.put("weakPassword", generateWeakPassword());
        userData.put("birthdate", generateBirthdate());
        return userData;
    }

    public Map<String, String> generateAddressData() {
        Map<String, String> addressData = new HashMap<>();
        addressData.put("alias", generateAlias());
        addressData.put("company", generateCompanyName());
        addressData.put("address", generateAddress());
        addressData.put("secondAddress", "");
        addressData.put("city", generateCity());
        addressData.put("state", generateState());
        addressData.put("postalCode", generatePostalCode());
        addressData.put("country", generateCountry());
        addressData.put("mobileNumber", generatePhoneNumber());
        return addressData;
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


}