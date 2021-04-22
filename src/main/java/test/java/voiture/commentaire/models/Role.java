package test.java.voiture.commentaire.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = "utilisateurs")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String roleName;

    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private List<Utilisateur> utilisateurs = new ArrayList<> ();

    public Role(String roleName) {
        this.roleName = roleName;
    }
}
