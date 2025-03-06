package ZOO;

public class Enclos {
    private static String nom;
    private int capacite;
    private static int proprete = 100;

    public Enclos(String nom) {
        this.nom = nom;
        this.capacite = capacite;
    }

    public void degrader() {
        proprete -= 10;
        if (proprete < 0) proprete = 0;
    }

    public void nettoyer() {
        proprete = 100;
        System.out.println("L'enclos " + nom + " a été nettoyé.");
    }

    public int getProprete() {
        return proprete;
    }

    public void setProprete(int proprete) {
        this.proprete = proprete;
    }

    public String getNom() {
        return nom;
    }

    public int getCapacite() {
        return capacite;
    }


    public static void degraderProprete() {
        if (proprete > 0) {
            proprete -= 10;
            System.out.println("L'enclos " + nom + " se dégrade. Propreté : " + proprete + "%");
        }    }
}
