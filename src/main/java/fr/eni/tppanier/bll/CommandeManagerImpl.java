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
        this.commandeDTO.modifierPanier(article, quantite);
        System.out.println("J'ajoute "+quantite+" "+article.getNom() );
    }

    @Override
    public void ajouterPanier(CommandeDTO commandeDTO) {
//        this.commande.setPanier(commandeDTO.getPanier());
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
        this.commandeDTO.supprimerDuPanier(id);
    }

//    @Override
//    public void supprimerArticle(Long id) {
//        List<Article> lst = this.commande.getArticles();
//        this.commande.setArticles(lst.stream().filter(e -> !id.equals(e.getIdArticle())).collect(Collectors.toList()));
//    }

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
    public void savePanier(String adresse) {
        commandeDTO.getPanier().forEach((article, quantite) -> {
            LigneCommande l = new LigneCommande(article, commande,quantite);
            commande.getPanier().add(l);
            ligneCommandeDAO.save(l);
            System.out.println(commande);
        });
        this.valider(adresse);
    }

    //    @Override
    public void valider(String adresse) {
        this.commande.setAdresse(adresse);
        System.err.println(adresse);
        commandeDAO.save(commande);
        System.err.println(commande);
        System.err.println(this.listerArticlesPanier().keySet());

        this.commande = new Commande();
        this.commandeDTO = new CommandeDTO();
    }

}
