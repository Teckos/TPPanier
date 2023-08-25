package fr.eni.tppanier.bll;

import fr.eni.tppanier.bo.Article;

import java.util.List;

public interface ArticleManager {
    public void save(Article article);
    public List<Article> getAll();

    void deleteById(Integer id);
}
