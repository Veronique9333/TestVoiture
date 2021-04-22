package test.java.voiture.commentaire.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import test.java.voiture.commentaire.models.Voiture;
import test.java.voiture.commentaire.services.VoitureService;
import test.java.voiture.commentaire.utils.AppNotFoundException;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/api/voiture/")
public class VoitureController {

    private final VoitureService voitureService;

    public VoitureController(VoitureService voitureService) {
        this.voitureService = voitureService;
    }

    //get all voiture
    @GetMapping("list-voiture")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Voiture>> listVoiture(){
        return ResponseEntity.ok (voitureService.findAllVoiture ());
    }


    //get one voiture by id
    @GetMapping("{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Voiture> fetchOneVoiture(@PathVariable String id) throws AppNotFoundException {
        return ResponseEntity.ok (voitureService.fetchOneVoiture (id));
    }

    //save voiture
    @PostMapping(value = "save", consumes = {"multipart/form-data" })
    @CrossOrigin(origins = "*")
    public ResponseEntity<Voiture> createVoiture(@RequestBody Voiture voiture){
        log.info ("voiture {}", voiture);
        Voiture newVoiture = this.voitureService.saveRecord (voiture);
        return ResponseEntity.ok (newVoiture);
    }


}
