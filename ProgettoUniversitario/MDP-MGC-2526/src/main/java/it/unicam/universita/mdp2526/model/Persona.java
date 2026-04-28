package it.unicam.universita.mdp2526.model;

public abstract class Persona {

    private String nome;
    private String cognome;

    public Persona(String nome, String cognome) {
        setNome(nome);
        setCognome(cognome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome non valido");
        }
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        if (cognome == null || cognome.isBlank()) {
            throw new IllegalArgumentException("Cognome non valido");
        }
        this.cognome = cognome;
    }

    public String getNomeCompleto() {
        return nome + " " + cognome;
    }

    public abstract void presentati();
}