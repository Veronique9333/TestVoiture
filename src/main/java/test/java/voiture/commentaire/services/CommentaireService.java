package test.java.voiture.commentaire.services;

import test.java.voiture.commentaire.models.Commentaire;

import java.util.List;

public interface CommentaireService extends CommonService<Commentaire, String>{

    List<Commentaire> fetchAllCommentaireByVoiture(String idVoiture);

}
