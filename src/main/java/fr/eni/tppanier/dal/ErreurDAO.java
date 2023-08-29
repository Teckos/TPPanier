package fr.eni.tppanier.dal;

import fr.eni.tppanier.bo.Erreur;
import org.springframework.data.repository.CrudRepository;

public interface ErreurDAO extends CrudRepository<Erreur, Integer> {
}
