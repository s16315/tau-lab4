package gamesCatalog;
import java.util.ArrayList;

@SuppressWarnings("hiding")
public interface IGamesService <Game>  {
    public long create(Game game);
    public ArrayList<Game> readAll();
    public Game readById(long id);
    public void update(Game game);
    public void delete(Game game);
}
