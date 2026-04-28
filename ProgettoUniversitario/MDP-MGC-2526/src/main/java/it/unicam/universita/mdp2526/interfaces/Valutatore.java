package it.unicam.universita.mdp2526.interfaces;

import it.unicam.universita.mdp2526.model.Studente;

public interface Valutatore
{
    /**
     *
     * @param studente
     * @return voto tra 18 e 30, oppure 31 per la lode
     */
    int assegnaVoto(Studente studente);
}
