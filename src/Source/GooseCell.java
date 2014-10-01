package Source;

/**
 * <b>GooseCell is the class that represents a Goose Cell.
 * <p>
 * A Goose Cell is characterized by the following informations :
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

public class GooseCell extends Cell {

	/**
     * GooseCell constructor
     * <p>
     * A game is built from an index
     * </p>
     * 
     * @param idx
     *            The cell's index.
     */
	
	public GooseCell(int idx) {
		super(idx);
	}

	/**
     * The GooseCell effect.
     * <p>
     * The player //TODO
     * </p>
     * 
     * @param diceThrow
     * 			  The dices' result of the current player.
     * 
     * @return The result cell's index.
     */
	@Override
	public int handleMove(int diceThrow) {
		System.out.println("CASE OIE !");
		return this.getIndex()+diceThrow;
	}
}
