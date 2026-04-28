package it.unicam.universita.mdp2526.test;

import it.unicam.universita.mdp2526.interfaces.Valutatore;
import it.unicam.universita.mdp2526.model.Studente;

public class ValutatoreStrano implements Valutatore
{
    //VIOLAZIONE LSP
    @Override
    public int assegnaVoto(Studente studente)
    {
        return -10;
    }
}
