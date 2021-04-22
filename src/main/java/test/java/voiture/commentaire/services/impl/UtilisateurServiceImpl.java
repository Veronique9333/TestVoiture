package test.java.voiture.commentaire.services.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import test.java.voiture.commentaire.models.LocalUserDetails;
import test.java.voiture.commentaire.models.Role;
import test.java.voiture.commentaire.models.Utilisateur;
import test.java.voiture.commentaire.repositories.RoleRepository;
import test.java.voiture.commentaire.repositories.UtilisateurRepository;
import test.java.voiture.commentaire.services.UtilisateurService;
import test.java.voiture.commentaire.utils.AppNotFoundException;

import java.util.Optional;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final RoleRepository roleRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository, RoleRepository roleRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public boolean checkExistUser() {
        return utilisateurRepository.findAll ().size ()>0;
    }

    @Override
    public Utilisateur initUser() {
        Role role = new Role ("Admin");
        Role roleUse = roleRepository.save (role);

        Utilisateur utilisateur = new Utilisateur ();
        utilisateur.setUsername ("rasoanantenainav@gmail.com");
        utilisateur.setPassword ("V1234!");
        utilisateur.setRole (roleUse);
        utilisateurRepository.save (utilisateur);
        return utilisateur;
    }

    @Override
    public Utilisateur fecthOneUser(Long utilisateurId) throws AppNotFoundException {
        return utilisateurRepository.findById (String.valueOf (utilisateurId))
                .orElseThrow (() -> new AppNotFoundException ("Utilisateur non trouvé"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByUsername(username);
        if (utilisateur.isPresent()) {
            return new LocalUserDetails (utilisateur.get());
        } else {
            throw new IllegalArgumentException(String.format("Cannot find the user with username  %s", username));
        }
    }
}
