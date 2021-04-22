package test.java.voiture.commentaire.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@ToString(exclude = "commentaireList")
public class Voiture extends CommonAttributeEntity<String> implements Serializable {

    private String matricule;

    @Enumerated(EnumType.STRING)
    private MarqueEnum marque;

    private Double vitesse;

    private int puissance;

    @JsonIgnore
    @OneToMany(mappedBy = "voiture")
    private List<Commentaire> commentaireList = new ArrayList<> ();

}
