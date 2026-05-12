package it.unicam.universita.mdp2526.model;

import it.unicam.universita.mdp2526.Main;

import java.util.List;

public class ReportStudenti
{
    public static void stampaStudentiConMediaAlta(List<Studente> studenti)
    {
        studenti.stream().filter(Main::haMediaAlta).sorted(Main::confrontaPerMediaDecrescente).map(Main::formattaStudente).forEach(System.out::println);

    }
}
