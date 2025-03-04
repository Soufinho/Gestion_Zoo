package ZOO;

public class Lion extends Animal {

    public Lion(String name, String style_marche, String bruit, String manger) {
        super(name, style_marche, bruit, manger);
    }

    public void afficherLion() {
        System.out.println("Animal : " + getName());
        System.out.println("Régime alimentaire : " + getManger());
        System.out.println("Âge : " + getAge() + " ans");
        System.out.println("Sexe : " + getBruit());
        System.out.println("Mode de déplacement : " + getStyle_marche());
    }

    public void lionBruit(){
        System.out.println("Le lion rugi!");
        System.out.println("ROOOAAAAARRRRR!!!");
    }

    public void lionMarche(){
        System.out.println("Le lion marche!");

    }
}
