package fr.eni.tppanier;

import fr.eni.tppanier.bll.ArticleManager;
import fr.eni.tppanier.bll.CommandeManager;
import fr.eni.tppanier.bo.Article;
import fr.eni.tppanier.bo.Categorie;
import fr.eni.tppanier.bo.Commande;
import fr.eni.tppanier.bo.LigneCommande;
import fr.eni.tppanier.dal.CommandeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TpPanierApplication implements CommandLineRunner {
    @Autowired
    ArticleManager articleManager;
    @Autowired
    CommandeManager commandeManager;
    @Autowired
    CommandeDAO commandeDAO;

    public static void main(String[] args) {
        SpringApplication.run(TpPanierApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Article ballon = Article.builder().nom("Ballon de foot").categorie(Categorie.SPORT).prix(10.).build();
        Article croquettes20L = Article.builder().nom("Croquettes chat 20L").categorie(Categorie.ANIMAUX).prix(40.).build();
        Article croquettes50L = Article.builder().nom("Croquettes chat 50L").categorie(Categorie.ANIMAUX).prix(60.).build();
        articleManager.save(ballon);
        articleManager.save(croquettes20L);
        articleManager.save(croquettes50L);

        commandeManager.ajouterArticleAuPanier(croquettes20L,2);
        commandeManager.ajouterArticleAuPanier(croquettes50L,1);
        commandeManager.ajouterArticleAuPanier(croquettes50L,1);
        commandeManager.savePanier("Commande de Lolo");
    }
}
