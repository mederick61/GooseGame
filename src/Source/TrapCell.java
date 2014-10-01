package Source;

/**
 * <b>A TrapCell keeps the player until the next event.
 * <p>
 * A TrapCell has no particular field, excepted those of its mother (Cell).
 * </p>
 * 
 * 
 * @author Leo JUMEL et Brice NUZZO
 * @version 1.0
 */

public class TrapCell extends Cell{
	/**
     * TrapCell constructor
     * <p>
     * A TrapCell is built with an index.
     * </p>
     * 
     * @param idx
     *            The TrapCell index
     */
	public TrapCell(int idx) {
		super(idx);
	}
	/**
	 * Indicates if a player occupying this cell can, at this turn, leave the
	 * cell.
	 *
	 * @return true if and only if the player in this cell can freely leaves the
	 *         cell at this turn
	 */	
	@Override
	public boolean canBeLeftNow() {
		return false;
	}
	/**
	 * Indicates if a cell holds a player until another player reaches the same
	 * cell.
	 *
	 * @return true if and only if the only way for a player to get out of this
	 *         cell is for another player to replace him
	 */	
	@Override
	public boolean isRetaining() {
		return true;
	}

}
