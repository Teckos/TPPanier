package fr.eni.tppanier.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Erreur {
    @Id
    @GeneratedValue
    private Integer idErreur;

    private String code;
    private String message;
}
