package org.example.service.Service;

import org.example.service.Model.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ArticleService {

    ArrayList<Article>articles=new ArrayList<>();

    public ArrayList<Article>getArticles(){
        return articles;
    }

    public void addArticle(Article article){
        articles.add(article);
    }

    public boolean updateArticle(int id, Article article){
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getId()==id){
                articles.set(i,article);
                return true;
            }
        }
        return false;
    }

    public boolean deleteArticle(int id){
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getId()==id){
                articles.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean publish(int id){
        LocalDate publishDate=LocalDate.now();
        for (Article article:articles) {
           if (article.getId()==id){
               article.setPublished(true);
               article.setPublishDate(publishDate);
               return true;
           }
        }
        return false;
    }

    public ArrayList<Article> isPublished(boolean isPublish){
        ArrayList<Article>published=new ArrayList<>();
        if (!isPublish) {
            return null;
        }
        for (Article article:articles){
            if (article.isPublished()){
                article.setPublished(isPublish);
                published.add(article);
            }
        }
        return published;
    }

    public ArrayList<Article> getByCategory(String category) {
        ArrayList<Article> byCategory = new ArrayList<>();
        boolean found = false;
        for (Article article : articles) {
            if (article.getCategory().equalsIgnoreCase(category)) {
                byCategory.add(article);
                found = true;
            }
        }
        if (!found) {
            return null;
        }
        return byCategory;
    }


}
