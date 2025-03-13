package org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.dto;

import java.util.Objects;

public class JoueurDTO {
    private String prenom;
    private String pseudo;
    private int annee_naissance;
    private String centre_interets;
    private int langue;

    public JoueurDTO(String prenom, String pseudo, int annee_naissance, String centre_interets, int langue) {
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.annee_naissance = annee_naissance;
        this.centre_interets = centre_interets;
        this.langue = langue;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getAnnee_naissance() {
        return annee_naissance;
    }

    public void setAnnee_naissance(int annee_naissance) {
        this.annee_naissance = annee_naissance;
    }

    public String getCentre_interets() {
        return centre_interets;
    }

    public void setCentre_interets(String centre_interets) {
        this.centre_interets = centre_interets;
    }

    public int getLangue() {
        return langue;
    }

    public void setLangue(int langue) {
        this.langue = langue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JoueurDTO joueurDTO = (JoueurDTO) o;
        return annee_naissance == joueurDTO.annee_naissance && langue == joueurDTO.langue && Objects.equals(prenom, joueurDTO.prenom) && Objects.equals(pseudo, joueurDTO.pseudo) && Objects.equals(centre_interets, joueurDTO.centre_interets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prenom, pseudo, annee_naissance, centre_interets, langue);
    }

    @Override
    public String toString() {
        return "JoueurDTO{" +
                "prenom='" + prenom + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", annee_naissance=" + annee_naissance +
                ", centre_interets='" + centre_interets + '\'' +
                ", langue=" + langue +
                '}';
    }
}
