package org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.dto.ReponseAjouterJoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.mock.AjouterJoueurPrenomEtAnneeNaissanceKOMock;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.services.interfaces.IJoueurServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.utils.constants.JoueurConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class JoueurTest {

    @Test
    void AjouterJoueurTest(){
        //Test quand Erreur Prenom & Erreur Anne naissance
        List<String> liste_erreurs = Arrays.asList(JoueurConstants.ERREUR_PRENOM, JoueurConstants.ERREUR_ANNEE_NAISSANCE);
        IJoueurServices service = new AjouterJoueurPrenomEtAnneeNaissanceKOMock();
        ReponseAjouterJoueurDTO reponse = service.ajouterJoueur("4", "Justin", -2, "gaston, lagaffe", 1);
        assertNull(reponse.getJoueur(), "Erreur: Le joueur n'est pas null");
        assertIterableEquals(liste_erreurs, reponse.getListeErreur(), "Erreur: La liste d'erreurs ne contient pas exactement Erreur_Prenom & Erreur_Annee_Naissance");
    }
}
