package Source;
/**
 * <b>A WaitCell keeps the player for a number of turns.
 * <p>
 * A WaitCell is characterized by the following informations :
 * <ul>
 * <li>A waiting time which represents the number of turns to wait. </li>
 * <li>A waiting counter which is decremented each turn.</li>
 * </ul>
 * </p>
 * @author Leo JUMEL et Brice NUZZO
 * @version 1.0
 */


public class WaitCell extends Cell {

	private int WaitingTime;
	private int WaitingCounter;

	/**
	 * WaitCell constructor
	 * <p>
	 * A WaitCell is built with an index.
	 * </p>
	 * 
	 * @param idx
	 *            The WaitCell index
	 * @param time
	 *            The WaitCell time to wait.
	 */
	public WaitCell(int idx, int time) {
		super(idx);
		this.WaitingTime = time;
		this.WaitingCounter = time;
	}
	
	/**
	 * Indicates if a cell holds a player until another player reaches the same
	 * cell.
	 *
	 * @return true if and only if the only way for a player to get out of this
	 *         cell is for another player to replace him
	 */
	@Override
	public boolean canBeLeftNow() {
		if (this.WaitingCounter == 0) // If the wait
		{
			return true;
		}
		else
		{
			this.WaitingCounter--;
			return false;
		}
	}
	/**
	 * Remembers <code>player</code> to be in this cell.
	 *
	 * @param player
	 *            the new player in this cell
	 */	
	@Override
	public void welcome(Player player) {
		this.WaitingCounter = this.WaitingTime; // Each time a player come to a wait cell, the counter is initialized.
		super.welcome(player);
	}
	
	/**
	 * Indicates the number of round before the player is released.
	 *
	 * @return a number between 0 and 2.
	 */
	public int getWaitingCounter() {
		return WaitingCounter;
	}
}
