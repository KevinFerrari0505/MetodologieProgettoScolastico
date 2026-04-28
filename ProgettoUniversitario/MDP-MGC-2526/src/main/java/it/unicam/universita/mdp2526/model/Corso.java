package it.unicam.universita.mdp2526.model;

import java.util.ArrayList;
import java.util.List;

public class Corso {

    private String nome;
    private Professore docente;
    private List<Studente> iscritti;

    public Corso(String nome, Professore docente) {
        this.nome = nome;
        this.docente = docente;
        this.iscritti = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public Professore getDocente() {
        return docente;
    }

    public void iscriviStudente(Studente studente) {
        iscritti.add(studente);
    }

    public void stampaIscritti() {
        System.out.println("Studenti iscritti al corso di " + nome + ":");
        for (Studente studente : iscritti) {
            System.out.println("- " + studente.getNomeCompleto()
                    + " (matricola " + studente.getMatricola() + ")");
        }
    }
}