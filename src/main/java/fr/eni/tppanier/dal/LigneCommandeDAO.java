package fr.eni.tppanier.dal;

import fr.eni.tppanier.bo.LigneCommande;
import org.springframework.data.repository.CrudRepository;

public interface LigneCommandeDAO extends CrudRepository<LigneCommande, Integer> {
}
