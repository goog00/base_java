package com.sunteng.java8.stream;

import com.sunteng.java8.model.Article;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by ST on 2017/8/16.
 */
public class ArtticleStreamTest {

    static List<Article> articles = new ArrayList<>();
    static {

        Article article = new Article("java think","zhangsan", Arrays.asList("java","c#"));
        articles.add(article);
        Article article2 = new Article("C#","zhangsan2", Arrays.asList("c#"));
        Article article3 = new Article("think","zhangsan3", Arrays.asList("java","c#"));
        articles.add(article2);
        articles.add(article3);
    }

    public static void main(String[] args) {
        Optional<Article> article = getFirstJavaArticle();
        Article article1 = article.get();
        System.out.println(article1.getTitle());

        List<Article> list = getAllJavaArticles();
        System.out.println(list);
    }

    public static Optional<Article> getFirstJavaArticle(){
        return articles.stream().filter(article -> article.getTags().contains("java")).findFirst();
    }
    public static List<Article> getAllJavaArticles(){
        return articles.stream().filter(article -> article.getTags().contains("java")).collect(Collectors.toList());
    }

    public static Map<String,List<Article>> groupByAuthor(){
        return articles.stream().collect(Collectors.groupingBy(Article::getAuthor));
    }


}
