package Source;

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
	
	public ArrayList<Player> getPlayerList() {
		return PlayerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		PlayerList = playerList;
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
		else return idx; 
	}
	
	public void swapPlayer(Player p1, Player p2)
	{

		Cell c = new Cell(0);
		
		c=p2.getCell();
		p2.setCell(p1.getCell());
		p1.setCell(c);
		
		p2.getCell().welcome(p2);
		p1.getCell().welcome(p1);
	}
	
	public Cell getEndCell()
	{
		return CellsTab[CellsTab.length-1];
	}
	
	
	
	
	
}
