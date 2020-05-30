package com.hillel.auto.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginTest extends TestBase {

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
        String userName = "realapp";
        String email = "realapp@mail.com";
        String password = "qwerty123";

        loginPage
                .openPage()
                .login(email, password)
                .userShouldBeLoggedIn(userName);
    }

    @Test
    public void logoutTest(){
        login();
        $(by("href", "#settings")).shouldBe(Condition.visible).click();
//        $x("//button[@class=\"btn btn-outline-danger\"]").click();
        $(byText("Or click here to logout.")).click();
        $("[href='#login']").shouldBe(Condition.visible);

    }

}
