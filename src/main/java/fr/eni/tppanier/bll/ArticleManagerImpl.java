package fr.eni.tppanier.bll;

import fr.eni.tppanier.bo.Article;
import fr.eni.tppanier.dal.ArticleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleManagerImpl implements GenericManager<Article> {
    @Autowired
    ArticleDAO articleDAO;

    @Override
    public void save(Article article) {
        articleDAO.save(article);
    }

    @Override
    public List<Article> getAll() {
        return (List<Article>) articleDAO.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        articleDAO.deleteById(id);
    }

}
