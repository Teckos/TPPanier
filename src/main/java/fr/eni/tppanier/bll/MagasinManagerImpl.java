package fr.eni.tppanier.bll;

import fr.eni.tppanier.bo.Article;
import fr.eni.tppanier.bo.Commande;
import fr.eni.tppanier.dal.ArticleDAO;
import fr.eni.tppanier.dal.CommandeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MagasinManagerImpl implements MagasinManager{
    @Autowired
    ArticleDAO articleDAO;
    @Autowired
    CommandeDAO commandeDAO;

    @Override
    public void createArticle(Article article) {
        articleDAO.save(article);
    }

    @Override
    public void createCommande(Commande commande) {
        commandeDAO.save(commande);
    }
}
