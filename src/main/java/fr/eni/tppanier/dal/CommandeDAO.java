package fr.eni.tppanier.dal;

import fr.eni.tppanier.bo.Article;
import fr.eni.tppanier.bo.Commande;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommandeDAO extends CrudRepository<Commande, Integer> {

}
