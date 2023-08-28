package fr.eni.tppanier.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.Delegate;

import java.util.*;
import java.util.stream.Collectors;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "commande")
public class Commande {
//    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_commande", nullable = false)
    private Long idCommande;

//    @ToString.Include
    @NotBlank(message = "Adresse obligatoire")
    private String adresse;


//    //    @ToString.Include
//    @Delegate
//    @Builder.Default
//    @ManyToMany/*(mappedBy = "commandes")*/
////    @NotEmpty(message = "La liste ne peut être nulle")
//    private List<Article> articles = new ArrayList<>();

    @OneToMany(mappedBy = "commande")
//    @ToString.Exclude
    @Builder.Default
    @Delegate
    private Set<LigneCommande> panier = new HashSet<>();

    public Double getTotal(){
//        Double sum = this.articles.stream().mapToDouble(Article::getPrix)
//                .sum();
        return 0.0;
    }
//    public Double getTotal(){
////        Double sum = this.articles.stream().mapToDouble(Article::getPrix)
////                .sum();
//        return this.articles.stream().mapToDouble(Article::getPrix)
//                .sum();
//    }



//    @Override
//    public String toString(){
//        StringBuilder sb = new StringBuilder();
//        sb.append(this.idCommande);
//        sb.append(this.adresse);
//        return sb.toString();
//    }

}