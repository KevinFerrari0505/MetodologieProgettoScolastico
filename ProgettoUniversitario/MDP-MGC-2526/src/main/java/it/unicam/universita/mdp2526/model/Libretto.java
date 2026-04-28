package it.unicam.universita.mdp2526.model;

import it.unicam.universita.mdp2526.interfaces.ApprovaPianoDiStudi;
import it.unicam.universita.mdp2526.interfaces.GestoreUniversitario;
import it.unicam.universita.mdp2526.interfaces.StampaEsameSuperati;
import it.unicam.universita.mdp2526.utils.EsameSuperato;
import it.unicam.universita.mdp2526.utils.FormattatoreVoto;

import java.util.ArrayList;
import java.util.List;

public class Libretto implements GestoreUniversitario, StampaEsameSuperati, ApprovaPianoDiStudi
{
    private final Studente studente;
    private final List<EsameSuperato> esamiSuperati = new ArrayList<>();

    public Libretto(Studente studente) {
        if (studente == null) {
            throw new IllegalArgumentException("Studente non valido");
        }
        this.studente = studente;
    }

    public void registraEsameSuperato(EsameSuperato esame)
    {
        esamiSuperati.add(esame);
    }

    public double calcolaMedia() {
        if (esamiSuperati.isEmpty()) {
            return 0.0;
        }

        int somma = 0;
        for (EsameSuperato esame : esamiSuperati) {
            somma += (esame.getVoto() == 31) ? 30 : esame.getVoto();
        }

        return (double) somma / esamiSuperati.size();
    }

    //VIOLAZIONE SRP
    public boolean puoLaurearsi()
    {
        return esamiSuperati.size() >= 20 && calcolaMedia() >= 24.0;
    }



    public void stampaEsamiSuperati(Studente studente) {
        System.out.println("Libretto di " + studente.getNomeCompleto());

        for (int i = 0; i < esamiSuperati.size(); i++) {
            String votoString = FormattatoreVoto.formatta(esamiSuperati.get(i).getVoto());
            System.out.println(esamiSuperati.get(i).getEsame() + " - " + votoString);
        }
    }

    public void approvaPianoDiStudi(Studente studente)
    {
        System.out.println("Approvo il piano di studi per lo studente " + studente.getNome());
    }

}
