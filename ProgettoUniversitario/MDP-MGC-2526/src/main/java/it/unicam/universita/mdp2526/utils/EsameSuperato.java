package it.unicam.universita.mdp2526.utils;

import it.unicam.universita.mdp2526.model.Esame;

public class EsameSuperato
{
    Esame esame;
    int voto;

    public EsameSuperato(Esame esame, int voto)
    {
        if(esame == null)
        {
            throw new IllegalArgumentException("Esame non valido");
        }
        if(voto < 18 || voto > 31)
        {
            throw new IllegalArgumentException("Voto non valido");
        }

        this.esame = esame;
        this.voto = voto;
    }
    public int getVoto()
    {
        return voto;
    }

    public Esame getEsame()
    {
        return esame;
    }
}
