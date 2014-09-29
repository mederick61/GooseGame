package Source;


public class TeleportCell extends Cell {

	private int destination;
	
	/**
     * Teleport Cell constructor
     * <p>
     * A Teleport Cell is built with an index and a destination
     * </p>
     * 
     * @param idx
     *            The Teleport Cell index
     * @param destination
     *            The Cell index where the player is teleported.
     */
	public TeleportCell(int idx,int destination) {
		super(idx);
		this.destination=destination;
	}
	/**
     * Handle the teleportation
     * 
     * @param diceThrow
     *            The value of the Dice throw.

     */	
	@Override
	public int handleMove(int diceThrow) {
		System.out.println("Teleportation in Cell " + destination);
		return destination ;
	}
	

}
