package test.java.voiture.commentaire.services.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import test.java.voiture.commentaire.models.CommonAttributeEntity;
import test.java.voiture.commentaire.services.CommonService;
import test.java.voiture.commentaire.utils.GeneratorUtils;

import java.io.Serializable;

@Service
public abstract class AbstractServiceImpl<E extends CommonAttributeEntity<ID>, ID extends Serializable, RP extends JpaRepository<E, ID>>
        implements CommonService<E, ID> {

    public abstract RP repository();

    @Override
    public E saveRecord(E entity){
        if (entity.getId () == null || entity.getId ().toString ().isEmpty ()) {
            entity.setId ((ID) GeneratorUtils.uuid ());
        }
        return repository ().save (entity);
    }
}
