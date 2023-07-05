package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static utils.RandomUtils.*;

public class RegistrationTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        var firstName = getRandomFirstName();
        var lastName = getRandomLastName();
        var userEmail = getRandomEmail();
        var gender = getRandomGender();
        var userNumber = getRandomPhoneNumber();
        var dayOfBirthdate = getRandomDayOfMonth();
        var monthOfBirthdate = getRandomMonth();
        var yearOfBirthdate = getRandomYear();
        var subject = getRandomSubject();
        var hobby = getRandomHobby();
        var filePath = "selenide.jpg";
        var address = getRandomAddress();
        var state = getRandomState();
        var city = getRandomCity(state);

        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDay(dayOfBirthdate, monthOfBirthdate, yearOfBirthdate)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPicture(filePath)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submitInputData()
                .verifyModalDialogAppeared()
                .verifyResult("Student Name", String.format("%s %s", firstName, lastName))
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", String.format("%s %s,%s", dayOfBirthdate, monthOfBirthdate, yearOfBirthdate))
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", filePath)
                .verifyResult("Address", address)
                .verifyResult("State and City", String.format("%s %s", state, city));
    }
}



