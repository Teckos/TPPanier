package fr.eni.tppanier.bll;

import java.util.List;

public interface GenericManager<T> {
    public void save(T t);
    public List<T> getAll();

    void deleteById(Integer id);
}
