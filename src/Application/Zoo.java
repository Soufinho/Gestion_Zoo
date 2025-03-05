package Application;

import ZOO.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zoo {
    private List<Animal> animaux = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void ajouterAnimal() {
        System.out.println("Quel type d'animal souhaitez-vous ajouter ? (lion, oiseau, serpent)");
        String type = scanner.nextLine().toLowerCase();
        System.out.print("Nom de l'animal : ");
        String nom = scanner.nextLine();
        System.out.print("Âge de l'animal : ");
        int age = scanner.nextInt();
        scanner.nextLine();

        switch (type) {
            case "lion" -> animaux.add(new Lion(nom, age));
            case "oiseau" -> animaux.add(new Oiseau(nom, age));
            case "serpent" -> animaux.add(new Serpent(nom, age));
            default -> System.out.println("Type d'animal inconnu.");
        }
    }

    public void ajouterSoigneur() {
        System.out.print("Nom du soigneur : ");
        String nom = scanner.nextLine();
        System.out.print("Spécialité du soigneur (lion, oiseau, serpent) : ");
        String specialite = scanner.nextLine();
        System.out.println("Soigneur ajouté : " + nom + " spécialisé en " + specialite);
    }

    public void ajouterVisiteur() {
        System.out.print("Nom du visiteur : ");
        String nom = scanner.nextLine();
        System.out.print("Le visiteur est-il un enfant ? (oui/non) : ");
        boolean estEnfant = scanner.nextLine().equalsIgnoreCase("oui");
        System.out.println("Visiteur ajouté : " + nom + (estEnfant ? " (Enfant)" : " (Adulte)"));
    }

    public void afficherEtatZoo() {
        System.out.println("Le zoo contient " + animaux.size() + " animaux.");
        for (Animal animal : animaux) {
            System.out.println("- " + animal.getName() + " (" + animal.getClass().getSimpleName() + ")");
        }
    }

    public void gestionJournee() {
        System.out.println("Une nouvelle journée commence au zoo.");
        if (animaux.isEmpty()) {
            System.out.println("Aucun animal dans le zoo aujourd'hui.");
            return;
        }
        System.out.println("Les animaux réalisent leurs activités quotidiennes :");
        for (Animal animal : animaux) {
            animal.realiserSpectacle();
        }
    }

    public void visiterZoo() {
        System.out.println("\n--- Visiter le zoo ---");
        System.out.println("1. Visiter l'enclos des lions");
        System.out.println("2. Visiter l'enclos des oiseaux");
        System.out.println("3. Visiter l'enclos des serpents");
        System.out.println("4. Retour au menu principal");
        System.out.print("Votre choix : ");

        int choix = scanner.nextInt();
        scanner.nextLine();
        switch (choix) {
            case 1 -> afficherEnclos(Lion.class);
            case 2 -> afficherEnclos(Oiseau.class);
            case 3 -> afficherEnclos(Serpent.class);
            case 4 -> System.out.println("Retour au menu principal");
            default -> System.out.println("Choix invalide.");
        }
    }

    private void afficherEnclos(Class<? extends Animal> typeAnimal) {
        System.out.println("Voici les animaux dans cet enclos :");
        List<Animal> animauxEnclos = new ArrayList<>();
        for (Animal animal : animaux) {
            if (typeAnimal.isInstance(animal)) {
                animauxEnclos.add(animal);
                System.out.println("- " + animal.getName());
            }
        }
        if (animauxEnclos.isEmpty()) {
            System.out.println("Aucun animal dans cet enclos.");
            return;
        }
        System.out.print("Entrez le numéro d'un animal pour voir son spectacle ou 0 pour revenir : ");
        int choix = scanner.nextInt();
        scanner.nextLine();
        if (choix > 0 && choix <= animauxEnclos.size()) {
            Animal animal = animauxEnclos.get(choix - 1);
            System.out.println("Vous assistez à un spectacle de " + animal.getName() + " !");
            animal.realiserSpectacle();
        } else if (choix != 0) {
            System.out.println("Choix invalide.");
        }
    }
}
