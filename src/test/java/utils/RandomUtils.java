package utils;

import com.github.javafaker.Faker;

public class RandomUtils {

    private static Faker faker = new Faker();

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public static String getRandomPhoneNumber() {
        return String.format("%d%d", getRandomInt(11111, 99999), getRandomInt(11111, 99999));
    }

    public static String getRandomDayOfMonth() {
        return String.valueOf(getRandomInt(1, 28));
    }

    public static String getRandomMonth() {
        return faker.options().option(
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        );
    }

    public static String getRandomYear() {
        return String.valueOf(getRandomInt(1920, 2020));
    }

    public static String getRandomSubject() {
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

    public static String getRandomHobby() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public static String getRandomAddress() {
        return faker.address().streetAddress();
    }

    public static String getRandomState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public static String getRandomCity(String stateName) {
        return switch (stateName) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> "";
        };
    }

    private static int getRandomInt(int min, int max) {
        return faker.random().nextInt(min, max);
    }
}
