package pages;

import pages.components.CalenderComponent;
import pages.components.ResultsTableComponent;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFromPage {

    CalenderComponent calenderComponent = new CalenderComponent();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    public RegistrationFromPage openPage() {
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
        $("[id=userEmail]").setValue(value);
        return this;
    }

    public RegistrationFromPage setGenter(String Genter) {
        $("#genterWrapper").$(byText(Genter)).click();
        return this;
    }

    public RegistrationFromPage setUserNumber(String value) {
        $("[id=userNumber]").setValue(value);
        return this;
    }

    public RegistrationFromPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calenderComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFromPage setSubjects(String Subjects) {
        $("#subjectsInput").setValue(Subjects).pressEnter();

        return this;

    }

    public RegistrationFromPage setHobbies(String hobbyInput) {
        $("#hobbiesWrapper").$(byText(hobbyInput)).click();

        return this;
    }

    public RegistrationFromPage uploadImage(String upload) {
        $("#uploadPicture").uploadFile(new File(upload));
        $("#currentAddress-wrapper").click();

        return this;
    }

    public RegistrationFromPage setCurrentAddress(String value) {
        $("#currentAddress").setValue(value);
        $("#state").click();
        return this;
    }

    public RegistrationFromPage setStateState(String StateState) {
        $("#stateCity-wrapper").$(byText(StateState)).click();
        $("#city").click();
        return this;
    }

    public RegistrationFromPage setStateCity(String StateCity) {
        $("#stateCity-wrapper").$(byText(StateCity)).click();
        $("#submit").click();
        return this;
    }

    public RegistrationFromPage checkResult(String key, String value) {
        resultsTableComponent.checkResult(key, value);
        return this;
    }
}