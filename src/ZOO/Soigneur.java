package ZOO;

import java.util.Random;

public class Soigneur {
    private String nom;
    private String specialite;

    public Soigneur(String nom, String specialite) {
        this.nom = nom;
        this.specialite = specialite;
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
}
