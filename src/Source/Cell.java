package Source;

/**
 * <b>Cell is the class that represents a Cell.
 * <p>
 * A Cell is characterized by the following informations :
 * <ul>
 * <li>An index, which represents its position on the board</li>
 * <li>A player, which represents the player actually on the cell</li>
 * </ul>
 * </p>
 * 
 * 
 * @author Leo JUMEL et Brice NUZZO
 * @version 1.0
 */
public class Cell implements CellInterface {
	
	/**
     * The cell's index.
     */
	private int index;
	
	/**
     * The player occupying the cell;.
     */
	private Player p;
	
	/**
     * Cell constructor
     * <p>
     * A cell is built from an index
     * </p>
     * 
     * @param idx
     *            The cell's index.
     */
	public Cell(int idx)
	{
		this.index=idx;
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
		// TODO Auto-generated method stub
		return true;
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
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Indicates the position in the board of this cell.
	 *
	 * @return a number greater than or equal to 0 (for the starting cell only).
	 */

	@Override
	public int getIndex() {
		// TODO Auto-generated method stub
		return this.index;
	}

	/**
	 * Returns the index of the cell really reached by a player when he reaches
	 * this cell. For normal cells, the returned value equals
	 * <code>getIndex()</code> and is thus independent from
	 * <code>diceThrow</code>.
	 *
	 * @param diceThrow
	 *            the result of the dice when the player reaches this cell
	 * @return the index of the cell effectively reached when a player reaches
	 *         this cell after the given throw of dice
	 */
	@Override
	public int handleMove(int diceThrow) {
		// TODO Auto-generated method stub
		return this.index;
	}

	/**
	 * Indicates if a player currently occupies this cell.
	 *
	 * @return true if and only if a player is in this cell*
	 */
	@Override
	public boolean isBusy() {
		// TODO Auto-generated method stub
		if(this.getPlayer()!=null)
		{
			return true;
		}
		else return false;
	}

	/**
	 * Returns the player currently occupying this cell, <code>null</code> if
	 * none.
	 *
	 * @return the player currently in this cell, <code>null</code> if none.
	 */
	@Override
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return this.p;
	}

	/**
	 * Remembers <code>player</code> to be in this cell.
	 *
	 * @param player
	 *            the new player in this cell
	 */
	@Override
	public void welcome(Player player) {
		// TODO Auto-generated method stub
		this.p=player;
	}

}
