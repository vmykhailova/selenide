package com.hillel.auto.selenide;

import com.codeborne.selenide.Condition;
import config.ArticleConfiguration;
import model.Article;
import model.ArticleData;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class ArticleTest extends TestBase{
    Article article = ArticleData.createArticle();
    private ArticleConfiguration articleConfiguration = ConfigFactory.create(ArticleConfiguration.class);
    @Test(priority = 1)
    public void createArticleTest(){
        login();
        HomePage.goToNewPostPage();
        $(by("placeholder", "Article Title"))
                .setValue(articleConfiguration.title());
        $(by("placeholder", "What's this article about?"))
                .setValue(articleConfiguration.description());
        $(by("placeholder", "Write your article (in markdown)"))
                .setValue(articleConfiguration.text());
        $(by("placeholder", "Enter tags"))
                .setValue(articleConfiguration.tags());
        $(by("type", "button")).click();
        $("h1").shouldHave(Condition.text(article.getTitle()));
    }

    @Test(priority = 2)
    public void editArticleTest(){
        login();
        $(by("href", "#@" + user.getUserName())).click();
        $("h1").click();
        $(byClassName("ion-edit")).click();
        $(by("placeholder", "Article Title")).clear();
        $(by("placeholder", "Article Title"))
                .setValue(articleConfiguration.editedTitle());
        $(by("placeholder", "What's this article about?"))
                .setValue(articleConfiguration.editedDescription());
        $(by("placeholder", "Write your article (in markdown)"))
                .setValue(articleConfiguration.editedText());
        $(by("placeholder", "Enter tags"))
                .setValue(articleConfiguration.editedTags());
        $("button.btn").click();
        $("h1").shouldHave(Condition.text("Edit article"));
    }

    @Test(priority = 3)
    public void deleteArticleTest(){
        login();
        $(by("href", "#@" + user.getUserName())).click();
        $("h1").click();
        $(byClassName("ion-trash-a")).click();
        $(byClassName("article-preview")).shouldHave(Condition.text("No articles are here... yet."));
    }
}
