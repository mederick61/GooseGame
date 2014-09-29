package Source;


public class TrapCell extends Cell{

	public TrapCell(int idx) {
		super(idx);
	}
	
	@Override
	public boolean canBeLeftNow() {
		return false;
	}
	
	@Override
	public boolean isRetaining() {
		return true;
	}

}
