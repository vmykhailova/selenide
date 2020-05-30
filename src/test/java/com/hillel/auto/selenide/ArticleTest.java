package com.hillel.auto.selenide;

import com.codeborne.selenide.Condition;
import model.Article;
import model.ArticleData;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.NewArticlePage;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class ArticleTest extends TestBase{
    Article article = ArticleData.createArticle();
    @Test(priority = 1)
    public void createArticleTest(){
        login();
        HomePage.goToNewPostPage();
        NewArticlePage newArticlePage = new NewArticlePage();
        $(by("placeholder", "Article Title")).setValue(article.getTitle());
        $(by("placeholder", "What's this article about?")).setValue(article.getDescription());
        $(by("placeholder", "Write your article (in markdown)")).setValue(article.getText());
        $(by("placeholder", "Enter tags")).setValue(article.getTags());
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
        $(by("placeholder", "Article Title")).setValue("Edited article");
        $(by("placeholder", "What's this article about?")).setValue("Edited article");
        $(by("placeholder", "Write your article (in markdown)")).setValue("Edited article");
        $(by("placeholder", "Enter tags")).setValue("Edited article");
        $("button.btn").click();
        $("h1").shouldHave(Condition.text("Edited article"));
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
