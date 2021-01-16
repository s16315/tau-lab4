package pl.gamesCatalog;

import java.util.ArrayList;

public class Game extends Entity{
    private String name;
    private int pegi;
    private Boolean haveDemo;
    private String description;
    private ArrayList<Dlc> dlcs;


    public Game(String name, int pegi, long id) {
        this.name = name;
        this.setPegi(pegi);
        this.haveDemo = false;
        this.description = " ";
        this.setId(id);
    }

    public Game(String name, int pegi, Boolean haveDemo, String description, long id) {
        this.name = name;
        this.setPegi(pegi);
        this.haveDemo = haveDemo;
        this.description = description;
        this.setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPegi() {
        return pegi;
    }

    public void setPegi(int pegi) {
        if (pegi < 0 || pegi > 18) throw new IllegalArgumentException("Incorrect PEGI!");
        this.pegi = pegi;
    }

    public Boolean getHaveDemo() {
        return haveDemo;
    }

    public void setHaveDemo(Boolean haveDemo) {
        this.haveDemo = haveDemo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addDlc(Dlc dlc){
        this.dlcs.add(dlc);
    }

    public ArrayList<Dlc> getAllDlc(){
        return this.dlcs;
    }

    public Dlc getDlcById(long id){
        for (Dlc d: this.dlcs){
            if (d.getId() == id){
                return d;
            }
        }
        throw new IllegalArgumentException("Not existing Id!");
    }
}
