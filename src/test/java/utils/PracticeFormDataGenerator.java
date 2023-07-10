package utils;

import com.github.javafaker.Faker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class PracticeFormDataGenerator {

    private Faker faker = new Faker();

    public PracticeFormDataGenerator() {}

    public PracticeFormDataGenerator(Faker faker) {
        this.faker = faker;
    }

    public String getRandomFirstName() {
        return faker.name().firstName();
    }

    public String getRandomLastName() {
        return faker.name().lastName();
    }

    public String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public String getRandomGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public String getRandomPhoneNumber() {
        return faker.numerify("9#########");
    }

    public String getRandomDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
        return dateFormat.format(faker.date().birthday());
    }

    public String getRandomSubject() {
        return faker.options().option(
                "Math",
                "English",
                "Chemistry",
                "Civics",
                "Computer Science",
                "Arts",
                "Physics",
                "Economics"
        );
    }

    public String getRandomHobby() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public String getRandomAddress() {
        return faker.address().streetAddress();
    }

    public String getRandomState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public String getRandomCity(String stateName) {
        return switch (stateName) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> "";
        };
    }
}
