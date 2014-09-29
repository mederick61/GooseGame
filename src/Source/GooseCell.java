package Source;


public class GooseCell extends Cell {

	public GooseCell(int idx) {
		super(idx);
	}

	
	@Override
	public int handleMove(int diceThrow) {
		System.out.println("CASE OIE !");
		return this.getIndex()+diceThrow;
	}
}
