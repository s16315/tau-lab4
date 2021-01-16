package gamesCatalog;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

public class GamesServiceTests {
	private GamesService gamesService;
	private Game game0; 
	private Game game1;
	private Game game2;
	
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
	public void testCreate() {
		gamesService.create(game0);
		Game result = gamesService.readById(game0.getId());
		assertSame(result.getName(), game0.getName());
		assertSame(result.getPegi(), game0.getPegi());
		System.out.println("Creating a game ok");
	}	

	@Test
	public void testCreateCatchBadId() {
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
	public void testUpdate() {
		gamesService.create(game0);
		game1.setId(game0.getId());
		gamesService.update(game1);
		Game result = gamesService.readById(game0.getId());
		assertNotSame(result.getName(), game0.getName());
		assertNotSame(result.getPegi(), game0.getPegi());		
		System.out.println("Updating a game ok");
	}		
	
	@Test
	public void testDelete() {
		gamesService.create(game0);
		gamesService.delete(game0);
		ArrayList<Game> result = gamesService.readAll();
		assertEquals(result.size(), 0);
		System.out.println("Deleting a game ok");
	}	
	

	
	
}
