package fr.eni.tppanier.ihm;

import fr.eni.tppanier.bll.ArticleManager;
import fr.eni.tppanier.bo.Article;
import fr.eni.tppanier.bo.Categorie;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleManager articleManager;

    @ModelAttribute("tousLesArticles")
    List<Article> fetchAllArticle() {
        return articleManager.getAll();
    }

    @ModelAttribute("toutesLesCategories")
    Categorie[] fetchAllCategories() {
        return Categorie.values();
    }


    @GetMapping
    public String gererArticle(Model model, Article article) {
        return "article";
    }

    @PostMapping
    public String createValid(@Valid Article article, BindingResult errors) {
        if(errors.hasErrors()) {
            return "article";
        }
        try {
            articleManager.save(article);
        } catch (Exception e) {
//TODO
        }
        return "redirect:/article";

    }

    @GetMapping("/supprimer/{id}")
    public String delete(@PathVariable("id") Integer id) {
        articleManager.deleteById(id);
        return "redirect:/article";
    }

}
