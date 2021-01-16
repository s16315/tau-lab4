package gamesCatalog;
import java.util.ArrayList;

public class GamesService implements IGamesService<Game>  {
    private ArrayList<Game> gamesList;

    GamesService(ArrayList<Game> gamesList) {
        this.gamesList = gamesList;
    }

    public long create(Game game) {
        for (Game g: this.gamesList) {
            if (g.getId()==game.getId()){
                throw new IllegalArgumentException("Existing Id!");
            }
        }
        this.gamesList.add(new Game(game.getName(), game.getPegi(), game.getHaveDemo(), game.getDescription(), game.getId()));

        return game.getId();
    }

    public ArrayList<Game> readAll() {
        return this.gamesList;
    }

    public Game readById(long id) {
        for (Game g: this.gamesList) {
            if (g.getId()== id){
                return g;
            }
        }
        throw new IllegalArgumentException("Not existing Id!");
    }

    public void update(Game game) {
        Game gameEntity = this.readById(game.getId());
        gameEntity.setDescription(game.getDescription());
        gameEntity.setName(game.getName());
        gameEntity.setPegi(game.getPegi());
        gameEntity.setHaveDemo(game.getHaveDemo());
    }

    public void delete(Game game) {
        Game gameEntity = this.readById(game.getId());
        this.gamesList.remove(gameEntity);
    }
}
