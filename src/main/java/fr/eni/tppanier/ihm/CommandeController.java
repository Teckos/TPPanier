package fr.eni.tppanier.ihm;

import fr.eni.tppanier.bll.ArticleManager;
import fr.eni.tppanier.bll.CommandeManager;
import fr.eni.tppanier.bo.Article;
import fr.eni.tppanier.bo.Commande;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
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
    HashMap<Article, Integer> getPanier() {
        return commandeManager.listerArticlesPanier();
    }


    @ModelAttribute("toutesLesCommandes")
    List<Commande> fetchAllCommande() {
        return commandeManager.getAllCommande();
    }

    @ModelAttribute("totalCommande")
    Double getTotal() {
        return commandeManager.calcul();
    }

    @GetMapping
    public String afficherCommandes(Model model) {
        return "commande";
    }

    @GetMapping("/nouvelle_commande")
    public String gererCommande(Model model, Commande commande) {
        return "nouvelle_commande";
    }

    @PostMapping("/nouvelle_commande/ajouter_article")
    public String ajouterArticle(Article article, BindingResult errors) {
        commandeManager.ajouterArticleAuPanier(article, 1);
        return "redirect:/commande/nouvelle_commande";
    }
    @GetMapping("/nouvelle_commande/supprimer_article/{id}")
    public String supprimerArticle(@PathVariable("id") Long id) {
        commandeManager.supprimerArticle(id);
        return "redirect:/commande/nouvelle_commande";
    }

    @PostMapping("/nouvelle_commande")
    public  String validerCommande(@Valid Commande commande, BindingResult errors) {
//        if(commandeManager.listerArticlesPanier().isEmpty()) {
//            return "nouvelle_commande";
//        }
        if(errors.hasErrors()) {
            return "nouvelle_commande";
        }
        try {
            commandeManager.savePanier(commande.getAdresse());
        } catch (Exception e) {
//TODO
            return "nouvelle_commande";
        }

        return "redirect:/commande";
    }



}
