package it.unicam.universita.mdp2526.model;

import it.unicam.universita.mdp2526.interfaces.Valutatore;

import java.util.Random;

public class Professore extends Persona implements Valutatore {

    private String settore;
    private static final Random random = new Random();

    public Professore(String nome, String cognome, String settore) {
        super(nome, cognome);
        setSettore(settore);
    }

    public String getSettore() {
        return settore;
    }

    public void setSettore(String settore) {
        if (settore == null || settore.isBlank()) {
            throw new IllegalArgumentException("Settore non valido");
        }
        this.settore = settore;
    }

    @Override
    public int assegnaVoto(Studente studente) {
        if (studente == null) {
            throw new IllegalArgumentException("Studente non valido");
        }

        int voto = random.nextInt(32); // 0–31

        return voto;
    }

    @Override
    public void presentati() {
        System.out.println("Sono il professore " + getNomeCompleto() +
                " del settore " + settore);
    }
}