package fr.eni.claudeentrainement.bll;

import fr.eni.claudeentrainement.bo.Atelier;
import fr.eni.claudeentrainement.dal.AtelierRepository;
import fr.eni.claudeentrainement.exception.AtelierDejaExistantException;
import fr.eni.claudeentrainement.exception.AtelierIntrouvableException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtelierServiceImpl implements AtelierService {
    private final AtelierRepository atelierRepository;

    public AtelierServiceImpl(AtelierRepository atelierRepository) {
        this.atelierRepository = atelierRepository;
    }

    @Override
    public List<Atelier> listerAtelier() {

        return atelierRepository.findAll();
    }

    @Override
    public void ajouterAtelier(Atelier atelier) {
        try {
            atelierRepository.insert(atelier);
        } catch (DuplicateKeyException e) {
            throw new AtelierDejaExistantException(
                    "L'atelier " + atelier.getNumero() + " existe déjà"
            );
        }
    }

    @Override
    public void supprimerAtelier(Integer numeroAtelier) {
        int result = atelierRepository.deleteById(numeroAtelier);

        if (result == 0) {
            throw new AtelierIntrouvableException("L'atelier " + numeroAtelier + " existe pas");
        }
    }
}
