package it.unicam.universita.mdp2526.utils;

public class FormattatoreVoto
{
    public static String formatta(int voto)
    {
        return (voto == 31) ? "30 e lode" : String.valueOf(voto);
    }
}
