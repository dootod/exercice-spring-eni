package fr.eni.claudeentrainement.dal;

import java.util.List;
import java.util.Optional;

import fr.eni.claudeentrainement.bo.Atelier;

public interface AtelierRepository {
    public List<Atelier> findAll();

    public void insert(Atelier atelier);

    public int deleteById(Integer numero);

    public Optional<Atelier> findById(Integer numero);
}
