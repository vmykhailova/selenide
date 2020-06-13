package config;

import org.aeonbits.owner.Config;

/**
 * Created by alpa on 5/28/20
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env"})
public interface BrowserConfiguration extends Config {

    @DefaultValue("com.hillel.auto.selenide.example.providers.ChromeWebDriverProvider")
    @Key("remote.browser")
    String remoteChrome();
    @DefaultValue("com.hillel.auto.selenide.example.providers.FirefoxWebDriverProvider")
    @Key("remote.firefox")
    String remoteFirefox();

    @Key("browser.version")
    String browserVersion();
}
