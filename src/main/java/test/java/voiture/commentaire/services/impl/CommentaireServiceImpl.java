package test.java.voiture.commentaire.services.impl;

import org.springframework.stereotype.Service;
import test.java.voiture.commentaire.models.Commentaire;
import test.java.voiture.commentaire.models.Voiture;
import test.java.voiture.commentaire.repositories.CommentaireRepository;
import test.java.voiture.commentaire.repositories.VoitureRepository;
import test.java.voiture.commentaire.services.CommentaireService;

import java.util.List;

@Service
public class CommentaireServiceImpl extends AbstractServiceImpl<Commentaire, String, CommentaireRepository> implements CommentaireService {

    private final CommentaireRepository commentaireRepository;
    private final VoitureRepository voitureRepository;

    public CommentaireServiceImpl(CommentaireRepository commentaireRepository, VoitureRepository voitureRepository) {
        this.commentaireRepository = commentaireRepository;
        this.voitureRepository = voitureRepository;
    }

    @Override
    public CommentaireRepository repository() {
        return commentaireRepository;
    }

    @Override
    public List<Commentaire> fetchAllCommentaireByVoiture(String idVoiture) {
        Voiture voiture = voitureRepository.getOne (idVoiture);
        return commentaireRepository.findByVoiture(voiture);
    }

}
