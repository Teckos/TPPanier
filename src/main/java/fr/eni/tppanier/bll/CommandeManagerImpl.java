package fr.eni.tppanier.bll;

import fr.eni.tppanier.bo.Article;
import fr.eni.tppanier.bo.Commande;
import fr.eni.tppanier.dal.CommandeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeManagerImpl implements CommandeManager{
    @Autowired
    CommandeDAO commandeDAO;
    @Override
    public void save(Commande commande) {
        commandeDAO.save(commande);
    }

    @Override
    public void ajouterArticle(Commande commande, Article article) {
        commande.add(article);
        article.add(commande);

    }

    @Override
    public List<Article> listerArticles(Commande commande) {
        return commande.getArticles();
    }
}
