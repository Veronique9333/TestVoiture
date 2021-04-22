package test.java.voiture.commentaire.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Data
@NoArgsConstructor
public class CommentaireDto {

    private String id;
    private String description;
    private String voitureId;
    private Long utilisateurId;
}
