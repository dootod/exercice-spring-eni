package fr.eni.claudeentrainement.bo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Atelier {
    @NotNull(message = "Le numero est obligatoire")
    private Integer numero;

    @NotBlank(message = "Le nom est obligatoire")
    @Size(max = 30, message = "Le nom ne doit pas dépasser 30 caractères")
    private String nom;

    public Atelier() {
    }

    public Atelier(Integer numero, String nom) {
        this.numero = numero;
        this.nom = nom;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
