package ZOO;

public class Serpent extends Animal {
    public Serpent(String name, String style_marche, String bruit, String manger) {
        super(name, style_marche, bruit, manger);
    }

    public void afficherSerpent() {
        System.out.println("Animal : " + getName());
        System.out.println("Régime alimentaire : " + getManger());
        System.out.println("Âge : " + getAge() + " ans");
        System.out.println("Sexe : " + getBruit());
        System.out.println("Mode de déplacement : " + getStyle_marche());
    }
}
