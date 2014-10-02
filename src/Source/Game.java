package Source;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * <b>Game is the class that represents the Goose Game itself
 * <p>
 * A Game is characterized by the following informations :
 * <ul>
 * <li>A board, which represents the the Goose Game's board </li>
 * <li>An amount of players for the current Game.</li>
 * </ul>
 * </p>
 * 
 * 
 * @author Leo JUMEL et Brice NUZZO
 * @version 1.0
 */

public class Game
{
    /**
     * The Goose Game's board
     */
	private Board board;
    /**
     * The amount of players.
     */
	private static int nbplayers=3;
	
	/**
     * Game constructor
     * <p>
     * A game is built from a board
     * </p>
     * 
     * @param board
     *            The board object.
     */
	public Game(Board board)
	{
		this.board=board;
	}
	
	/**
     * Game initializer.
     * <p>
     * This class method allows the user to select a number of players and initiate their names in the game. It returns a Player ArrayList used to initiate the Board.
     * </p>
     * 
     * @return A Player ArrayList.
     */
	@SuppressWarnings("resource")
	public static ArrayList<Player> initialize()
	{
		ArrayList<Player> PlayerList = new ArrayList<Player>();		
		System.out.println("How many players ?");
		nbplayers = new Scanner(System.in).nextInt();
		
		for(int i=1;i<=nbplayers;i++)
		{
			System.out.println("Player "+i+" Name :");
			String playerName = new Scanner(System.in).next();
			PlayerList.add(new Player(playerName));
		}

		return PlayerList;
	}
	

	/**
     * Game main method.
     * <p>
     * Handle the main part of the game process.
     * </p>
     * 
     * 
     */
	public void play(int mode)
	{
		while(!(this.isFinished())) // While the game is not finished
		{
			Player p = this.board.nextPlayer(); // Changing the current player

			if(mode==2)
			{
				System.out.println("Press ENTER to roll the dice");
				@SuppressWarnings({ "resource", "unused" })
				String h = new Scanner(System.in).nextLine(); // Waiting to make the game more clear
			}
			if(p.getCell().canBeLeftNow()) // If the player can move
			{
				Cell oldCell = p.getCell();
				board.getCell(oldCell.getIndex()).welcome(null); // His old cell is now free
				int diceResult= this.throwDie(); // Random number between 2 and 12
				System.out.println("Dice throw : "+diceResult);
				
				Cell reachedCell = this.board.getCell(this.board.normalize(p.getCell().getIndex()+diceResult)); // Cell reached before effect
				
				System.out.println("Reached cell before effect : "+reachedCell.getIndex());
				
				Cell realCell = this.board.getCell(this.board.normalize(reachedCell.handleMove(diceResult))); // Cell reached after effect
				
				System.out.println("Reached cell after effect : "+realCell.getIndex());
				
				if(realCell.isBusy()) // If the cell reached after effect is busy
				{
					System.out.println("The Cell is already busy by : "+realCell.getPlayer().getName());
					this.board.swapPlayer(p, realCell.getPlayer()); // The players swap their positions
					System.out.println(realCell.getPlayer().getName() + " and " + p.getName() + " have swap their cells");
				}
				else
				{
					
					realCell.welcome(p); // The cell contains now the player
					p.setCell(realCell); // The player is now on the cell
					System.out.println(p.getName()+" is now in cell : "+ realCell.getIndex());
					
				}
			}
			else
			{
				System.out.println("Player can't move.");
				if (p.getCell().getClass() == TrapCell.class) //If the player is on a trap cell
				{
					System.out.print(p.getName()+ "is on a trap cell");
				}
				else // The player is on a wait cell
				{
						WaitCell c = (WaitCell) p.getCell();
						System.out.println(p.getName()+" is blocked for still "+c.getWaitingCounter()+" round"); 					
				}
			}

		}
		
	}
	
	/**
     * Game end conditions.
     * <p>
     * Allow the game to know if it is finished or not.
     * </p>
     * 
     * @return True if the game is finished, false otherwise.
     */
	public boolean isFinished()
	{
		for (int i=0; i<Game.nbplayers; i++)
		if(this.board.getPlayerList().get(i).getCell().getIndex() == 63)
		{
			System.out.println(this.board.getPlayerList().get(i).getName()+" WIN !!!");
			return true;
		}
		return false;
	}
	/**
     * Dice throw.
     * <p>
     * Rolls two dice.
     * </p>
     * 
     * @return an integer between 2 and 12.
     */
	public int throwDie()
	{
		Random rand = new Random();
	    return rand.nextInt((12 - 2) + 1) + 2;

	}
}
