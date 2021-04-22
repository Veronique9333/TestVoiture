package test.java.voiture.commentaire.services;

import test.java.voiture.commentaire.models.CommonAttributeEntity;

import java.io.Serializable;

public interface CommonService<E extends CommonAttributeEntity<ID>, ID extends Serializable>{

    E saveRecord(E entity);
}
