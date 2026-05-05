package it.unicam.universita.mdp2526;

import it.unicam.universita.mdp2526.interfaces.Valutatore;
import it.unicam.universita.mdp2526.model.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gson.Gson;
import it.unicam.universita.mdp2526.utils.EsameSuperato;

import javax.lang.model.util.ElementScanner6;

public class Main {

    public static void main(String[] args)
    {
        //2° MAIN
        Studente s1 = new Studente("Kevin", "Ferrari", 130668);
        Professore p1 = new Professore("Luca", "Bianchi", "Informatica");

        Esame esame1 = new Esame("Programmazione", p1);
        Esame esame2 = new Esame("Fondamenti", p1);

        s1.getLibretto().registraEsameSuperato(esame1, 18);
        s1.getLibretto().registraEsameSuperato(esame2, 30);
        int voto = s1.getLibretto().getVoto(new Esame("Programmazione", p1));

        System.out.println("Voto trovato: " + voto);
//
//        Corso corso = new Corso("Metodologie di Programmazione", p1);
//        Studente s1 = new Studente("Anna", "Rossi", 1001);
//
//        //EFFETTO DI EQUALS SULLE COLLEZIONI
//        Studente s2 = new Studente("Anna", "Rossi", 1001);
//        Set<Studente> iscritti = new HashSet<>();
//        iscritti.add(s1);
//        iscritti.add(s2);
//        //System.out.println(iscritti.contains(s2)); //--> true
//        //iscritti.remove(s2);
//        System.out.println(iscritti.size()); //--> 0 con equals perchè lo rimuove, altrimenti non rimuove nulla
//        //System.out.println(iscritti.indexOf(s2)); //--> 0 con equals, -1 altrimenti
//
//
//        Gson gson = new Gson();
//        Gson gson2 = new Gson();
//        //FILEREADER
//        Studente studenteDaJsonFS;
//        try ( FileReader reader = new FileReader("C:\\Users\\win 11\\Desktop\\ProgettoUniversitario\\MetodologieProgettoScolastico\\ProgettoUniversitario\\MDP-MGC-2526\\src\\main\\resources\\studente.json")) {
//            studenteDaJsonFS = gson.fromJson(reader, Studente.class);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        //INPUTSTREAM
//        InputStream is2 = Main.class.getClassLoader().getResourceAsStream("studente.json"); //legge byte
//        InputStreamReader reader2 = new InputStreamReader(is2); //li trasforma in caratteri
//        Studente studenteDaJsonResources = gson2.fromJson(reader2, Studente.class);
//
//        corso.iscriviStudente(s1);
//        corso.iscriviStudente(s1);
//        corso.stampaIscritti();
//
//        s1.presentati();
//        p1.presentati();
//
//        System.out.println(studenteDaJsonFS.equals(studenteDaJsonResources));
//        System.out.println(studenteDaJsonFS.equals(s1));
//        System.out.println(s1.equals(studenteDaJsonResources));


    }
}