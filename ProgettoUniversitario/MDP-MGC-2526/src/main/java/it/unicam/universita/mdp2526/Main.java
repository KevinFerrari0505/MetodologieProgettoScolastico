package it.unicam.universita.mdp2526;

import it.unicam.universita.mdp2526.model.*;

import java.io.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Professore prof = new Professore("Mario", "Rossi", "Informatica");

        Esame programmazione = new Esame("Programmazione", prof);
        Esame algoritmi = new Esame("Algoritmi", prof);
        Esame basiDati = new Esame("Basi di dati", prof);

        Studente giulia = new Studente("Giulia", "Bianchi", 1001);
        Studente marco = new Studente("Marco", "Verdi", 1002);
        Studente sara = new Studente("Sara", "Neri", 1003);

        giulia.getLibretto().registraEsameSuperato(programmazione, 30);
        giulia.getLibretto().registraEsameSuperato(algoritmi, 29);
        giulia.getLibretto().registraEsameSuperato(basiDati, 31);

        marco.getLibretto().registraEsameSuperato(programmazione, 24);
        marco.getLibretto().registraEsameSuperato(algoritmi, 27);
        marco.getLibretto().registraEsameSuperato(basiDati, 26);

        sara.getLibretto().registraEsameSuperato(programmazione, 28);
        sara.getLibretto().registraEsameSuperato(algoritmi, 30);
        sara.getLibretto().registraEsameSuperato(basiDati, 29);

        List<Studente> studenti = List.of(giulia, marco, sara);

        ReportStudenti report = new ReportStudenti();
        report.stampaStudentiConMediaAlta(studenti);
    }

    public static Object formattaStudente(Studente studente)
    {
        return studente.getNomeCompleto() + " Media: " + studente.getLibretto().calcolaMedia();
    }

    public static boolean haMediaAlta(Studente studente)
    {
        return studente.getLibretto().calcolaMedia() >= 28;
    }

    public static int confrontaPerMediaDecrescente(Studente studente, Studente studente1)
    {
        return Double.compare(studente.getLibretto().calcolaMedia(), studente1.getLibretto().calcolaMedia());
    }
}