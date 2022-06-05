package Pages;

import Pages.components.CalenderComponent;
import Pages.components.ResultsTableComponent;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFromPage {

    CalenderComponent calenderComponent = new CalenderComponent();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    public RegistrationFromPage setOpenPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationFromPage setFirstName(String value) {
        $("[id=firstName]").setValue(value);
        return this;
    }

    public RegistrationFromPage setLastName(String value) {
        $("[id=lastName]").setValue(value);
        return this;
    }

    public RegistrationFromPage setUserEmail(String value) {
        $("[id=userEmail]").setValue("alexLar@gmail.com");
        return this;
    }

    public RegistrationFromPage setGenterWrapper(String value) {
        $("#genterWrapper").$(byText("Male")).click();
        return this;
    }

    public RegistrationFromPage setUserNumber(String value) {
        $("[id=userNumber]").setValue("3748596032");
        return this;
    }

    public RegistrationFromPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calenderComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFromPage setSubjects(String value) {
        $("#subjectsInput").setValue("Physics").pressEnter();

        return this;

    }

    public RegistrationFromPage setHobbies(String value) {
        $("#hobbiesWrapper").$(byText("Reading")).click();

        return this;
    }

    public RegistrationFromPage setLoadPicture(String value) {
        $("#uploadPicture").uploadFile(new File("src/test/java/resources/Screenshot_2.png"));
        $("#currentAddress-wrapper").click();

        return this;
    }

    public RegistrationFromPage setCurrentAddress(String value) {
        $("#currentAddress").val("Lenina 5");
        $("#state").click();
        return this;
    }

    public RegistrationFromPage setStateCity(String value) {
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        return this;
    }

    public RegistrationFromPage setStateCity2(String value) {
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        return this;
    }

    public RegistrationFromPage checkResult(String key, String value) {
        resultsTableComponent.checkResult(key, value);
        return this;
    }
}