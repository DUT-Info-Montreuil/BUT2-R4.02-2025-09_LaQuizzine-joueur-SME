package org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.dto.ReponseAjouterJoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.mock.*;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.services.interfaces.IJoueurServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.utils.constants.JoueurConstants;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class JoueurTest {
    List<String> liste_erreurs;
    IJoueurServices service;
    ReponseAjouterJoueurDTO reponse;
    /*
    @BeforeEach
    void setUp(){
        service = JoueurServicesImpl();
    }
    */
    @Test
    void AjouterJoueurMultipleErreursTest(){

        //Test quand Erreur Prenom & Erreur Annee naissance
        liste_erreurs = Arrays.asList(JoueurConstants.ERREUR_PRENOM, JoueurConstants.ERREUR_ANNEE_NAISSANCE);
        service = new AjouterJoueurPrenomEtAnneeNaissanceKOMock();
        reponse = service.ajouterJoueur("4", "Justin", -2, "gaston, lagaffe", 1);
        assertIterableEquals(liste_erreurs, reponse.getListeErreur(), "Erreur: La liste d'erreurs ne contient pas exactement Erreur_Prenom & Erreur_Annee_Naissance");
        assertNull(reponse.getJoueur(), "Erreur: Le joueur devrait être null");

        //Test quand Toutes les erreurs sont réunies (le boss final)
        liste_erreurs = Arrays.asList(JoueurConstants.ERREUR_PRENOM, JoueurConstants.ERREUR_PSEUDO, JoueurConstants.ERREUR_ANNEE_NAISSANCE, JoueurConstants.ERREUR_CENTRE_INTERETS, JoueurConstants.ERREUR_LANGUES);
        service = new AjouterJoueurToutesErreursKOMock();
        reponse = service.ajouterJoueur("4", "", -2, "gaston, lagaffe,", 18);
        assertIterableEquals(liste_erreurs, reponse.getListeErreur(), "Erreur: La liste d'erreurs ne contient pas toutes les erreurs");
        assertNull(reponse.getJoueur(), "Erreur: Le joueur devrait être null");
    }

    @Test
    void AjouterJoueurPrenomKOTest(){
        liste_erreurs = Arrays.asList(JoueurConstants.ERREUR_PRENOM);
        service = new AjouterJoueurPrenomKOMock();

        //Test quand Prenom contient un chiffre
        reponse = service.ajouterJoueur("4justin", "Justin", 2012, "gaston, lagaffe", 1);
        assertIterableEquals(liste_erreurs, reponse.getListeErreur(), "Erreur_chiffre: la liste d'erreurs ne contient pas exactement Erreur_Prenom");
        assertNull(reponse.getJoueur(), "Erreur_chiffre: le joueur devrait être null");

        //Test quand Prenom contient un caractère spécial
        reponse = service.ajouterJoueur("$justin", "Justin", 2012, "gaston, lagaffe", 1);
        assertIterableEquals(liste_erreurs, reponse.getListeErreur(), "Erreur_caractere_special: la liste d'erreurs ne contient pas exactement Erreur_Prenom");
        assertNull(reponse.getJoueur(), "Erreur_caractere_special: le joueur devrait être null");

        //Test quand Prenom est une chaine vide
        reponse = service.ajouterJoueur("", "Justin", 2012, "gaston, lagaffe", 1);
        assertIterableEquals(liste_erreurs, reponse.getListeErreur(), "Erreur_chaine_vide: la liste d'erreurs ne contient pas exactement Erreur_Prenom");
        assertNull(reponse.getJoueur(), "Erreur_chaine_vide: le joueur devrait être null");
    }

    @Test
    void AjouterJoueurPseudoKOTest(){
        liste_erreurs = Arrays.asList(JoueurConstants.ERREUR_PSEUDO);
        service = new AjouterJoueurPseudoKOMock();

        //Test quand pseudo commence par un chiffre
        reponse = service.ajouterJoueur("justin", "4Justin", 2012, "gaston, lagaffe", 1);
        assertIterableEquals(liste_erreurs, reponse.getListeErreur(), "Erreur_chiffre: la liste d'erreurs ne contient pas exactement Erreur_Pseudo");
        assertNull(reponse.getJoueur(), "Erreur_chiffre: le joueur devrait être null");

        //Test quand pseudo est une chaine vide
        reponse = service.ajouterJoueur("justin", "", 2012, "gaston, lagaffe", 1);
        assertIterableEquals(liste_erreurs, reponse.getListeErreur(), "Erreur_chaine_vide: la liste d'erreurs ne contient pas exactement Erreur_Pseudo");
        assertNull(reponse.getJoueur(), "Erreur_chaine_vide: le joueur devrait être null");
    }
    @Test
    void AjouterJoueurAucuneErreurTest(){
        liste_erreurs = Arrays.asList();
        service = new AjouterJoueurAucuneErreurKOMock();

        //Test quand cas normal
        reponse = service.ajouterJoueur("justin", "justinien_de_barbelote", 2012, "gaston, lagaffe", 1);
        assertIterableEquals(liste_erreurs, reponse.getListeErreur(), "Erreur_cas_correct: la liste d'erreur contient au moins une erreur");
        assertEquals(reponse.getJoueur(), new JoueurDTO("justin", "justinien_de_barbelote", 2012, "gaston, lagaffe", 1),
                "Erreur_cas_correct: le joueur renvoyé n'est pas correct");

        //Test quand Centre interets vide
        reponse = service.ajouterJoueur("justin", "barbelotetrip", 2012, "", 1);
        assertIterableEquals(liste_erreurs, reponse.getListeErreur(), "Erreur_cas_correct: la liste d'erreur contient au moins une erreur");
        assertEquals(reponse.getJoueur(), new JoueurDTO("justin", "barbelotetrip", 2012, "", 1),
                "Erreur_cas_correct: le joueur renvoyé n'est pas correct");


    }

    @Test
    void AjouterJoueurAnneeNaissanceTest(){
        liste_erreurs = Arrays.asList(JoueurConstants.ERREUR_ANNEE_NAISSANCE);
        service = new AjouterJoueurAnneeNaissanceKOMock();

        //Test quand annee naissance est négatif
        reponse = service.ajouterJoueur("justin", "in_just", -20, "gaston, lagaffe", 1);
        assertIterableEquals(liste_erreurs, reponse.getListeErreur(), "Erreur_annee_negative: la liste d'erreurs ne contient pas exactement Erreur_Annee_Naissance");
        assertNull(reponse.getJoueur(), "Erreur_annee_negative: le joueur devrait être null");

        //Test quand annee naissance est inférieur à 1900
        reponse = service.ajouterJoueur("justin", "in_just", 1899, "gaston, lagaffe", 1);
        assertIterableEquals(liste_erreurs, reponse.getListeErreur(), "Erreur_annee_<1900: la liste d'erreurs ne contient pas exactement Erreur_Annee_Naissance");
        assertNull(reponse.getJoueur(), "Erreur_annee_<1900: le joueur devrait être null");
    }

    @Test
    void AjouterJoueurCentreInteretsTest(){
        liste_erreurs = Arrays.asList(JoueurConstants.ERREUR_CENTRE_INTERETS);
        service = new AjouterJoueurCentreInteretsKOMock();

        //Test quand Centre interets finit par ","
        reponse = service.ajouterJoueur("justin", "in_just", 2500, "gaston, lagaffe,", 1);
        assertIterableEquals(liste_erreurs, reponse.getListeErreur(), "Erreur_finit_par_',': la liste d'erreurs ne contient pas exactement Erreur_Centre_Interets");
        assertNull(reponse.getJoueur(), "Erreur_finit_par_',': le joueur devrait être null");
    }

    @Test
    void AjouterJoueurLangueTest(){
        liste_erreurs = Arrays.asList(JoueurConstants.ERREUR_LANGUES);
        service = new AjouterJoueurLanguesKOMock();

        //Test quand langue à 0
        reponse = service.ajouterJoueur("justin", "in_just", 1900, "gaston, lagaffe", 0);
        assertIterableEquals(liste_erreurs, reponse.getListeErreur(), "Erreur_langue_0: la liste d'erreurs ne contient pas exactement Erreur_Langues");
        assertNull(reponse.getJoueur(), "Erreur_langue_0: le joueur devrait être null");

        //Test quand langue à 6
        reponse = service.ajouterJoueur("justin", "in_just", 2000, "gaston, lagaffe", 6);
        assertIterableEquals(liste_erreurs, reponse.getListeErreur(), "Erreur_langue_6: la liste d'erreurs ne contient pas exactement Erreur_Langues");
        assertNull(reponse.getJoueur(), "Erreur_langue_6: le joueur devrait être null");
    }

    @Test
    void AjouterJoueurExistantTest(){
        liste_erreurs = Arrays.asList();
        service = new AjouterJoueurPseudoX2KOMock();

        //Ajout de deux fois le meme pseudo
        reponse = service.ajouterJoueur("mariel", "justdopo", 2014, "", 1);
        assertIterableEquals(liste_erreurs, reponse.getListeErreur(), "Erreur_cas_correct: la liste d'erreur contient au moins une erreur");
        assertEquals(reponse.getJoueur(), new JoueurDTO("mariel", "justdopo", 2014, "", 1),
                "Erreur_cas_correct: le joueur renvoyé n'est pas correct");

        liste_erreurs = Arrays.asList(JoueurConstants.ERREUR_PSEUDO_EXISTE);
        reponse = service.ajouterJoueur("mariel", "justdopo", 2014, "", 1);
        assertIterableEquals(liste_erreurs, reponse.getListeErreur(), "Erreur_double_pseudo: La liste d'erreur ne contient pas exactement Erreur_Pseudo_Existe");
        assertNull(reponse.getJoueur(), "Erreur_double_pseudo: le joueur renvoyé n'est pas correct");


    }

}
