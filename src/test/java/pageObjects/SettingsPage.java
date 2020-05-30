package pageObjects;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class SettingsPage implements PageObject{
    private By settingsLink = byAttribute("href", "#settings");

    public SettingsPage openPage() {
        $(settingsLink).shouldBe(Condition.visible).click();
        return this;
    }
}
