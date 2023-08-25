package fr.eni.tppanier.bll;

import fr.eni.tppanier.bo.Article;
import fr.eni.tppanier.bo.Commande;

public interface MagasinManager {
    public void createArticle(Article article);
    public void createCommande(Commande commande);
}
