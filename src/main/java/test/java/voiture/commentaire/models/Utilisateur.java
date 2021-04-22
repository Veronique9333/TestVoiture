package test.java.voiture.commentaire.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString(exclude = "commentaireList")
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;

    @JsonIgnore
    @OneToMany(mappedBy = "utilisateur")
    private List<Commentaire> commentaireList = new ArrayList<> ();
}
