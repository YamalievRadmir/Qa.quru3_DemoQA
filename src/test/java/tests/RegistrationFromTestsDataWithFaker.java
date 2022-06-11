package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationFromPage;

import java.io.File;


public class RegistrationFromTestsDataWithFaker extends TestBase{

    RegistrationFromPage registrationFromPage = new RegistrationFromPage();

    Faker faker = new Faker();
    String firstName = faker.address().firstName();
    String lastName = faker.address().lastName();
    String email = faker.internet().emailAddress();
    String currentAddress = faker.address().fullAddress();
    //String lastName = getRandomMessage(10, 100);
    //String email = getRandomEmail();

    @Test
    void successfulTest() {


        registrationFromPage.OpenPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGenter("Male")
                .setUserNumber("3748596032")
                .setDateOfBirth("10", "April", "1990")
                .setSubjects("Physics")
                .setHobbies("Reading")
                .setLoadPicture(String.valueOf(new File("src/test/resources/Screenshot_2.png")))
                .setCurrentAddress(currentAddress)
                .setStateCity("NCR")
                .setStateCity2("Delhi")
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Date of Birth", "10 April,1990");
    }
}