package fr.eni.tppanier.bll;

import fr.eni.tppanier.bo.Erreur;
import fr.eni.tppanier.dal.ErreurDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ErreurManagerImpl implements SuperManager<Erreur> {
    @Autowired
    ErreurDAO erreurDAO;

    @Override
    public void save(Erreur erreur) {
        erreurDAO.save(erreur);
    }

    @Override
    public List<Erreur> getAll() {
        return (List<Erreur>) erreurDAO.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        erreurDAO.deleteById(id);
    }

}
