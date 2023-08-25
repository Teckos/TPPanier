package fr.eni.tppanier.ihm;

import fr.eni.tppanier.bll.ArticleManager;
import fr.eni.tppanier.bll.CommandeManager;
import fr.eni.tppanier.bo.Article;
import fr.eni.tppanier.bo.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/commande")
public class CommandeController {
    @Autowired
    CommandeManager commandeManager;
    @Autowired
    ArticleManager articleManager;

    @ModelAttribute("tousLesArticles")
    List<Article> fetchAllArticle() {
        return articleManager.getAll();
    }

    @ModelAttribute("panier")
    List<Article> getPanier() {
        return commandeManager.listerArticles();
    }

    @GetMapping
    public String gererCommande(Model model, Commande commande) {
//        List<Article> articleList = new ArrayList<>();
//        model.addAttribute("articleList",articleList);
        return "commande";
    }

    @PostMapping("/ajouter_article")
    public String ajouterArticle(Article article, BindingResult errors) {
        System.err.println(article);
        commandeManager.ajouterArticle(article);
        return "redirect:/commande";
    }

    @PostMapping("/valider")
    public  String validerCommande(Commande commande, BindingResult errors) {
        commande.setArticles(getPanier());
        commandeManager.valider(commande.getAdresse());

        System.err.println(commande);
        return "redirect:/commande";
    }

}
