package controller;

import java.util.Scanner;

/**
 * Deze applicatie is bedoeld om de premie te berekenen van een arbeidsongeschiktheidsverzekering voor medewerkers
 * van een bedrijf.
 */

public class Tentamen {
    public static void main(String[] args) {
        //Naam uitprinten
        System.out.println("Dit tentamen is gemaakt door Jan Sagel, studentnummer: 4410661");
        Scanner invoer = new Scanner(System.in);

        //Vragen om het aantal medewerkers
        System.out.println("Voor hoeveel medewerkers wilt u een verzekering afsluiten (1 --- 10?)");
        int aantalMedewerkers = invoer.nextInt();

        //Foutbehandeling voor als niet het correct aantal medewerkers is ingevuld
        while (aantalMedewerkers < 0 || aantalMedewerkers > 10) {
            System.out.println("Foute invoer! Geef een waarde tussen 1 en 10!");
            System.out.println("Voer nogmaals het aantal in: ");
            aantalMedewerkers = invoer.nextInt();
        }
        //Arrays declareren en maken om data op te slaan
        String[] medewerkerNaam = new String[aantalMedewerkers];
        int[] salarisMedewerker = new int[aantalMedewerkers];
        double[] premieMedewerker = new double[aantalMedewerkers];

        for (int i = 0; i < aantalMedewerkers; i++) {
            System.out.println("Medewerker " + (i + 1));
            System.out.print("\t\t Geef de medewerkerscode: ");
            medewerkerNaam[i] = invoer.next();
            System.out.print("\t\t Geef het bruto maandsalaris: ");
            salarisMedewerker[i] = invoer.nextInt();
        }

        //Methode aanroepen om de premie te berekenen op basis van opgegeven gegevens
        for (int i = 0; i < aantalMedewerkers; i++) {
            premieMedewerker[i] = berekenPremie(salarisMedewerker[i]);}

        //Overzicht van alle resultaten weergeven
        System.out.println("Verzekeringsoverzicht");
        System.out.printf("%9s%9s%9s\n","Medewerker", "Salaris", "Premie");
        for (int j = 0; j < aantalMedewerkers; j++) {
            System.out.printf("%s%8d%10.2f\n", medewerkerNaam[j], salarisMedewerker[j], premieMedewerker[j]);}

        //Totaalbedrag berekenen
        double totaalBedrag = 0.0;
        for (int i = 0; i < aantalMedewerkers; i++) {
            totaalBedrag += premieMedewerker[i];
        }

        System.out.println();
        System.out.println("De totale premie is: " + totaalBedrag);

    }
    //Methode op de premie te berekenen
    public static double berekenPremie(double premie) {
        final int MINIMUM_PREMIE = 50;
        final int MAXIMUM_PREMIE = 180;

        premie= ((premie/100)*3.5);
       double resultaat= premie;



        if (resultaat < MINIMUM_PREMIE) {
            return MINIMUM_PREMIE;
        }
        if (premie > MAXIMUM_PREMIE) {
            return MAXIMUM_PREMIE;
        } else {
            return premie;

        }


    }
}

