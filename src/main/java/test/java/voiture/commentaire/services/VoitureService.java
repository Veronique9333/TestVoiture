package test.java.voiture.commentaire.services;


import test.java.voiture.commentaire.utils.AppNotFoundException;
import test.java.voiture.commentaire.models.Voiture;

import java.util.List;

public interface VoitureService extends CommonService<Voiture, String>{

    List<Voiture> findAllVoiture();

    Voiture fetchOneVoiture(String idVoiture) throws AppNotFoundException;

    boolean checkExistVoiture();

    void initVoiture();
}
