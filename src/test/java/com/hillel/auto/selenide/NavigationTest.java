package com.hillel.auto.selenide;

import com.codeborne.selenide.Condition;
import model.User;
import model.UserData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class NavigationTest extends TestBase{
    @BeforeMethod
    public void loginUser(){
        login();
    }
    @Test
    public void navigateToSettingsTest() {
        $(by("href", "#settings")).shouldBe(Condition.visible).click();
        $("h1").shouldHave(text("Your settings"));
    }

    @Test
    public void navigateToNewPostTest(){
        $(by("href", "#editor")).shouldBe(Condition.visible).click();
        $(byAttribute("placeholder","Article Title")).shouldBe(Condition.visible);
    }

    @Test
    public void navigateToProfileTest(){
        User user = UserData.defaultUser();
        $(by("href", "#@" + user.getUserName())).shouldBe(Condition.visible).click();
        $("h4").shouldHave(text(user.getUserName()));
    }
}
