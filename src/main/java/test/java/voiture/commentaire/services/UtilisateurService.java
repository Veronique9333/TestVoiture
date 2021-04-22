package test.java.voiture.commentaire.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import test.java.voiture.commentaire.models.Utilisateur;
import test.java.voiture.commentaire.utils.AppNotFoundException;

public interface UtilisateurService extends UserDetailsService {

    boolean checkExistUser();

    Utilisateur initUser();

    Utilisateur fecthOneUser(Long utilisateurId) throws AppNotFoundException;
}
