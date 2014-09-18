package Source;


public class TrapCell extends Cell{

	public TrapCell(int idx) {
		super(idx);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean canBeLeftNow() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isRetaining() {
		// TODO Auto-generated method stub
		return true;
	}

}
