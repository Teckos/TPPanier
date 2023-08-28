package fr.eni.tppanier.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.Delegate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_article", nullable = false)
    private Long idArticle;

    @NotBlank(message = "Nom obligatoire")
    private String nom;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Categorie categorie;

    @Positive(message = "Le prix doit être positif")
    @NotNull(message = "Prix obligatoire")
    private Double prix;

//    @Delegate
//    @ToString.Exclude
//    @JsonIgnore
//    @Builder.Default
//    @ManyToMany (mappedBy = "articles")
////    @JoinTable(name = "article_commandes",
////            joinColumns = @JoinColumn(name = "id_article"),
////            inverseJoinColumns = @JoinColumn(name = "id_commande"))
//    private List<Commande> commandes = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Article article = (Article) o;
        return Objects.equals(idArticle, article.idArticle) &&
                Objects.equals(nom, article.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idArticle, nom);
    }

}