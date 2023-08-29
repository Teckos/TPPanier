package fr.eni.tppanier.bll;

import fr.eni.tppanier.bo.Article;

import java.util.List;

public interface SuperManager <T> {
    public void save(T t);
    public List<T> getAll();

    void deleteById(Integer id);
}
