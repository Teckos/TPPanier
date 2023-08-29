package fr.eni.tppanier.ws;

import fr.eni.tppanier.bll.CommandeManager;
import fr.eni.tppanier.bo.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class commandeWS {
    @Autowired
    CommandeManager manager;

    @GetMapping
    public List<Commande> getAllCommade() {
        return manager.getAll();
    }

}
