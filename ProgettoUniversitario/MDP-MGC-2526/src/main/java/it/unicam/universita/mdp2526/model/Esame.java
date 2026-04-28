package it.unicam.universita.mdp2526.model;

import it.unicam.universita.mdp2526.interfaces.Valutatore;
import it.unicam.universita.mdp2526.utils.EsameSuperato;
import it.unicam.universita.mdp2526.utils.FormattatoreVoto;

public class Esame
{
    private String nome;
    private Valutatore valutatore;

    public Esame(String nome, Valutatore valutatore) {
        setNome(nome);
        setValutatore(valutatore);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome esame non valido");
        }
        this.nome = nome;
    }

    public Valutatore getValutatore() {
        return valutatore;
    }

    public void setValutatore(Valutatore valutatore) {
        if (valutatore == null) {
            throw new IllegalArgumentException("Valutatore non valido");
        }
        this.valutatore = valutatore;
    }


    public void sostieniEsame(Studente studente) {
        if (studente == null) {
            throw new IllegalArgumentException("Studente non valido");
        }

        int voto = valutatore.assegnaVoto(studente);
        stampaEsame(studente, voto);

        if(esameSuperato(voto))
        {
//            registraEsito(studente, voto);
            stampaEsameRegistrato();
        }
        else
        {
            stampaEsameNonSuperato();
        }
    }

    private void stampaEsameRegistrato()
    {
        System.out.println("Esame registrato nel libretto");
    }

    private void stampaEsameNonSuperato()
    {
        System.out.println("Esame non registrato sul libretto");
    }

//    private void registraEsito(Studente studente, int voto)
//    {
//        studente.getLibretto().registraEsameSuperato(this, voto);
//    }

    private boolean esameSuperato(int voto)
    {
        return (voto >= 18 && voto <= 30) || voto == 31;
    }

    private void stampaEsame(Studente studente, int voto)
    {
        System.out.println("Esame di " + nome);
        System.out.println("Studente: " + studente.getNomeCompleto());
        System.out.println("Voto assegnato: " + FormattatoreVoto.formatta(voto));
    }
}