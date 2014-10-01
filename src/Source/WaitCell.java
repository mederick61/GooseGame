package Source;


public class WaitCell extends Cell {

	private int WaitingTime;
	private int WaitingCounter;
	
	public WaitCell(int idx, int time) {
		super(idx);
		this.WaitingTime = time;
		this.WaitingCounter = time;
	}
	
	@Override
	public boolean canBeLeftNow() {
		if (this.WaitingCounter == 0)
		{
			return true;
		}
		else
		{
			this.WaitingCounter--;
			return false;
		}
	}
	
	@Override
	public void welcome(Player player) {
		this.WaitingCounter = this.WaitingTime;
		super.welcome(player);
	}

}
