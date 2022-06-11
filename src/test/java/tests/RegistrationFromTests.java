package tests;

import Pages.RegistrationFromPage;
import org.junit.jupiter.api.Test;

import java.io.File;


public class RegistrationFromTests extends TestBase{

    RegistrationFromPage registrationFromPage = new RegistrationFromPage();

    @Test
    void successfulTest() {
        String firstName = "Alex";
        String lastName = "Larin";

        registrationFromPage.OpenPage()
                .setFirstName(firstName)
                .setLastName(lastName)
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
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", "alexLar@gmail.com")
                .checkResult("Date of Birth", "10 April,1990");
    }
}