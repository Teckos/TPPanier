package fr.eni.tppanier.ihm;

import fr.eni.tppanier.bll.CommandeException;
import fr.eni.tppanier.bll.CommandeManager;
import fr.eni.tppanier.bll.ERROR_CODES;
import fr.eni.tppanier.bll.GenericManager;
import fr.eni.tppanier.bo.Article;
import fr.eni.tppanier.bo.Commande;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/commande")
public class CommandeController {
    @Autowired
    CommandeManager commandeManager;
    @Autowired
    GenericManager<Article> articleManager;

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
        return commandeManager.getAll();
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
        commandeManager.supprimerArticleDuPanier(id);
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
        } catch (CommandeException e) {
            if(e.getErreurList().contains(ERROR_CODES.PANIER_VIDE)) {
                System.err.println("panier vide");
                errors.addError(new FieldError("commande", "panier", ERROR_CODES.PANIER_VIDE.getMessage() ));
            }
            return "nouvelle_commande";
        }

        return "redirect:/commande";
    }



}
