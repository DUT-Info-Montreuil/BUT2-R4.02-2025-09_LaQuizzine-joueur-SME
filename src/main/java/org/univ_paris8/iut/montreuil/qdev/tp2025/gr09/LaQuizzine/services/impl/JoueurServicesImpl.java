package org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.services.impl;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.dto.ReponseAjouterJoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.services.interfaces.IJoueurServices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.utils.constants.JoueurConstants;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.utils.enums.LangueEnum;
public class JoueurServicesImpl implements IJoueurServices {

    List<JoueurDTO> joueur_existant = new ArrayList<>();

    public List<JoueurDTO> getJoueurExistant() {
        return joueur_existant;
    }

    @Override
    public ReponseAjouterJoueurDTO ajouterJoueur(String prenom, String pseudo, int annee_naissance, String centre_interets, int langue) {
        List<String> liste_erreurs = new ArrayList<>();


        if (prenom.isBlank() || prenom.matches(".*[^a-zA-Z].*")) liste_erreurs.add(JoueurConstants.ERREUR_PRENOM);

        if (pseudo.isBlank() || pseudo.charAt(0) >= '0' && pseudo.charAt(0) <= '9') liste_erreurs.add(JoueurConstants.ERREUR_PSEUDO);

        for (JoueurDTO joueurDTO : joueur_existant) {
            if (pseudo.equals(joueurDTO.getPseudo())) liste_erreurs.add(JoueurConstants.ERREUR_PSEUDO_EXISTE);
        }

        if (annee_naissance < 1900) liste_erreurs.add(JoueurConstants.ERREUR_ANNEE_NAISSANCE);

        if (centre_interets.endsWith(",")) liste_erreurs.add(JoueurConstants.ERREUR_CENTRE_INTERETS);

        if (LangueEnum.fromNumero(langue) == null) liste_erreurs.add(JoueurConstants.ERREUR_LANGUES);

        JoueurDTO newJoueur = new JoueurDTO(prenom, pseudo, annee_naissance, centre_interets, langue);

        if (liste_erreurs.isEmpty()) {
            joueur_existant.add(newJoueur);
            return new ReponseAjouterJoueurDTO(liste_erreurs, newJoueur);
        }
        else
            return new ReponseAjouterJoueurDTO(liste_erreurs, null);
    }
}
