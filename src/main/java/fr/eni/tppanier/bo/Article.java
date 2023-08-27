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

    @Delegate
    @ToString.Exclude
    @JsonIgnore
    @Builder.Default
    @ManyToMany (mappedBy = "articles")
//    @JoinTable(name = "article_commandes",
//            joinColumns = @JoinColumn(name = "id_article"),
//            inverseJoinColumns = @JoinColumn(name = "id_commande"))
    private List<Commande> commandes = new ArrayList<>();


}