package pl.gamesCatalog;

public class Dlc extends Entity{
    private String name;
    private int pegi;
    private String description;
    private long masterGameId;

    public Dlc(String name, int pegi, String description, long masterGameId, long id) {
        this.name = name;
        this.pegi = pegi;
        this.description = description;
        this.masterGameId = masterGameId;
        this.setId(id);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPegi(int pegi) {
        this.pegi = pegi;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMasterGame(long masterGameId) {
        this.masterGameId = masterGameId;
    }

    public String getName() {
        return this.name;
    }

    public int getPegi() {
        return this.pegi;
    }

    public String getDescription() {
        return this.description;
    }

    public Long getMasterGame() {
        return this.masterGameId;
    }
}
