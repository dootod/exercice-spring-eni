package fr.eni.claudeentrainement.bo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Musicien {
    @NotNull(message = "Le numero est obligatoire")
    private int numeroJoueur;

    @NotNull(message = "Le nom est obligatoire")
    @Size(max = 30, message = "La taille du nom de ne doit pas depasser les 30 char")
    private String nom;

    @NotNull(message = "Le prenom est obligatoire")
    @Size(max = 30, message = "La taille du prenom de ne doit pas depasser les 30 char")
    private String prenom;

    @Size(max = 50, message = "La taille du mail de ne doit pas depasser les 50 char")
    private String email;

    private int numero;

    public int getNumeroJoueur() {
        return numeroJoueur;
    }

    public void setNumeroJoueur(int numeroJoueur) {
        this.numeroJoueur = numeroJoueur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
