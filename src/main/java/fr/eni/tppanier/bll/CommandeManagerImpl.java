package fr.eni.tppanier.bll;

import fr.eni.tppanier.bo.Article;
import fr.eni.tppanier.bo.Commande;
import fr.eni.tppanier.dal.ArticleDAO;
import fr.eni.tppanier.dal.CommandeDAO;
import fr.eni.tppanier.ihm.CommandeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
//@SessionScope
public class CommandeManagerImpl implements CommandeManager{
    @Autowired
    CommandeDAO commandeDAO;
    @Autowired
    ArticleDAO articleDAO;

    Commande commande = new Commande();
    CommandeDTO commandeDTO = new CommandeDTO();

    @Override
    public void save(Commande commande) {
        commandeDAO.save(commande);
    }

//    @Override
//    public void ajouterArticle(Article article) {
//        this.commandeDTO.ajouterAuPanier(article);
//        article.add(commande);
//    }
    @Override
    public void ajouterArticle(Article article) {
        this.commande.add(article);
        article.add(commande);
    }

    @Override
    public void ajouterPanier(CommandeDTO commandeDTO) {
        this.commande.setArticles(commandeDTO.getPanier());
    }

//    @Override
//    public List<Article> listerArticles() {
//        return commandeDTO.getPanier();
//    }
    @Override
    public List<Article> listerArticles() {
        return commande.getArticles();
    }

    @Override
    public List<Commande> getAllCommande() {
        return (List<Commande>) commandeDAO.findAll();
    }

//    @Override
//    public void supprimerArticle(Long id) {
//        this.commandeDTO.supprimerDuPanier(id);
//    }
    @Override
    public void supprimerArticle(Long id) {
        List<Article> lst = this.commande.getArticles();
        this.commande.setArticles(lst.stream().filter(e -> !id.equals(e.getIdArticle())).collect(Collectors.toList()));
    }

    @Override
    public Double calcul() {
        return this.commande.getTotal();
    }

//    @Override
    public void valider(String adresse) {
        this.commande.setAdresse(adresse);
        System.err.println(adresse);
//        this.commande.setArticles(this.commandeDTO.getPanier());
        commandeDAO.save(commande);
        System.err.println(commande);

        this.commande = new Commande();
    }

}
