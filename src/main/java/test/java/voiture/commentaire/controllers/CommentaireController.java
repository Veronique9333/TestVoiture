package test.java.voiture.commentaire.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.java.voiture.commentaire.dto.CommentaireDto;
import test.java.voiture.commentaire.models.Commentaire;
import test.java.voiture.commentaire.repositories.CommentaireRepository;
import test.java.voiture.commentaire.services.CommentaireService;
import test.java.voiture.commentaire.services.UtilisateurService;
import test.java.voiture.commentaire.services.VoitureService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/commentaire/")
public class CommentaireController {

    private final CommentaireService commentaireService;
    private final VoitureService voitureService;
    private final UtilisateurService utilisateurService;

    private final CommentaireRepository commentaireRepository;

    public CommentaireController(CommentaireService commentaireService, VoitureService voitureService,
                                 UtilisateurService utilisateurService, CommentaireRepository commentaireRepository) {
        this.commentaireService = commentaireService;
        this.voitureService = voitureService;
        this.utilisateurService = utilisateurService;
        this.commentaireRepository = commentaireRepository;
    }

    //get all comments
    @GetMapping("list-coms")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Commentaire>> listVoiture(){
        return ResponseEntity.ok (commentaireRepository.findAll ());
    }

    //get all commentaire by voiture
    @GetMapping("{idVoiture}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Commentaire>> getCommentaireByVoiture(@PathVariable("idVoiture") String idVoiture){
        List<Commentaire> commentaireList = commentaireService.fetchAllCommentaireByVoiture(idVoiture);
        return ResponseEntity.ok (commentaireList);
    }

    //save commentaire
    @PostMapping(value = "save")
    public ResponseEntity<Commentaire> createCommentaire(@RequestBody CommentaireDto commentaireDto) {
        log.info ("coms dto {}", commentaireDto);
        try {
            Commentaire commentaire = new Commentaire ();
            commentaire.setDescription (commentaireDto.getDescription ());
            commentaire.setVoiture (voitureService.fetchOneVoiture (commentaireDto.getVoitureId ()));
            commentaire.setUtilisateur (utilisateurService.fecthOneUser(commentaireDto.getUtilisateurId ()));

            log.info ("com {}", commentaire);

            return new ResponseEntity<> (this.commentaireService.saveRecord (commentaire), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<> (null, HttpStatus.EXPECTATION_FAILED);
        }
    }
}
