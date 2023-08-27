package fr.eni.tppanier.ihm;

import fr.eni.tppanier.bo.Article;
import fr.eni.tppanier.bo.Commande;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class CommandeDTO {
    HashMap<Article, Integer> panier = new HashMap<>();

    public void ajouterAuPanier(Article article, Integer quantite) {
        this.panier.compute(article, (k,v) -> {
            if(v != null) {
                return v + quantite;
            } else {
                return v;
            }
        });
    }

    public void supprimerDuPanier(Long id) {
//        List<Article> lst = this.panier;
//        this.panier=(lst.stream().filter(e -> !id.equals(e.getIdArticle())).toList());
//        this.panier.compute(article, (k,v) -> {
//            if(v != null) {
//                return v - 1;
//            } else {
//                return v;
//            }
//        });
    }

}
