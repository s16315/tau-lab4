package pl.gamesCatalog;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import org.junit.*;


public class GamesServiceTests {
	private GamesService gamesService;
	private Game game0;
	private Game game1;
	private Game game2;
	private Dlc game1Dlc1;
	private Dlc game2Dlc1;

	@Before
	public void setUp(){
		game0 = new Game("Szybkersi", 10, 0);
		game1 = new Game("Malowanki", 3, 1);
		game2 = new Game("Hero", 18, 2);
		gamesService = new GamesService(new ArrayList<Game>());
		System.out.println("Before");
	}
	
	@After
	public void tearDown(){
		gamesService = null;
		game0 = null;
		game1 = null;
		game2 = null;
		System.out.println("After");
	}

	@Test
	public void testDlcInGame(){
		Game tempGame = mock(Game.class);
		Dlc tempGameDlc1 = new Dlc("Dodatek1", 12, "Świetny dodatek", tempGame.getId(), 1);
		Dlc tempGameDlc2 = new Dlc("Dodatek2", 11, "Słaby dodatek", tempGame.getId(), 2);
		tempGame.addDlc(tempGameDlc1);
		tempGame.addDlc(tempGameDlc2);
		assertEquals(tempGameDlc1, tempGame.getDlcById(tempGameDlc1.getId()));
		System.out.println("Getting a dls by id is ok");
	}

	@Test
	public void testCreateGame() {
		gamesService.create(game0);
		Game result = gamesService.readById(game0.getId());
		assertSame(result.getName(), game0.getName());
		assertSame(result.getPegi(), game0.getPegi());
		System.out.println("Creating a game ok");
	}	

	@Test
	public void testCreateGameCatchBadId() {
		gamesService.create(game0);
		
		try {
			gamesService.create(game0);
			fail("No exception");
		}
		catch(IllegalArgumentException e) {
			System.out.println("Catch bad id in game creating ok");	
		}	
		
	}		
	
	@Test
	public void testUpdateGame() {
		gamesService.create(game0);
		game1.setId(game0.getId());
		gamesService.update(game1);
		Game result = gamesService.readById(game0.getId());
		assertNotSame(result.getName(), game0.getName());
		assertNotSame(result.getPegi(), game0.getPegi());		
		System.out.println("Updating a game ok");
	}		
	
	@Test
	public void testDeleteGame() {
		gamesService.create(game0);
		gamesService.delete(game0);
		ArrayList<Game> result = gamesService.readAll();
		assertEquals(result.size(), 0);
		System.out.println("Deleting a game ok");
	}	
	

	
	
}
