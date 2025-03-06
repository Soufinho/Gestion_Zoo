package ZOO;

import java.util.Locale;
import java.util.Random;

public class Soigneur {
    private String nom;
    private String specialite;
    private boolean occupe;

    public Soigneur(String nom, String specialite) {
        this.nom = nom;
        this.specialite = specialite;
    }

    public String getNom() {
        return nom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void diagnostiquerAnimal(Animal animal) {
        if (new Random().nextBoolean()) {
            System.out.println(nom + " a diagnostiqué une maladie pour " + animal.getName());
        } else {
            System.out.println(nom + " n'a trouvé aucune maladie pour " + animal.getName());
        }
    }

    public void soignerAnimal(Animal animal) {
        System.out.println(nom + " soigne " + animal.getName());
    }

    public void nettoyerEnclos(Enclos enclos) {
        System.out.println(nom + " nettoie l'enclos : " + enclos.getNom());
        enclos.setProprete(100);
        occupe = true;
    }

    public boolean isOccupe() {
        return occupe;
    }

    public void liberer() {
        occupe = false;
    }

    public boolean diagnostiquer(Animal animal) {
        return false;
    }

    public void soigner(Animal animal) {
        return ;
    }



}
