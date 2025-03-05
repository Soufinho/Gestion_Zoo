package Application;

import java.util.*;

public class GestioZOO {
    private static Zoo zoo = new Zoo();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bienvenue dans le système de gestion du ZOO !");
        boolean running = true;
        while (running) {
            afficherMenuPrincipal();
            int choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1 -> menuGestionZoo();
                case 2 -> zoo.visiterZoo();
                case 3 -> running = false;
                default -> System.out.println("Choix invalide.");
            }
        }
        System.out.println("Merci d'avoir utilisé le système de gestion du ZOO !");
    }

    private static void afficherMenuPrincipal() {
        System.out.println("\n--- Menu Principal ---");
        System.out.println("1. Gérer le zoo");
        System.out.println("2. Visiter le zoo");
        System.out.println("3. Quitter");
        System.out.print("Votre choix : ");
    }

    private static void menuGestionZoo() {
        boolean gestion = true;
        while (gestion) {
            System.out.println("\n--- Menu Gestion du Zoo ---");
            System.out.println("1. Ajouter un animal");
            System.out.println("2. Ajouter un soigneur");
            System.out.println("3. Ajouter un visiteur");
            System.out.println("4. Afficher l'état du zoo");
            System.out.println("5. Passer une journée");
            System.out.println("6. Retour au menu principal");
            System.out.print("Votre choix : ");

            int choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1 -> zoo.ajouterAnimal();
                case 2 -> zoo.ajouterSoigneur();
                case 3 -> zoo.ajouterVisiteur();
                case 4 -> zoo.afficherEtatZoo();
                case 5 -> zoo.gestionJournee();
                case 6 -> gestion = false;
                default -> System.out.println("Choix invalide.");
            }
        }
    }
}

