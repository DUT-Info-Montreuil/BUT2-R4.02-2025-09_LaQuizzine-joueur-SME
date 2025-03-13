package org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.services.interfaces;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.dto.JoueurDTO;

public interface IJoueurServices {
    JoueurDTO ajouterJoueur(String prenom, String pseudo, int annee_naissance, String centre_interets, int langue);
}
