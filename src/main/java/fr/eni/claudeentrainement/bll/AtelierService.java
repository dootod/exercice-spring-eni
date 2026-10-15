package fr.eni.claudeentrainement.bll;

import fr.eni.claudeentrainement.bo.Atelier;

import java.util.List;

public interface AtelierService {
    public List<Atelier> listerAtelier();

    public void ajouterAtelier(Atelier atelier);

    public void supprimerAtelier(Integer numeroAtelier);
}
