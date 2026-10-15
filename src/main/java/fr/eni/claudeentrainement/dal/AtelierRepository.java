package fr.eni.claudeentrainement.dal;

import fr.eni.claudeentrainement.bo.Atelier;

import java.util.List;

public interface AtelierRepository {
    public List<Atelier> findAll();

    public void insert(Atelier atelier);

    public int deletedById(Integer numero);
}
