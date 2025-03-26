package org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.mock;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.dto.ReponseAjouterJoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.services.interfaces.IJoueurServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.utils.constants.JoueurConstants;

import java.util.ArrayList;
import java.util.List;

public class AjouterJoueurPrenomKOMock implements IJoueurServices {

    @Override
    public ReponseAjouterJoueurDTO ajouterJoueur(String prenom, String pseudo, int annee_naissance, String centre_interets, int langue) {
        List liste_erreur = new ArrayList<>();
        liste_erreur.add(JoueurConstants.ERREUR_PRENOM);
        return new ReponseAjouterJoueurDTO(liste_erreur, null);
    }
}
