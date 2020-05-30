package model;

public class ArticleData {
    public static Article createArticle(){
        return new Article(
                "Test article",
                "it is Viktorias test article",
                "Lorem ipsum dolar blablabla",
                "test Vika homework selenide"
                );
    }
}
