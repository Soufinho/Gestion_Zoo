package Application;

import ZOO.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zoo {
    private List<Animal> animaux = new ArrayList<>();
    private List<Enclos> enclosList = new ArrayList<>(); // Liste des enclos
    private List<Soigneur> soigneurs = new ArrayList<>(); // Liste des soigneurs
    private List<Visiteur> visiteurs = new ArrayList<>(); // Liste des visiteurs
    private Scanner scanner = new Scanner(System.in);

    // Méthode pour ajouter un animal au zoo
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

    // Méthode pour ajouter un visiteur au zoo
    public void ajouterVisiteur() {
        System.out.print("Nom du visiteur : ");
        String nom = scanner.nextLine();
        System.out.print("Le visiteur est-il un enfant ? (oui/non) : ");
        boolean estEnfant = scanner.nextLine().equalsIgnoreCase("oui");

        // Ajout du visiteur à la liste
        Visiteur visiteur = new Visiteur(nom, estEnfant);
        visiteurs.add(visiteur);

        System.out.println("Visiteur ajouté : " + nom + (estEnfant ? " (Enfant)" : " (Adulte)"));
    }

    // Méthode pour ajouter un soigneur
    public void ajouterSoigneur() {
        System.out.print("Nom du soigneur : ");
        String nom = scanner.nextLine();
        System.out.print("Spécialité du soigneur (lion, oiseau, serpent) : ");
        String specialite = scanner.nextLine();

        // Ajout du soigneur
        Soigneur soigneur = new Soigneur(nom, specialite);
        soigneurs.add(soigneur);
        System.out.println("Soigneur ajouté : " + nom + " (spécialisé en : " + specialite + ")");
    }

    // Méthode pour ajouter un enclos au zoo
    public void ajouterEnclos() {
        System.out.print("Nom de l'enclos : ");
        String nom = scanner.nextLine();

        // Création et ajout de l'enclos
        Enclos enclos = new Enclos(nom);
        enclosList.add(enclos);
        System.out.println("Enclos ajouté : " + nom);
    }

    // Méthode pour afficher l'état complet du zoo
    public void afficherEtatZoo() {
        System.out.println("\n--- Etat du Zoo ---");

        System.out.println("\nAnimaux :");
        for (Animal animal : animaux) {
            System.out.println("- " + animal.getName() + " (" + animal.getClass().getSimpleName() + ")");
        }

        System.out.println("\nEnclos :");
        for (Enclos enclos : enclosList) {
            System.out.println("- " + enclos.getNom());
        }

        System.out.println("\nSoigneurs :");
        for (Soigneur soigneur : soigneurs) {
            System.out.println("- " + soigneur.getNom() + " (spécialisé en : " + soigneur.getSpecialite() + ")");
        }

        System.out.println("\nVisiteurs présents :");
        for (Visiteur visiteur : visiteurs) {
            System.out.println("- " + visiteur.getNom() + (visiteur.isEnfant() ? " (Enfant)" : " (Adulte)"));
        }
    }

    // Méthode pour visiter un enclos
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
        System.out.print("Entrez le numéro d'un animal à observer ou 0 pour revenir : ");
        int choix = scanner.nextInt();
        scanner.nextLine();
        if (choix > 0 && choix <= animauxEnclos.size()) {
            Animal animal = animauxEnclos.get(choix - 1);
            System.out.println("Vous observez " + animal.getName() + " !");
        } else if (choix != 0) {
            System.out.println("Choix invalide.");
        }
    }

    // Méthode pour nettoyer un enclos avec un soigneur
    public void nettoyerEnclos() {
        System.out.print("Nom du soigneur : ");
        String nomSoigneur = scanner.nextLine();

        // Recherche du soigneur
        Soigneur soigneur = null;
        for (Soigneur s : soigneurs) {
            if (s.getNom().equalsIgnoreCase(nomSoigneur) && !s.isOccupe()) {
                soigneur = s;
                break;
            }
        }
        if (soigneur == null) {
            System.out.println("Erreur : Aucun soigneur trouvé ou il est déjà occupé.");
            return;
        }

        System.out.print("Nom de l'enclos à nettoyer : ");
        String nomEnclos = scanner.nextLine();

        // Recherche de l'enclos
        Enclos enclos = null;
        for (Enclos e : enclosList) {
            if (e.getNom().equalsIgnoreCase(nomEnclos)) {
                enclos = e;
                break;
            }
        }
        if (enclos == null) {
            System.out.println("Erreur : Aucun enclos trouvé avec ce nom.");
            return;
        }

        // Nettoyage
        soigneur.nettoyerEnclos(enclos);
        System.out.println("L'enclos \"" + nomEnclos + "\" a été nettoyé par " + nomSoigneur + ".");
    }

    // Méthode pour gérer le soin d'un animal
    public void soignerAnimal() {
        System.out.print("Nom du soigneur : ");
        String nomSoigneur = scanner.nextLine();

        // Recherche du soigneur
        Soigneur soigneur = null;
        for (Soigneur s : soigneurs) {
            if (s.getNom().equalsIgnoreCase(nomSoigneur) && !s.isOccupe()) {
                soigneur = s;
                break;
            }
        }
        if (soigneur == null) {
            System.out.println("Erreur : Aucun soigneur trouvé ou il est déjà occupé.");
            return;
        }

        System.out.print("Nom de l'animal à soigner : ");
        String nomAnimal = scanner.nextLine();

        // Recherche de l'animal
        Animal animal = null;
        for (Animal a : animaux) {
            if (a.getName().equalsIgnoreCase(nomAnimal)) {
                animal = a;
                break;
            }
        }
        if (animal == null) {
            System.out.println("Erreur : Aucun animal trouvé avec ce nom.");
            return;
        }

        // Vérification spécialité
        if (!soigneur.getSpecialite().equalsIgnoreCase(animal.getClass().getSimpleName())) {
            System.out.println("Erreur : Le soigneur ne peut pas s'occuper de cet animal.");
            return;
        }

        // Diagnostic et soin
        if (soigneur.diagnostiquer(animal)) {
            soigneur.soigner(animal);
            System.out.println("L'animal \"" + nomAnimal + "\" a été soigné par " + nomSoigneur + ".");
        } else {
            System.out.println("L'animal n'est pas malade, aucun soin nécessaire.");
        }
    }

    // Méthode pour gérer une journée complète
    public void gestionJournee() {
        System.out.println("\n--- Début d'une nouvelle journée ---");
        for (Enclos enclos : enclosList) {
            enclos.degraderProprete();
        }
        for (Soigneur soigneur : soigneurs) {
            soigneur.liberer();
        }
        System.out.println("Une nouvelle journée commence, tous les soigneurs sont disponibles.");
    }
}