package fr.eni.tppanier.bll;

import fr.eni.tppanier.bo.Article;
import fr.eni.tppanier.bo.Commande;
import fr.eni.tppanier.bo.LigneCommande;
import fr.eni.tppanier.ihm.CommandeDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

public interface CommandeManager {
    public void save(Commande commande);

    @Transactional
    void savePanier(String adresse);

    public void valider(String string);

    void ajouterArticleAuPanier(Article article, Integer quantite);

    public void ajouterPanier(CommandeDTO commandeDTO);

    HashMap<Article,Integer> listerArticlesPanier();

    public List<Commande> getAllCommande();

    void supprimerArticle(Long id);

    Double calcul();

    public void ajouterLigne(LigneCommande ligne);

}
