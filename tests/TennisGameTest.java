import static org.junit.Assert.*;
import org.junit.Test;
import jdk.nashorn.internal.ir.annotations.Ignore;

public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"
	@Test
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player1Scored();			
	}
	
	//mine
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player2WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		// This statement should cause an exception
		game.player2Scored();			
	}
	
	//mine
	@Test
	public void testTennisGame_Player1WinsCheckGameEnded() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		String score = game.getScore();
		
		assertEquals("Game didn't end", "player1 wins", score);
	}
	//mine
		@Test
		public void testTennisGame_Player2WinsCheckGameEnded() throws TennisGameException {
			//Arrange
			TennisGame game = new TennisGame();
			//Act
			game.player2Scored();
			game.player2Scored();
			game.player2Scored();
			game.player2Scored();
			//Act
			String score = game.getScore();
			
			assertEquals("Game didn't end", "player2 wins", score);
		}
		
	//mine
		@Test
		public void testTennisGame_Player1WinsPoint_after_Deuce_check_advantage() throws TennisGameException {
			//Arrange
			TennisGame game = new TennisGame();
			
			game.player1Scored();
			game.player1Scored();
			game.player1Scored();
			
			game.player2Scored();
			game.player2Scored();
			game.player2Scored();
			
			game.player1Scored();
			game.player2Scored();
			
			game.player1Scored();
			//Act
			String score = game.getScore() ;
			// Assert
			assertEquals("Advantage score incorrect", "player1 has advantage", score);		
		}
	//mine
		@Test
		public void testTennisGame_Player2WinsPoint_after_Deuce_check_advantage() throws TennisGameException {
			//Arrange
			TennisGame game = new TennisGame();
					
			game.player1Scored();
			game.player1Scored();
			game.player1Scored();
					
			game.player2Scored();
			game.player2Scored();
			game.player2Scored();
					
			game.player1Scored();
			game.player2Scored();
					
			game.player2Scored();
			//Act
			String score = game.getScore() ;
			// Assert
			assertEquals("Advantage score incorrect", "player2 has advantage", score);		
		}
		//mine
		@Test
		public void testTennisGame_Player1WinsPoint_after_adv() throws TennisGameException {
		//Arrange
			TennisGame game = new TennisGame();
							
			game.player1Scored();
			game.player1Scored();
			game.player1Scored();
							
			game.player2Scored();
			game.player2Scored();
			game.player2Scored();
							
			game.player1Scored();
			game.player2Scored();
							
			game.player1Scored();
			game.player1Scored();
			//Act
			String score = game.getScore() ;
			// Assert
			assertEquals("Win after Advantage score incorrect", "player1 wins", score);		
		}
	//mine
		@Test
		public void testTennisGame_Player2WinsPoint_after_adv() throws TennisGameException {
			//Arrange
			TennisGame game = new TennisGame();
					
			game.player1Scored();
			game.player1Scored();
			game.player1Scored();
					
			game.player2Scored();
			game.player2Scored();
			game.player2Scored();
					
			game.player1Scored();
			game.player2Scored();
					
			game.player2Scored();
			game.player2Scored();
			//Act
			String score = game.getScore() ;
			// Assert
			assertEquals("Win after Advantage score incorrect", "player2 wins", score);		
		}
}
