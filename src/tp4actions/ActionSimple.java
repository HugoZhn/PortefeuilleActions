package tp4actions;

import java.util.Calendar;
import java.util.HashMap;

public class ActionSimple extends Action {

    private HashMap<Date, Double> cours;

    // Constructeur
    public ActionSimple(String lib) {
        this.libelle = lib;
        this.cours = new HashMap<Date, Double>();

        // G�n�re des cours al�atoires pour tout les jours depuis 2017
        Calendar debCal = Calendar.getInstance();
        debCal.set(2017, 0, 1);

        Calendar endCal = Calendar.getInstance();

        while (endCal.after(debCal)) {
            int jour = debCal.get(Calendar.DATE);
            int mois = debCal.get(Calendar.MONTH) + 1;
            int annee = debCal.get(Calendar.YEAR);
            Date d = new Date(jour, mois, annee);
            double rnd = Math.random() * 200;
            rnd = (double) Math.round(rnd * 100) / 100;
            this.cours.put(d, rnd);

            debCal.add(Calendar.DATE, 1);
        }
    }

    // Getters
    public String getLibelle() {
        return this.libelle;
    }

    public HashMap<Date, Double> getCours() {
        return this.cours;
    }

    // Cr�� un cours pour la date du jour
    public void addCours(double cours) {
        Date today = new Date();
        this.cours.put(today, cours);
    }

    // Cr�� un cours � une date donn�e
    public void addCours(Date d, double cours) {
        this.cours.put(d, cours);
    }

    // D�finition de la m�thode abstraite permettant d'obtenir le cours � une date donn�e
    @Override
    public double getValeur(Date d) {
        double valeur = -1;
        if (this.cours.containsKey(d)) {
            valeur = this.cours.get(d);
        } else {
            d = this.plusProcheNonVide(d);
            if (d != null) {
                valeur = this.cours.get(d);
            }
        }
        return valeur;
    }

    private Date plusProcheNonVide(Date dateDep) {
        boolean found;
        int i;
        int indexDep = dateDep.getToInt();
        Date dateRet = null;
        for (i = 0, found = false; i < indexDep && !found; i++) {
            Date d = Date.fromInt(indexDep - i);
            if (this.cours.containsKey(d)) {
                dateRet = d;
                found = true;
            }
        }
        return dateRet;
    }

    // Renvoie la derni�re date poss�dant un cours
    public Date getDerDate() {
        int maxIndex = -1;
        Date maxDate = null;
        for (Date d : this.cours.keySet()) {
            if (d.getToInt() > maxIndex) {
                maxDate = d;
            }
        }
        return maxDate;
    }

    // Renvoie la valeur de la deni�re date poss�dant un cours
    public double getDerValeur() {
        Date maxDate = this.getDerDate();
        return this.cours.get(maxDate);
    }

    public String toString() {
        return "Action '" + this.libelle + "'";
    }

}
