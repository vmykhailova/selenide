package com.hillel.auto.selenide;

import model.User;
import com.codeborne.selenide.Configuration;
import model.UserData;
import org.testng.annotations.BeforeMethod;
import pageObjects.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    User user = UserData.defaultUser();
    private LoginPage loginPage = new LoginPage();
    static {
        Configuration.baseUrl = "https://react-redux.realworld.io/";
    }

    @BeforeMethod
    public void setUp() {
        open(Configuration.baseUrl);
    }
    public void login() {
        loginPage
                .openPage()
                .login(user.getEmail(), user.getPassword())
                .userShouldBeLoggedIn(user.getUserName());
    }
}
