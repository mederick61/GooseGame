package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Source.Board;
import Source.Game;
import Source.Player;

public class testGame {

	@Test
	public void testDiceThrow() {
		ArrayList<Player> players = new ArrayList<Player>();
		Board b = new Board(players, 64);
		Game g = new Game(b);
		for (int i=0; i<10; i++)
			{
			assertTrue(g.throwDie()>0 && g.throwDie()<=12);
			}	
	}

	
	
	
	
}
