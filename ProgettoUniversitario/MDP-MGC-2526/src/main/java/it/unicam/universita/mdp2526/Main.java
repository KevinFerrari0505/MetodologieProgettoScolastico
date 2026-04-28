package it.unicam.universita.mdp2526;

import it.unicam.universita.mdp2526.model.Persona;
import it.unicam.universita.mdp2526.model.Professore;
import it.unicam.universita.mdp2526.model.Studente;

public class Main {

    public static void main(String[] args) {

        Persona s1 = new Studente("Anna", "Rossi", 1001);
        Persona p1 = new Professore("Luca", "Bianchi", "Informatica");
        s1.presentati();
        p1.presentati();

    }
}