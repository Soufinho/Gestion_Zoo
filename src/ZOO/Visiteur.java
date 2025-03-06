package ZOO;

public class Visiteur {
    private String nom;
    private boolean estEnfant;

    public Visiteur(String nom, boolean estEnfant) {
        this.nom = nom;
        this.estEnfant = estEnfant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isEnfant() {
        return estEnfant;
    }

    public void setEnfant(boolean enfant) {
        this.estEnfant = enfant;
    }
}
