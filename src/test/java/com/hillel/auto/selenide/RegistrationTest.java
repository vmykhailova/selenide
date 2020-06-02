package com.hillel.auto.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import model.User;
import model.UserData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationTest extends TestBase {

    User user = UserData.randomUser();
    private RegistrationPage registrationPage = new RegistrationPage();

    @BeforeMethod
    public void setUp() {
        open(Configuration.baseUrl);
    }
    @Test
    public void openPage() {
        $(byAttribute("href", "#register")).shouldBe(Condition.visible).click();
    }
    @Test
    public void registerTest() {
        String userName = user.getUserName();
        String email = user.getEmail();
        String password = user.getPassword();

        registrationPage
                .openPage()
                .registration(userName, email, password)
                .userShouldBeLoggedIn(userName);
    }
}
