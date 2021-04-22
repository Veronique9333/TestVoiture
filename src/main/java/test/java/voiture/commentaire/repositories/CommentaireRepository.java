package test.java.voiture.commentaire.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test.java.voiture.commentaire.models.Commentaire;
import test.java.voiture.commentaire.models.Voiture;

import java.util.List;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, String> {

    @Query("select com from Commentaire com where com.voiture =:voiture")
    List<Commentaire> findByVoiture(Voiture voiture);
}
