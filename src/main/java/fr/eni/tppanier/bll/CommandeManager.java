package fr.eni.tppanier.bll;

import fr.eni.tppanier.bo.Article;
import fr.eni.tppanier.bo.Commande;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

public interface CommandeManager extends GenericManager<Commande> {
//    public void save(Commande commande);
//
//    public List<Commande> getAll();

    @Transactional
    void savePanier(String adresse) throws CommandeException;

    public void valider(String string);

    void ajouterArticleAuPanier(Article article, Integer quantite);

    HashMap<Article,Integer> listerArticlesPanier();

    void supprimerArticleDuPanier(Long id);

    Double calcul();

}
