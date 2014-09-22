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
			case 8 : this.CellsTab[i] = new GooseCell(i);
			case 17 : this.CellsTab[i] = new GooseCell(i);
			case 26 : this.CellsTab[i] = new GooseCell(i);
			case 35 : this.CellsTab[i] = new GooseCell(i);
			case 44 : this.CellsTab[i] = new GooseCell(i);
			case 53 : this.CellsTab[i] = new GooseCell(i);
			case 31 : this.CellsTab[i] = new TrapCell(i);
			case 51 : this.CellsTab[i] = new TrapCell(i);
			case 18 : this.CellsTab[i] = new WaitCell(i,2);
			case 5 : this.CellsTab[i] = new TeleportCell(i, 11);
			case 41 : this.CellsTab[i] = new TeleportCell(i, 29);
			case 57 : this.CellsTab[i] = new TeleportCell(i, 1);
			default : this.CellsTab[i]=new Cell(i);
			}
		}
		this.currentPlayer = PlayerList.iterator();
	}
	
	public Player nextPlayer()
	{
		if (currentPlayer.hasNext() == true)
		{
			Player p = currentPlayer.next();
			System.out.println("joueur suivant : "+ p.getName());
			return p;
		}
		else
		{
			currentPlayer = PlayerList.iterator();
			Player p = currentPlayer.next();
			System.out.println("joueur suivant : "+ p.getName());
			return p;
		}
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
