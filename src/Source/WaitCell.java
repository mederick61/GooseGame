package Source;


public class WaitCell extends Cell {

	private int WaitingTime;
	private int WaitingCounter;
	
	public WaitCell(int idx, int time) {
		super(idx);
		this.WaitingTime = time;
		this.WaitingCounter = time;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean canBeLeftNow() {
		// TODO Auto-generated method stub
		if (this.WaitingCounter == 0)
		{
			return true;
		}
		else this.WaitingCounter--;
		return false;
	}
	
	@Override
	public void welcome(Player player) {
		// TODO Auto-generated method stub
		this.WaitingCounter = this.WaitingTime;
		this.welcome(player);
	}

}
