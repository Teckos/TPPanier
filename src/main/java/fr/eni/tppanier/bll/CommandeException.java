package fr.eni.tppanier.bll;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CommandeException extends Exception{
    private List<ERROR_CODES> erreurList = new ArrayList<>();
    public CommandeException(String message) {
        super(message);
    }
    public CommandeException(ERROR_CODES erreur) {
        this.erreurList.add(erreur);
    }
    public CommandeException(List<ERROR_CODES> erreurList) {
        this.erreurList.addAll(erreurList);
    }
}
