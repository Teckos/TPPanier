package fr.eni.tppanier.bll;

import fr.eni.tppanier.bo.Article;
import fr.eni.tppanier.bo.Commande;

import java.util.List;

public interface CommandeManager {
    public void save(Commande commande);
    public void valider(String string);
    public void ajouterArticle(Article article);

    public List<Article> listerArticles();

}
