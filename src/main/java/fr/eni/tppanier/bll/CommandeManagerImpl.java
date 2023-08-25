package fr.eni.tppanier.bll;

import fr.eni.tppanier.bo.Article;
import fr.eni.tppanier.bo.Commande;
import fr.eni.tppanier.dal.CommandeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Service
//@SessionScope
public class CommandeManagerImpl implements CommandeManager{
    @Autowired
    CommandeDAO commandeDAO;

    Commande commande = new Commande();

    @Override
    public void save(Commande commande) {
        commandeDAO.save(commande);
    }

    @Override
    public void ajouterArticle(Article article) {
        this.commande.add(article);
        article.add(commande);
    }

    @Override
    public List<Article> listerArticles() {
        return commande.getArticles();
    }

//    @Override
    public void valider(String adresse) {
        this.commande.setAdresse(adresse);
        commandeDAO.save(commande);
        this.commande = new Commande();
    }

}
