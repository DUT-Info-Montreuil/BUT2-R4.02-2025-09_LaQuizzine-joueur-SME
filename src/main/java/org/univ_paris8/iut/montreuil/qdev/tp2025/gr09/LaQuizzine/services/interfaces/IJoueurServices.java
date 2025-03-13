package org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.services.interfaces;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.dto.ReponseAjouterJoueurDTO;

public interface IJoueurServices {
    ReponseAjouterJoueurDTO ajouterJoueur(String prenom, String pseudo, int annee_naissance, String centre_interets, int langue);
}
