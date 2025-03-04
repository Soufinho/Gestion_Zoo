package ZOO;

public class Soigneur {
    private String nom;
    private String prenom;
    private String specialite;

    public Soigneur(String nom, String prenom, String specialite) {
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
    }

    public void diagnostic(){
        System.out.println(nom + " " + prenom + " réalise un diagnostique.");

    }

    public void soigner(){

    }
}
