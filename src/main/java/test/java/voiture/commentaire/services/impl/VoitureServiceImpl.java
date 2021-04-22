package test.java.voiture.commentaire.services.impl;

import org.springframework.stereotype.Service;
import test.java.voiture.commentaire.models.Commentaire;
import test.java.voiture.commentaire.models.MarqueEnum;
import test.java.voiture.commentaire.repositories.UtilisateurRepository;
import test.java.voiture.commentaire.services.CommentaireService;
import test.java.voiture.commentaire.services.UtilisateurService;
import test.java.voiture.commentaire.utils.AppNotFoundException;
import test.java.voiture.commentaire.models.Voiture;
import test.java.voiture.commentaire.repositories.VoitureRepository;
import test.java.voiture.commentaire.services.VoitureService;
import test.java.voiture.commentaire.utils.GeneratorUtils;

import java.util.List;

@Service
public class VoitureServiceImpl extends AbstractServiceImpl<Voiture, String, VoitureRepository> implements VoitureService {

    private final VoitureRepository voitureRepository;

    private final UtilisateurService utilisateurService;

    private final UtilisateurRepository utilisateurRepository;

    private final CommentaireService commentaireService;

    public VoitureServiceImpl(UtilisateurService utilisateurService, VoitureRepository voitureRepository,
                              UtilisateurRepository utilisateurRepository, CommentaireService commentaireService) {
        this.utilisateurService = utilisateurService;
        this.voitureRepository = voitureRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.commentaireService = commentaireService;
    }

    @Override
    public VoitureRepository repository() {
        return voitureRepository;
    }

    @Override
    public List<Voiture> findAllVoiture() {
        return voitureRepository.findAll ();
    }

    @Override
    public Voiture fetchOneVoiture(String idVoiture) throws AppNotFoundException {
        return voitureRepository.findById (idVoiture)
                .orElseThrow (() -> new AppNotFoundException ("Voiture non trouvé"));
    }

    @Override
    public boolean checkExistVoiture() {
        return voitureRepository.findAll ().size () > 0;
    }

    @Override
    public void initVoiture() {
        Voiture voiture = new Voiture ();
        voiture.setMatricule ("1515TAB");
        voiture.setMarque (MarqueEnum.RENAUL);
        voiture.setPuissance (125);
        voiture.setVitesse (45.0);
        Voiture voiture1 = this.saveRecord (voiture);

        Commentaire commentaire = new Commentaire ();
        commentaire.setDescription ("Premiers commentaire");
        commentaire.setVoiture (voiture1);
        if (!utilisateurService.checkExistUser ())
            commentaire.setUtilisateur (utilisateurService.initUser ());
        commentaire.setUtilisateur (utilisateurRepository.findAll ().get (0));
        commentaireService.saveRecord (commentaire);
    }

}
