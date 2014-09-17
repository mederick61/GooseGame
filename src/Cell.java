
public class Cell implements CellInterface {
	
	private int index;
	private Player p;
	
	public Cell(int idx)
	{
		this.index=idx;
	}

	@Override
	public boolean canBeLeftNow() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isRetaining() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getIndex() {
		// TODO Auto-generated method stub
		return this.index;
	}

	@Override
	public int handleMove(int diceThrow) {
		// TODO Auto-generated method stub
		return 0; // !!!
	}

	@Override
	public boolean isBusy() {
		// TODO Auto-generated method stub
		if(this.getPlayer()!=null)
		{
			return true;
		}
		else return false;
	}

	@Override
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return this.p;
	}

	@Override
	public void welcome(Player player) {
		// TODO Auto-generated method stub
		this.p=player;
	}

}
