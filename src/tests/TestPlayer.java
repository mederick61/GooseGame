package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Source.Cell;
import Source.Player;

public class TestPlayer {

	@Test
	public void testPlayerBuilding() {
		Player p = new Player("toto");
		assertEquals(p.getName(), "toto");
		assertEquals(p.getCell().getIndex(), 0);
	}
	
	@Test
	public void testSetCell() {
		Player p = new Player("toto");
		Cell c = new Cell(35);
		p.setCell(c);
		assertEquals(p.getName(), "toto");
		assertEquals(p.getCell().getIndex(), c.getIndex());
	}

}
