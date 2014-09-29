package Source;


public class Cell implements CellInterface {
	
	private int index;
	private Player p;
	
	public Cell(int idx)
	{
		this.index=idx;
	}

	@Override
	public boolean canBeLeftNow() {
		return true;
	}

	@Override
	public boolean isRetaining() {
		return false;
	}

	@Override
	public int getIndex() {
		return this.index;
	}

	@Override
	public int handleMove(int diceThrow) {
		return this.index;
	}

	@Override
	public boolean isBusy() {
		if(this.getPlayer()!=null)
		{
			return true;
		}
		else return false;
	}

	@Override
	public Player getPlayer() {
		return this.p;
	}

	@Override
	public void welcome(Player player) {
		this.p=player;
	}

}
