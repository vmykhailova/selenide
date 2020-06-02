package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:test.properties",
        "system:properties",
        "system:env"})
public interface ArticleConfiguration extends Config {
    @Config.Key("article.title")
    String title();
    @Config.Key("article.description")
    String description();
    @Config.Key("article.text")
    String text();
    @Config.Key("article.tags")
    String tags();

    @Config.Key("article.editedTitle")
    String editedTitle();
    @Config.Key("article.editedDescription")
    String editedDescription();
    @Config.Key("article.editedText")
    String editedText();
    @Config.Key("article.editedTags")
    String editedTags();
}
