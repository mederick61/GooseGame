package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Source.Board;
import Source.GooseCell;
import Source.Player;
import Source.TeleportCell;
import Source.TrapCell;
import Source.WaitCell;

public class TestBoard {

	@Test
	public void testBoardBuilding() {
		ArrayList<Player> players = new ArrayList<Player>();
		Board b = new Board(players, 64);
		
		assertEquals(b.getCell(18).getClass(), GooseCell.class);
		assertEquals(b.getCell(31).getClass(), TrapCell.class);
		assertEquals(b.getCell(19).getClass(), WaitCell.class);
		assertEquals(b.getCell(58).getClass(), TeleportCell.class);
	}
	
	@Test
	public void testNextPlayer() {
		ArrayList<Player> players = new ArrayList<Player>();
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Player p3 = new Player("p3");
		players.add(p1);
		players.add(p2);
		players.add(p3);
		Board b = new Board(players, 64);
		
		assertEquals(b.nextPlayer(), p1);
		assertEquals(b.nextPlayer(), p2);
		assertEquals(b.nextPlayer(), p3);
		assertEquals(b.nextPlayer(), p1);
	}

	@Test
	public void testGetPlayerList() {
		ArrayList<Player> players = new ArrayList<Player>();
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Player p3 = new Player("p3");
		players.add(p1);
		players.add(p2);
		players.add(p3);
		Board b = new Board(players, 64);
		
		assertEquals(b.getPlayerList(), players);
	}
	
	@Test
	public void testSetPlayerList() {
		ArrayList<Player> players = new ArrayList<Player>();
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Player p3 = new Player("p3");
		players.add(p1);
		players.add(p2);
		players.add(p3);
		
		Board b = new Board(players, 64);
		
		ArrayList<Player> players2 = new ArrayList<Player>();
		Player p21 = new Player("p21");
		Player p22 = new Player("p22");
		Player p23 = new Player("p23");
		players.add(p21);
		players.add(p22);
		players.add(p23);
		b.setPlayerList(players2);
		
		assertEquals(b.getPlayerList(), players2);
	}
	
	@Test
	public void testNormalize() {
		ArrayList<Player> players = new ArrayList<Player>();
		Board b = new Board(players, 64);
		
		assertEquals(b.normalize(69), 57);
	}
	
	@Test 
	public void testSwapPlayers() {
		ArrayList<Player> players = new ArrayList<Player>();
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");

		players.add(p1);
		players.add(p2);
		
		Board b = new Board(players, 64);
		
		p1.setCell(b.getCell(18));
		p2.setCell(b.getCell(29));
		
		b.swapPlayer(p1, p2);

		assertEquals(p1.getCell(), b.getCell(29));
		assertEquals(p2.getCell(), b.getCell(18));
	}
	
	@Test
	public void testGetEndCell() {
		ArrayList<Player> players = new ArrayList<Player>();
		Board b = new Board(players, 64);
		
		assertEquals(b.getEndCell(), b.getCell(63));
	}
}
