package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationFromPage;

import java.io.File;

import static utils.RandomUtils.getRandomPhone;


public class RegistrationFromTestsDataWithFaker extends TestBase{

    RegistrationFromPage registrationFromPage = new RegistrationFromPage();

    Faker faker = new Faker();
    String firstName = faker.address().firstName();
    String lastName = faker.address().lastName();
    String email = faker.internet().emailAddress();
    String currentAddress = faker.address().fullAddress();
    String genter = "Male";
    String userNumber = getRandomPhone();
    //String email = getRandomEmail();

    @Test
    void successfulTest() {


        registrationFromPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(genter)
                .setUserNumber(userNumber)
                .setDateOfBirth("10", "April", "1990")
                .setSubjects("Physics")
                .setHobbies("Reading")
                .uploadImage(String.valueOf(new File("src/test/resources/Screenshot_2.png")))
                .setCurrentAddress(currentAddress)
                .setState("NCR")
                .setCity("Delhi")
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", "Male")
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", "10 April,1990")
                .checkResult("Subjects", "Physics")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "Screenshot_2.png")
                .checkResult("Address", currentAddress)
                .checkResult("State and City", "NCR Delhi");
    }
}