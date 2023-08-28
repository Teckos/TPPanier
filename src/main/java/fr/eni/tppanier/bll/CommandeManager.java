package fr.eni.tppanier.bll;

import fr.eni.tppanier.bo.Article;
import fr.eni.tppanier.bo.Commande;
import fr.eni.tppanier.bo.LigneCommande;
import fr.eni.tppanier.ihm.CommandeDTO;

import java.util.HashMap;
import java.util.List;

public interface CommandeManager {
    public void save(Commande commande);
    public void valider(String string);
//    public void ajouterArticle(Article article);

    //    @Override
    //    public void ajouterArticle(Article article) {
    //        this.commandeDTO.ajouterAuPanier(article);
    //        article.add(commande);
    //    }

    //    @Override
    //    public void ajouterArticle(Article article) {
    //        this.commandeDTO.ajouterAuPanier(article);
    //        article.add(commande);
    //    }
    void ajouterArticleAuPanier(Article article, Integer quantite);

    public void ajouterPanier(CommandeDTO commandeDTO);

//    public List<Article> listerArticles();

    //    @Override
    //    public List<Article> listerArticles() {
    //        return commandeDTO.getPanier();
    //    }
    HashMap<Article,Integer> listerArticlesPanier();

    public List<Commande> getAllCommande();

    void supprimerArticle(Long id);

    Double calcul();

    public void ajouterLigne(LigneCommande ligne);

    public void savePanier();
}
