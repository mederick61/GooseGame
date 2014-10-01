package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import Source.Cell;
import Source.Player;
public class TestCell {

	@Test
	public void testIndex() {
		Cell c = new Cell(35);
		assertEquals(c.getIndex(),35);
	}
	
	@Test
	public void testCanBeLeftNow() {
		Cell c = new Cell(35);
		assertTrue(c.canBeLeftNow() == true);
	}
	
	@Test
	public void testIsRetaining() {
		Cell c = new Cell(35);
		assertTrue(c.isRetaining() == false);
	}

	@Test
	public void testGetPlayer() {
		Cell c = new Cell(35);
		Player p = new Player("titi");
		p.setCell(c);
		assertEquals(c.getPlayer(), p);
	}
	
	@Test
	public void testWelcome() {
		Cell c = new Cell(35);
		Player p = new Player("titi");
		c.welcome(p);
		assertEquals(c.getPlayer(), p);
	}
	
	@Test
	public void testIsBusy() {
		Cell c = new Cell(35);
		assertTrue(c.isBusy() == false);
	}
	
	@Test
	public void testIsBusy2() {
		Cell c = new Cell(35);
		Player p = new Player("titi");
		p.setCell(c);
		assertTrue(c.isBusy() == true);
	}
	
	@Test
	public void testIsBusy3() {
		Cell c = new Cell(35);
		Player p = new Player("titi");
		c.welcome(p);
		assertFalse(c.isBusy() == false);
	}
}
