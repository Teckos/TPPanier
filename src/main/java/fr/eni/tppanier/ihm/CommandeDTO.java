package fr.eni.tppanier.ihm;

import fr.eni.tppanier.bo.Article;
import fr.eni.tppanier.bo.Commande;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CommandeDTO {
    List<Article> panier = new ArrayList<>();

    public void ajouterAuPanier(Article article) {
        this.panier.add(article);
    }

    public void supprimerDuPanier(Long id) {
        List<Article> lst = this.panier;
        this.panier=(lst.stream().filter(e -> !id.equals(e.getIdArticle())).toList());
    }

}
