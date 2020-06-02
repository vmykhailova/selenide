package pageObjects;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage implements PageObject {

    private By signUpLink = byAttribute("href", "#register");
    private By userNameField = byCssSelector("input[type='text']");
    private By emailField = byCssSelector("input[type='email']");
    private By passwordField = byCssSelector("input[type='password']");
    private By signInBtn = byCssSelector("button[type='submit']");

    public RegistrationPage openPage() {
        $(signUpLink).shouldBe(Condition.visible).click();
        return this;
    }
    public void inputUserName(String username) {

        $(userNameField).setValue(username);
    }
    public void inputEmail(String email) {

        $(emailField).setValue(email);
    }
    public void inputPassword(String password) {
        $(passwordField).setValue(password);
    }
    public String getPageTitle() {
        return $(".auth-page h1").text();
    }

    public HomePage clickSingInButton() {
        $(signInBtn).click();
        return new HomePage();
    }
    public HomePage registration(String username, String email, String password) {
        inputUserName(username);
        inputEmail(email);
        inputPassword(password);
        return clickSingInButton();
    }
}


