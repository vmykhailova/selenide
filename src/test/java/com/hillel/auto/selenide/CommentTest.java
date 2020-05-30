package com.hillel.auto.selenide;

import org.testng.annotations.Test;
import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.*;

public class CommentTest extends TestBase {
    @Test
    public void createCommentTest(){
        login();
        $(by("class","tag-default tag-pill")).click();
        $("h1").click();
        $(by("placeholder", "Write a comment...")).setValue("Test comment by Vikki");
        $(by("type", "submit")).click();
        $(byClassName("card-text")).shouldHave(Condition.text("Test comment by Vikki"));
    }
}
