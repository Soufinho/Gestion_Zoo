package ZOO;

public class Enclos {
    private String nom;
    private int capacite;
    private int propreté = 100;

    public Enclos(String nom, int capacite) {
        this.nom = nom;
        this.capacite = capacite;
    }

    public void degrader() {
        propreté -= 10;
        if (propreté < 0) propreté = 0;
    }

    public void nettoyer() {
        propreté = 100;
        System.out.println("L'enclos " + nom + " a été nettoyé.");
    }

    public int getProprete() {
        return propreté;
    }
}
