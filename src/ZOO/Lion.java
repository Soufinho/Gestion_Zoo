package ZOO;

public class Lion extends Animal {

    public Lion(String name,int age) {
        super(name, age);
    }

    public void afficherLion() {
        System.out.println("Animal : " + getName());
        System.out.println("Régime alimentaire : " + getManger());
        System.out.println("Âge : " + getAge() + " ans");
        System.out.println("Sexe : " + getBruit());
        System.out.println("Mode de déplacement : " + getStyle_marche());
    }

    @Override
    public void faireBruit() {
        System.out.println(getName() + " rugit !");
    }

    @Override
    public void seDeplacer() {
        System.out.println(getName() + " marche majestueusement.");
    }
}