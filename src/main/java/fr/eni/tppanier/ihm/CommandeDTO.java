package fr.eni.tppanier.ihm;

import fr.eni.tppanier.bo.Article;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@Data
@NoArgsConstructor
public class CommandeDTO {
    HashMap<Article, Integer> panier = new HashMap<>();

    public void modifierPanier(Article article, Integer quantite) {
        if(this.panier.containsKey(article)) {
            if(this.panier.get(article)+quantite==0) {
                this.panier.remove(article);
            }else {
                this.panier.put(article,(this.panier.get(article)+quantite));
            }
        } else {
            this.panier.put(article,quantite);
        }

    }

    public void supprimerDuPanier(Long id) {
        Article articleSelectionne = panier.keySet().stream().filter(a->a.getIdArticle().equals(id)).findFirst().orElse(null);
//        System.out.println(articleSelectionne);
        modifierPanier(articleSelectionne,-1);

    }

}
