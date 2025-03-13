package org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.dto;

import java.util.List;
import java.util.Objects;

public class ReponseAjouterJoueurDTO {
    private List<String> listeErreur;
    private JoueurDTO joueur;
    private boolean isErreur = false;

    public ReponseAjouterJoueurDTO(List<String> listeErreur, JoueurDTO joueur) {
        this.listeErreur = listeErreur;
        this.joueur = joueur;
    }

    public List<String> getListeErreur() {
        return listeErreur;
    }

    public void setListeErreur(List<String> listeErreur) {
        this.listeErreur = listeErreur;
    }

    public JoueurDTO getJoueur() {
        return joueur;
    }

    public void setJoueur(JoueurDTO joueur) {
        this.joueur = joueur;
    }

    public boolean isErreur() {
        return isErreur;
    }

    public void toggleErreur() {
        isErreur = !isErreur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReponseAjouterJoueurDTO that = (ReponseAjouterJoueurDTO) o;
        return isErreur == that.isErreur && Objects.equals(listeErreur, that.listeErreur) && Objects.equals(joueur, that.joueur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listeErreur, joueur, isErreur);
    }

    @Override
    public String toString() {
        return "ReponseAjouterJoueurDTO{" +
                "listeErreur=" + listeErreur +
                ", joueur=" + joueur +
                ", isErreur=" + isErreur +
                '}';
    }
}
