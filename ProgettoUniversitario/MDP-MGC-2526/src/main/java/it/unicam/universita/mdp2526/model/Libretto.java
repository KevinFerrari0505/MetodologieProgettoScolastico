package it.unicam.universita.mdp2526.model;

import it.unicam.universita.mdp2526.interfaces.ApprovaPianoDiStudi;
import it.unicam.universita.mdp2526.interfaces.CalcolatoreMedia;
import it.unicam.universita.mdp2526.interfaces.GestoreUniversitario;
import it.unicam.universita.mdp2526.interfaces.StampaEsameSuperati;
import it.unicam.universita.mdp2526.utils.EsameSuperato;
import it.unicam.universita.mdp2526.utils.FormattatoreVoto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Libretto implements CalcolatoreMedia, StampaEsameSuperati {

    private final Studente studente;
    private final Map<Esame, Integer> voti = new HashMap<>();

    public Libretto(Studente studente) {
        if (studente == null) {
            throw new IllegalArgumentException("Studente non valido");
        }
        this.studente = studente;
    }

    public void registraEsameSuperato(Esame esame, int voto) {
        if (esame == null) {
            throw new IllegalArgumentException("Esame non valido");
        }
        if (voto < 18 || voto > 31) {
            throw new IllegalArgumentException("Voto non valido");
        }

        voti.put(esame, voto);
    }

    public int getVoto(Esame esame) {
        if (esame == null) {
            throw new IllegalArgumentException("Esame non valido");
        }

        Integer voto = voti.get(esame);

        if (voto == null) {
            throw new IllegalArgumentException("Esame non trovato nel libretto");
        }

        return voto;
    }

    @Override
    public double calcolaMedia() {
        if (voti.isEmpty()) {
            return 0;
        }

        int somma = 0;

        for (int voto : voti.values()) {
            somma += (voto == 31) ? 30 : voto;
        }

        return somma / voti.size();
    }

    @Override
    public void stampaEsamiSuperati(Studente studente) {
        System.out.println("Libretto di " + studente.getNomeCompleto());

        for (Map.Entry<Esame, Integer> entry : voti.entrySet()) {
            Esame esame = entry.getKey();
            int voto = entry.getValue();

            System.out.println( esame.getNome() + " - " + FormattatoreVoto.formatta(voto));
        }
    }
}
