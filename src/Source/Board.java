package Source;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * <b>Board is the class that represents a Board.
 * <p>
 * A Board is characterized by the following informations :
 * <ul>
 * <li>A list of players</li>
 * <li>A Cells tab</li>
 * <li>A Player iterator, to let the board knows what player is currently playing.</li>
 * </ul>
 * </p>
 * 
 * 
 * @author Leo JUMEL et Brice NUZZO
 * @version 1.0
 */

public class Board
{
	/**
     * The Player list.
     */
	private ArrayList<Player> PlayerList;
	/**
     * The cells tab
     */
	private Cell[] CellsTab;
	/**
     * The Player iterator.
     */
	private Iterator<Player> currentPlayer;
	
	/**
     * Board constructor
     * <p>
     * A board is built from a Player List and an amount of cells.
     * </p>
     * 
     * @param PlayerList
     *            The Player List
     * @param nbCells
     *            The amount of Cells on the board.
     */
	public Board(ArrayList<Player> PlayerList, int nbCells)
	{
		this.CellsTab = new Cell[nbCells];
		this.PlayerList =PlayerList;
		for(int i=0;i<nbCells;i++)
		{
			switch(i)
			{
			case 9:
			case 18:
			case 27:
			case 36:
			case 45:
			case 54:{this.CellsTab[i] = new GooseCell(i);break;}
			
			case 31:
			case 52:{this.CellsTab[i] = new TrapCell(i);break;}
			
			case 19:{this.CellsTab[i] = new WaitCell(i,2);break;}
			
			case 6: {this.CellsTab[i] = new TeleportCell(i, 12);break;}
			case 42: {this.CellsTab[i] = new TeleportCell(i, 30);break;}
			case 58: {this.CellsTab[i] = new TeleportCell(i, 1);break;}
			default: this.CellsTab[i]=new Cell(i);
			}
		}
		this.currentPlayer = PlayerList.iterator();
	}
	
	
	/**
     * Change the current player to the next one in the Player List.
     * 
     * @return The next player in the Player List.
     */
	public Player nextPlayer()
	{
		if (!(currentPlayer.hasNext()))
		{
			currentPlayer = PlayerList.iterator();
		}
		Player p = currentPlayer.next();
		System.out.println("\n ================ "+ p.getName().toUpperCase()+ "'S TURN ================");
		return p;
	}
	
	/**
     * Player list getter.
     * 
     * @return The Player list which is attached to the board.
     */
	public ArrayList<Player> getPlayerList() {
		return PlayerList;
	}
	/**
     * Player list setter.
     * @param playerList
     *            The new player list.
     */
	public void setPlayerList(ArrayList<Player> playerList) {
		PlayerList = playerList;
	}
	/**
     * Cell getter.
     * @param idx
     *            The cell index.
     * @return The Cell with the searched index.
     */
	public Cell getCell(int idx)
	{
		return CellsTab[idx];
	}
	/**
     * If a player go beyond the end cell, he is brought back as many cells he was over.
     * @param idx
     *            The cell index.
     * @return The real Cell index.
     */	
	public int normalize(int idx)
	{
		if (idx>63)
		{
			return 63-(idx-63);
		}
		else return idx; 
	}
	/**
     * Swap the Cell of p1 & p2.
     * @param p1
     *            The first player.
     * @param p2
     *            The second player.
     */		
	public void swapPlayer(Player p1, Player p2)
	{

		Cell c = new Cell(0);
		
		c=p2.getCell();
		p2.setCell(p1.getCell());
		p1.setCell(c);
		
		p2.getCell().welcome(p2);
		p1.getCell().welcome(p1);
	}
	
	/**
     * End Cell getter.
     * 
     * @return The last Cell of the board.
     */
	public Cell getEndCell()
	{
		return CellsTab[CellsTab.length-1];
	}
	
	
	
	
	
}
