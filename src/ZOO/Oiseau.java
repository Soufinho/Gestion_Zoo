package ZOO;

public class Oiseau extends Animal {
    public Oiseau(String name,int age) {
        super(name, age);
}

    public void afficherOiseau() {
        System.out.println("Animal : " + getName());
        System.out.println("Régime alimentaire : " + getManger());
        System.out.println("Âge : " + getAge() + " ans");
        System.out.println("Sexe : " + getBruit());
        System.out.println("Mode de déplacement : " + getStyle_marche());
    }

    @Override
    public void faireBruit() {
        System.out.println(getName() + " chante !");
    }

    @Override
    public void seDeplacer() {
        System.out.println(getName() + " vole dans le ciel.");
    }
}
