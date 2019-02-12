package tp4actions;

import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        ActionSimple apple = new ActionSimple("Apple");
        ActionSimple google = new ActionSimple("Google");
        ActionSimple microsoft = new ActionSimple("Microsoft");

        ActionComposee big3 = new ActionComposee("Big 3");

        try {
            big3.add(apple, 0.35);
        } catch (ExceptionActionComposee e2) {
            e2.printStackTrace();
        }
        try {
            big3.add(google, 0.35);
        } catch (ExceptionActionComposee e2) {
            e2.printStackTrace();
        }
        try {
            big3.add(microsoft, 0.40);
        } catch (ExceptionActionComposee e2) {
            e2.printStackTrace();
        }
        try {
            big3.add(microsoft, 0.30);
        } catch (ExceptionActionComposee e2) {
            e2.printStackTrace();
        }

        Portefeuille richesse = new Portefeuille("Richesse");
        try {
            richesse.acheter(apple, 50);
        } catch (ExceptionPortefeuille e) {
            e.printStackTrace();
        }

        try {
            richesse.acheter(google, 450);
        } catch (ExceptionPortefeuille e) {
            e.printStackTrace();
        }

        try {
            richesse.acheter(big3, 740);
        } catch (ExceptionPortefeuille e) {
            e.printStackTrace();
        }

        System.out.println(richesse);
        System.out.println("\n");

        try {
            Thread.sleep(5);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        try {
            richesse.vendre(apple, 200);
        } catch (ExceptionPortefeuille e) {
            e.printStackTrace();
        }

        try {
            richesse.vendre(microsoft, 200);
        } catch (ExceptionPortefeuille e) {
            e.printStackTrace();
        }

        System.out.println("\n___________________\n");

        Date cinqMai2017 = new Date(5, 5, 2016);
        System.out.println("Valeurs du : " + cinqMai2017 + "\n");

        System.out.println(google + " : " + google.getValeur(cinqMai2017));

        try {
            System.out.println(big3 + " : " + big3.getValeur(cinqMai2017));
        } catch (ExceptionActionComposee e) {
            e.printStackTrace();
        }

        System.out.println("\n" + richesse + "\nValeur : " + richesse.getValeur(cinqMai2017));

        System.out.println("\n___________________\n");

        System.out.println("Dernières valeurs et date associée quand c'est possible : \n");
        System.out.println(google + " le " + google.getDerDate() + " : " + google.getDerValeur());

        try {
            System.out.println(big3 + " : " + big3.getDerValeur());
        } catch (ExceptionActionComposee e) {
            e.printStackTrace();
        }

        System.out.println("\n" + richesse + "\nValeur : " + richesse.getDerValeur());

        System.out.println("\n___________________\n");

        System.out.println("Evolution de l'" + apple + " : \n");

        Calendar debCal = Calendar.getInstance();
        debCal.set(2017, 0, 1);

        Calendar endCal = Calendar.getInstance();

        while (endCal.after(debCal)) {
            int jour = debCal.get(Calendar.DATE);
            int mois = debCal.get(Calendar.MONTH) + 1;
            int annee = debCal.get(Calendar.YEAR);
            Date uneDate = new Date(jour, mois, annee);
            System.out.println(uneDate + " : " + apple.getValeur(uneDate) + "�");
            debCal.add(Calendar.MONTH, 1);
        }
    }
    // TEST 

}
