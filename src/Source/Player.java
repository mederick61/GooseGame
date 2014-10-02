package Source;

/**
 * <b>Player is the class that represents a Goose Game player.
 * <p>
 * A player is characterized by the following informations :
 * <ul>
 * <li>A cell, which represents the current cell occupy by the player </li>
 * <li>A name, which represents the player's name.</li>
 * </ul>
 * </p>
 * 
 * 
 * @author Leo JUMEL et Brice NUZZO
 * @version 1.0
 */

public class Player 
{

	
	/**
     * The cell occupy by the player.
     */
	private Cell myCell;

    /**
     * The player's name.
     */
	private String name;
	
	/**
     * Player constructor
     * <p>
     * A player is built from a name.
     * </p>
     * 
     * @param name
     *            The player's name.
     */
	public Player(String name)
	{
		this.name = name;
		this.myCell = new Cell(0); //By default, each player start at the Cell 0
	}
	
	/**
     * Get the player's name.
      
     * @return the player's name.
     */
	public String getName()
	{
		return this.name;
	}
 
	/**
     * Get the cell occupy by the player.
     * 
     * @return the player's cell.
     */
	public Cell getCell() {
		return myCell;
	}

	/**
	 * Set the player's cell
	 * 
	 * @param myCell
	 * 				The destination cell.)
	 */				
	public void setCell(Cell myCell) {
		this.myCell = myCell;
		myCell.welcome(this);
	}
	
}
