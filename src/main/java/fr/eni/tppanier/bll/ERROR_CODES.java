package fr.eni.tppanier.bll;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ERROR_CODES {
    PANIER_VIDE("100", "Le panier est vide !"),
    STOCK_NUL("200", "Out of stock"),
    ;
    private String code;
    private String message;

}
