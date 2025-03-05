package ZOO;

public abstract class Animal {
    private String name;
    private String style_marche;
    private String bruit;
    private String manger;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.style_marche = style_marche;
        this.bruit = bruit;
        this.manger = manger;
        this.age = this.age;
    }

    public String getName() {
        return name;
    }
    public String getStyle_marche() {
        return style_marche;
    }
    public String getBruit() {
        return bruit;
    }
    public String getManger() {
        return manger;
    }

    public int getAge() {
        return age;
    }

    public void realiserSpectacle() {
        faireBruit();
        seDeplacer();
    }
    public abstract void faireBruit();
    public abstract void seDeplacer();

}
