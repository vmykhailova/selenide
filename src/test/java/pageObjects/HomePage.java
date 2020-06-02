package pageObjects;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class HomePage implements PageObject{
    public HomePage userShouldBeLoggedIn(String userName) {
        $("[href='#@" +userName+"']").shouldBe(Condition.visible.because("model.User not logged in!"));
        return this;
    }

    public static void goToNewPostPage(){
        $(by("href", "#editor")).shouldBe(Condition.visible).click();
    }
}
