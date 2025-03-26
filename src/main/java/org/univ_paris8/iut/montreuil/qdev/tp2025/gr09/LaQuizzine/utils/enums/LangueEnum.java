package org.univ_paris8.iut.montreuil.qdev.tp2025.gr09.LaQuizzine.utils.enums;

public enum LangueEnum {
    FRANCAIS(1, "Français"),
    ANGLAIS(2, "Anglais"),
    ESPAGNOL(3, "Espagnol"),
    ALLEMAND(4, "Allemand"),
    ITALIEN(5, "Italien");

    private final int numero;
    private final String nom;

    LangueEnum(int numero, String nom) {
        this.numero = numero;
        this.nom = nom;
    }

    public int getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }

    public static LangueEnum fromNumero(int numero) {
        for (LangueEnum l : LangueEnum.values()) {
            if (l.getNumero() == numero) {
                return l;
            }
        }
        return null;
    }


}
