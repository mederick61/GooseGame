package Source;


public class Player 
{
	private Cell myCell;
	private String name;
	
	public Player(String name)
	{
		this.name = name;
		this.myCell = new Cell(0);
	}
	
	public String getName()
	{
		return this.name;
	}

	public Cell getCell() {
		return myCell;
	}

	public void setCell(Cell myCell) {
		this.myCell = myCell;
		myCell.welcome(this);
	}
	
}
