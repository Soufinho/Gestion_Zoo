package ZOO;

public class Serpent extends Animal {
    public Serpent(String name,int age) {
        super(name, age);
    }



    public void afficherSerpent() {
        System.out.println("Animal : " + getName());
        System.out.println("Régime alimentaire : " + getManger());
        System.out.println("Âge : " + getAge() + " ans");
        System.out.println("Sexe : " + getBruit());
        System.out.println("Mode de déplacement : " + getStyle_marche());
    }

    @Override
    public void faireBruit() {
        System.out.println(getName() + " siffle !");
    }

    @Override
    public void seDeplacer() {
        System.out.println(getName() + " rampe discrètement.");
    }
}
