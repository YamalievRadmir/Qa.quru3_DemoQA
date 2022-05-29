package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulTest() {

        open("/automation-practice-form");

        $("[id=firstName]").setValue("Alex");
        $("[id=lastName]").setValue("Larin");
        $("[id=userEmail]").setValue("alexLar@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("[id=userNumber]").setValue("3748596032");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--010:nth-child(3)").click();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile (new File("src/test/java/resources/Screenshot_2.png"));
        $("#currentAddress-wrapper").click();
        $("#currentAddress").val("Lenina 5");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-content").shouldHave(text("Thanks for submitting the form"),
                text("alexLar@gmail.com"),
                text("alexLar@gmail.com"), text("Male"), text("3748596032"), text("Lenina 5"),
                text("10 April,1990"), text("Physics"), text("Reading"),
                text("Screenshot_2.png"), text("Lenina 5"), text("NCR Delhi"));
    }
}