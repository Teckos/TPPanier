package fr.eni.tppanier.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class LigneCommande {
    @Id
    @GeneratedValue
    private Integer idLigneCommande;

    @ManyToOne
    private Article article;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private Commande commande;

    private Integer quantite;

    public LigneCommande(Article article, Commande commande, Integer quantite) {
        this.article = article;
        this.commande = commande;
        this.quantite = quantite;
    }

    public Double totalLigne(){
        return this.quantite * this.article.getPrix();
    }
}
