package fr.eni.tppanier.dal;

import fr.eni.tppanier.bo.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleDAO extends CrudRepository<Article, Integer> {
}
