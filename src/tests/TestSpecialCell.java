package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Source.Cell;
import Source.GooseCell;
import Source.TeleportCell;

public class TestSpecialCell {

	@Test
	public void testHandleMoveTeleport() {
		Cell c = new TeleportCell(6,12);
		assertEquals(c.handleMove(12), 12);
	}
	
	@Test
	public void testHandleMoveGoose() {
		Cell c = new GooseCell(6);
		assertEquals(c.handleMove(4), 10);
	}
}
