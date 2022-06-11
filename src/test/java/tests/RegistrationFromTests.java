package tests;

import pages.RegistrationFromPage;
import org.junit.jupiter.api.Test;

import java.io.File;

import static tests.TestData.FIRST_NAME;
import static tests.TestData.LAST_NAME;


public class RegistrationFromTests extends TestBase{

    RegistrationFromPage registrationFromPage = new RegistrationFromPage();

    @Test
    void successfulTest() {
        registrationFromPage.OpenPage()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setUserEmail("alexLar@gmail.com")
                .setGenter("Male")
                .setUserNumber("3748596032")
                .setDateOfBirth("10", "April", "1990")
                .setSubjects("Physics")
                .setHobbies("Reading")
                .setLoadPicture(String.valueOf(new File("src/test/resources/Screenshot_2.png")))
                .setCurrentAddress("Lenina 5")
                .setStateCity("NCR")
                .setStateCity2("Delhi")
                .checkResult("Student Name", FIRST_NAME + " " + LAST_NAME)
                .checkResult("Student Email", "alexLar@gmail.com")
                .checkResult("Date of Birth", "10 April,1990");
    }
}