package com.hillel.auto.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import config.UserConfiguration;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginTest extends TestBase {
    private UserConfiguration userConfiguration = ConfigFactory.create(UserConfiguration.class);
    private LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void setUp() {
        open(Configuration.baseUrl);
    }

    @Test
    public void openPage() {
        $(byAttribute("href", "#login")).shouldBe(Condition.visible).click();
    }

    @Test
    public void loginTest() {
        String userName = userConfiguration.name();
        String email = userConfiguration.email();
        String password = userConfiguration.password();

        loginPage
                .openPage()
                .login(email, password)
                .userShouldBeLoggedIn(userName);
    }

    @Test
    public void logoutTest(){
        login();
        $(by("href", "#settings")).shouldBe(Condition.visible).click();
        $(byText("Or click here to logout.")).scrollTo().click();
        $("[href='#login']").shouldBe(Condition.visible);
    }
}
