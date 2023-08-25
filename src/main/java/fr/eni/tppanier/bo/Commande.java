package fr.eni.tppanier.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.Delegate;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "commande")
public class Commande {
    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_commande", nullable = false)
    private Long idCommande;

    @ToString.Include
    @NotBlank(message = "Adresse obligatoire")
    private String adresse;

    //    @ToString.Exclude
    @Delegate
    @ManyToMany(mappedBy = "commandes")
    private List<Article> articles = new ArrayList<>();

}