package tests;

import datacontainers.PracticeFormDataContainer;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        var testData = new PracticeFormDataContainer();
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(testData.getFirstName())
                .setLastName(testData.getLastName())
                .setUserEmail(testData.getUserEmail())
                .setGender(testData.getGender())
                .setUserNumber(testData.getUserNumber())
                .setBirthDay(
                        testData.getDayOfBirthdate(),
                        testData.getMonthOfBirthdate(),
                        testData.getYearOfBirthdate()
                )
                .setSubject(testData.getSubject())
                .setHobby(testData.getHobby())
                .uploadPicture(testData.getFilePath())
                .setAddress(testData.getAddress())
                .setState(testData.getState())
                .setCity(testData.getCity())
                .submitInputData()
                .verifyModalDialogAppeared()
                .verifyResult("Student Name", String.format(
                        "%s %s",
                        testData.getFirstName(),
                        testData.getLastName())
                )
                .verifyResult("Student Email", testData.getUserEmail())
                .verifyResult("Gender", testData.getGender())
                .verifyResult("Mobile", testData.getUserNumber())
                .verifyResult("Date of Birth", String.format(
                        "%s %s,%s",
                        testData.getDayOfBirthdate(),
                        testData.getMonthOfBirthdate(),
                        testData.getYearOfBirthdate())
                )
                .verifyResult("Subjects", testData.getSubject())
                .verifyResult("Hobbies", testData.getHobby())
                .verifyResult("Picture", testData.getFilePath())
                .verifyResult("Address", testData.getAddress())
                .verifyResult("State and City", String.format(
                        "%s %s",
                        testData.getState(),
                        testData.getCity())
                );
    }
}



