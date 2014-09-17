import java.util.ArrayList;
import java.util.Iterator;


public class Board
{
	private ArrayList<Player> PlayerList;
	private Cell[] CellsTab;
	private Iterator<Player> currentPlayer;
	
	public Board(ArrayList<Player> PlayerList, int nbCells)
	{
		this.CellsTab = new Cell[nbCells];
		this.PlayerList =PlayerList;
		for(int i=0;i<=nbCells;i++)
		{
			this.CellsTab[i]= new Cell(i);
		}
		this.currentPlayer = PlayerList.iterator();
	}
	
	public Player nextPlayer()
	{
		if (currentPlayer.hasNext())
		{
			return currentPlayer.next();
		}
		else
		{
			currentPlayer = PlayerList.iterator();
			return PlayerList.get(0);
		}
	}
	
	public Cell getCell(int idx)
	{
		return CellsTab[idx];
	}
	
	public int normalize(int idx)
	{
		if (idx>63)
		{
			return 63-(idx-63);
		}
		else return idx; //TODO
	}
	
	public void swapPlayer(Player p1, Player p2)
	{
		//TODO
		Cell c = new Cell(0);
		
		c=p2.getCell();
		p2.setCell(p1.getCell());
		p1.setCell(c);
		
		p2.getCell().welcome(p2);
		p1.getCell().welcome(p1);
	}
	
	public Cell getEndCell()
	{
		return CellsTab[CellsTab.length-1]; //TODO
	}
	
	
	
	
	
}
