package test.java.voiture.commentaire.models;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDate;

@MappedSuperclass
@Data
public abstract class CommonAttributeEntity<ID> implements Serializable {

    @Id
    private ID id;

    private boolean deleted;

    private LocalDate dateUpdate = LocalDate.now ();
}
