package com.hillel.auto.selenide;

import model.User;
import com.codeborne.selenide.Configuration;
import model.UserData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.LoginPage;

import java.net.MalformedURLException;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    User user = UserData.defaultUser();
    private LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void setUp() throws MalformedURLException {

        Configuration.baseUrl = "https://react-redux.realworld.io/";
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "83.0";

        open(Configuration.baseUrl);
    }

    @AfterMethod
    public void down(){

    }

    public void login() {
        loginPage
                .openPage()
                .login(user.getEmail(), user.getPassword())
                .userShouldBeLoggedIn(user.getUserName());
    }
}
