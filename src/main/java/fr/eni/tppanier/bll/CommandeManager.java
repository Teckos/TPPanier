package fr.eni.tppanier.bll;

import fr.eni.tppanier.bo.Article;
import fr.eni.tppanier.bo.Commande;
import fr.eni.tppanier.ihm.CommandeDTO;

import java.util.List;

public interface CommandeManager {
    public void save(Commande commande);
    public void valider(String string);
    public void ajouterArticle(Article article);

    public void ajouterPanier(CommandeDTO commandeDTO);

    public List<Article> listerArticles();

    public List<Commande> getAllCommande();

    void supprimerArticle(Long id);

    Double calcul();
}
