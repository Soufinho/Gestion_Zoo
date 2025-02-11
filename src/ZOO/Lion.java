package ZOO;

public class Lion extends Animal {
    private String name;
    private String style_marche;
    private String bruit;
    private String manger;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getStyle_marche() {
        return style_marche;
    }

    public void setStyle_marche(String style_marche) {
        this.style_marche = style_marche;
    }

    public String getBruit() {
        return bruit;
    }

    public void setBruit(String bruit) {
        this.bruit = bruit;
    }

    public String getManger() {
        return manger;
    }

    public void setManger(String manger) {
        this.manger = manger;
    }
}
