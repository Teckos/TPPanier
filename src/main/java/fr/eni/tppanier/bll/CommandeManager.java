package fr.eni.tppanier.bll;

import fr.eni.tppanier.bo.Article;
import fr.eni.tppanier.bo.Commande;
import fr.eni.tppanier.bo.LigneCommande;
import fr.eni.tppanier.ihm.CommandeDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

public interface CommandeManager extends SuperManager<Commande>{
//    public void save(Commande commande);
//
//    public List<Commande> getAll();

    @Transactional
    void savePanier(String adresse);

    public void valider(String string);

    void ajouterArticleAuPanier(Article article, Integer quantite);

    HashMap<Article,Integer> listerArticlesPanier();

    void supprimerArticleDuPanier(Long id);

    Double calcul();

}
