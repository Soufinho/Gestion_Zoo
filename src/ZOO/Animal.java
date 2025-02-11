package ZOO;

public class Animal {
    private String name;
    private String style_marche;
    private String bruit;
    private String manger;

    public Animal(String name, String style_marche, String bruit, String manger) {
        this.name = name;
        this.style_marche = style_marche;
        this.bruit = bruit;
        this.manger = manger;
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
    public void setName(String name) {
        this.name = name;
    }
    public void setStyle_marche(String style_marche) {
        this.style_marche = style_marche;
    }
    public void setBruit(String bruit) {
        this.bruit = bruit;
    }
    public void setManger(String manger) {
        this.manger = manger;
    }

}
