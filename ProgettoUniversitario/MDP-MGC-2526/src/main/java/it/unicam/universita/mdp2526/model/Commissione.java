package it.unicam.universita.mdp2526.model;

import it.unicam.universita.mdp2526.interfaces.Valutatore;

import java.util.ArrayList;
import java.util.List;

public class Commissione implements Valutatore {

    private List<Valutatore> membri;

    public Commissione() {
        this.membri = new ArrayList<>();
    }

    public void aggiungiMembro(Valutatore valutatore) {
        if (valutatore == null) {
            throw new IllegalArgumentException("Valutatore non valido");
        }
        membri.add(valutatore);
    }

    public List<Valutatore> getMembri() {
        return membri;
    }

    /**
     *
     * @param studente
     * assegna un voto compreso 18 e 31
     * Il voto 31 comporta il voto 30 e lode
     * @return
     */
    @Override
    public int assegnaVoto(Studente studente) {
        if (studente == null) {
            throw new IllegalArgumentException("Studente non valido");
        }

        if (membri.isEmpty()) {
            throw new IllegalStateException("La commissione non ha membri");
        }

        int somma = 0;

        for (Valutatore v : membri) {
            int voto = v.assegnaVoto(studente);
            somma += voto;
        }

        int media = somma / membri.size();

        return media;
    }
}