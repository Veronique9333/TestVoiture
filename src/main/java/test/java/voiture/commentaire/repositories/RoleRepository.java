package test.java.voiture.commentaire.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.java.voiture.commentaire.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
}
