package it.unicam.universita.mdp2526.model;

import java.util.Objects;

public class Studente extends Persona {

    private final int matricola;
    private final Libretto libretto;

    public Studente(String nome, String cognome, int matricola) {
        super(nome, cognome);

        if (matricola <= 0) {
            throw new IllegalArgumentException("Matricola non valida");
        }

        this.matricola = matricola;
        this.libretto = new Libretto(this);
    }

    public int getMatricola() {
        return matricola;
    }

    @Override
    public void presentati() {
        System.out.println("Ciao, sono lo studente " + getNomeCompleto());
    }

    public Libretto getLibretto() {
        return libretto;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Studente)) return false;
        Studente other = (Studente) obj;
        return this.matricola == other.matricola;
    }

    @Override
    public int hashCode(){
        return Objects.hash(matricola);
    }
}