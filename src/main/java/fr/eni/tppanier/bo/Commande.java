package fr.eni.tppanier.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.Delegate;
import org.hibernate.proxy.HibernateProxy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
@Table(name = "commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_commande", nullable = false)
    private Long idCommande;

    @NotBlank(message = "Adresse obligatoire")
    private String adresse;

    @OneToMany(mappedBy = "commande")
    @Builder.Default
    @Delegate
    private Set<LigneCommande> panier = new HashSet<>();

    public Double getTotal(){
        Double totalPanier = 0.0;
        for (LigneCommande ligne: panier) {
            totalPanier += ligne.totalLigne();

        }
        return totalPanier;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Commande commande = (Commande) o;
        return getIdCommande() != null && Objects.equals(getIdCommande(), commande.getIdCommande());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}