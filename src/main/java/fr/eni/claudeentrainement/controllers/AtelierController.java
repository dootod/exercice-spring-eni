package fr.eni.claudeentrainement.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.eni.claudeentrainement.bll.AtelierService;
import fr.eni.claudeentrainement.bo.Atelier;
import fr.eni.claudeentrainement.exception.AtelierDejaExistantException;
import fr.eni.claudeentrainement.exception.AtelierIntrouvableException;
import jakarta.validation.Valid;


@RestController
public class AtelierController {
    private final AtelierService atelierService;

    public AtelierController(AtelierService atelierService) {
        this.atelierService = atelierService;
    }

    @GetMapping("/ateliers")
    public ResponseEntity<List<Atelier>> getAtelier() {
        List<Atelier> ateliers = atelierService.listerAtelier();
        return ResponseEntity.status(HttpStatus.OK).body(ateliers);
    }

    @PostMapping("/ateliers")
    public ResponseEntity<?> addAtelier(@Valid @RequestBody Atelier atelier, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        try {
            atelierService.ajouterAtelier(atelier);
            return ResponseEntity.status(HttpStatus.CREATED).body(atelier);
        } catch (AtelierDejaExistantException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @DeleteMapping("/ateliers/{numeroAtelier}")
    public ResponseEntity<Void> deleteAtelier(@PathVariable("numeroAtelier") Integer numeroAtelier) {
        try {
            atelierService.supprimerAtelier(numeroAtelier);
        } catch (AtelierIntrouvableException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/ateliers/recherche")
    public ResponseEntity<Atelier> afficherAtelier(@RequestParam("numero") Integer numero) {
        Optional<Atelier> atelierOptional = atelierService.afficherAtelier(numero);

        if (atelierOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(atelierOptional.get());
    }
}
