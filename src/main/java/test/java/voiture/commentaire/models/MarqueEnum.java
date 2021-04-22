package test.java.voiture.commentaire.models;

import lombok.Getter;

@Getter
public enum MarqueEnum {

    PEUGEOT("Peugeot"),
    RENAUL("Renault"),
    CITROEN("Citroën"),
    TOYOTA("Toyota"),
    MERCEDES("Mercedes");

    private String marque;

    MarqueEnum(String marque) {
        this.marque = marque;
    }
}
