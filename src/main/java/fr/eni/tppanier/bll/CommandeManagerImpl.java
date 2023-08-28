package fr.eni.tppanier.bll;

import fr.eni.tppanier.bo.Article;
import fr.eni.tppanier.bo.Commande;
import fr.eni.tppanier.bo.LigneCommande;
import fr.eni.tppanier.dal.ArticleDAO;
import fr.eni.tppanier.dal.CommandeDAO;
import fr.eni.tppanier.dal.LigneCommandeDAO;
import fr.eni.tppanier.ihm.CommandeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
//@SessionScope
public class CommandeManagerImpl implements CommandeManager{
    @Autowired
    CommandeDAO commandeDAO;
    @Autowired
    ArticleDAO articleDAO;
    @Autowired
    LigneCommandeDAO ligneCommandeDAO;

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
    public void ajouterArticleAuPanier(Article article, Integer quantite) {
//        this.commande.add(article);
        this.commandeDTO.ajouterAuPanier(article, quantite);
    }

    @Override
    public void ajouterPanier(CommandeDTO commandeDTO) {
//        this.commande.setArticles(commandeDTO.getPanier());
    }

//    @Override
//    public List<Article> listerArticles() {
//        return commandeDTO.getPanier();
//    }
    @Override
    public HashMap<Article,Integer> listerArticlesPanier() {
        return commandeDTO.getPanier();
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
//        List<Article> lst = this.commande.getArticles();
//        this.commande.setArticles(lst.stream().filter(e -> !id.equals(e.getIdArticle())).collect(Collectors.toList()));
    }

    @Override
    public Double calcul() {
        return this.commande.getTotal();
    }

    @Override
    public void ajouterLigne(LigneCommande ligne) {

        this.ligneCommandeDAO.save(ligne);
    }

    @Override
    @Transactional
    public void savePanier() {
        commandeDTO.getPanier().forEach((article, quantite) -> {
            //Save ligneCommande
            LigneCommande l = new LigneCommande(article, quantite);
            System.out.println(l);
            commande.getPanier().add(l);
            //commandeDAO.save(commande);
            //Save ligneCommande dans Commande
            l.setCommande(commande);
            ligneCommandeDAO.save(l);
        });
//        System.out.println(commande.getPanier());
//        commandeDAO.save(commande);
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
