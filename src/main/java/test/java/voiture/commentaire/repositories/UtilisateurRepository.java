package test.java.voiture.commentaire.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import test.java.voiture.commentaire.models.Utilisateur;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    @Query("select u from Utilisateur u where u.username =:username")
    Optional<Utilisateur> findByUsername(@Param ("username") String username);
}
