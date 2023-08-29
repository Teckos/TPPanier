package fr.eni.tppanier.ws;

import fr.eni.tppanier.bll.CommandeManager;
import fr.eni.tppanier.bll.GenericManager;
import fr.eni.tppanier.bo.Article;
import fr.eni.tppanier.bo.Categorie;
import fr.eni.tppanier.bo.Commande;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class commandeWS {
    @Autowired
    CommandeManager manager;
    @Autowired
    GenericManager<Article> articleManager;

    @PostConstruct
    public void init(){
                Article ballon = Article.builder().nom("Ballon de foot").categorie(Categorie.SPORT).prix(10.).build();
        Article croquettes20L = Article.builder().nom("Croquettes chat 20L").categorie(Categorie.ANIMAUX).prix(40.).build();
        Article croquettes50L = Article.builder().nom("Croquettes chat 50L").categorie(Categorie.ANIMAUX).prix(60.).build();
        articleManager.save(ballon);
        articleManager.save(croquettes20L);
        articleManager.save(croquettes50L);
//
    }
    @GetMapping
    public List<Commande> getAllCommade() {
        return manager.getAll();
    }

}
