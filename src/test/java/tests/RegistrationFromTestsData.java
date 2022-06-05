package tests;

import Pages.RegistrationFromPage;
import org.junit.jupiter.api.Test;

import java.io.File;

import static utils.RandomUtils.*;


public class RegistrationFromTestsData extends TestBase{

    RegistrationFromPage registrationFromPage = new RegistrationFromPage();

    @Test
    void successfulTest() {
        String firstName = getRandomString(10);
        String lastName = getRandomMessage(10, 100);
        //String email = getRandomEmail();

        registrationFromPage.setOpenPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail("alexLar@gmail.com")
                .setGenterWrapper("Male")
                .setUserNumber("3748596032")
                .setDateOfBirth("10", "April", "1990")
                .setSubjects("Physics")
                .setHobbies("Reading")
                .setLoadPicture(String.valueOf(new File("src/test/java/resources/Screenshot_2.png")))
                .setCurrentAddress("Lenina 5")
                .setStateCity("NCR")
                .setStateCity2("Delhi")
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", "alexLar@gmail.com")
                .checkResult("Date of Birth", "10 April,1990");
    }
}