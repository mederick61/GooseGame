
public class TeleportCell extends Cell {

	private int destination;
	
	public TeleportCell(int idx,int destination) {
		super(idx);
		this.destination=destination;
	}
	
	@Override
	public int handleMove(int diceThrow) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}