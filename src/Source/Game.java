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
	public static ArrayList<Player> initialize()
	{
		ArrayList<Player> PlayerList = new ArrayList<Player>();
		Scanner sc = new Scanner(System.in);		
		
		System.out.println("How many players ?");
		
		nbplayers = sc.nextInt();
		
		for(int i=1;i<=nbplayers;i++)
		{
			System.out.println("Player "+i+" Name :");
			String playerName = sc.next();
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
		while(!(this.isFinished()))
		{
			Player p= this.board.nextPlayer(); 
		
			Scanner sc = new Scanner(System.in);
			if(mode==2)
			{
				System.out.println("Press ENTER to roll the dice");
				String h = sc.nextLine();
			}
			if(p.getCell().canBeLeftNow()) // si le joueur peut bouger
			{
				Cell oldCell = p.getCell();
				board.getCell(oldCell.getIndex()).welcome(null);
				int diceResult= this.throwDie(); // Random entre 2 et 12
				System.out.println("Dice throw : "+diceResult);
				
				Cell reachedCell = this.board.getCell(this.board.normalize(p.getCell().getIndex()+diceResult)); // Case atteinte avant effet
				
				System.out.println("Reached cell before effect : "+reachedCell.getIndex());
				
				Cell realCell = this.board.getCell(this.board.normalize(reachedCell.handleMove(diceResult)));//Case atteinte apr�s effet
				
				System.out.println("Reached cell after effect : "+realCell.getIndex());
				
				if(realCell.isBusy()) // si la case est occup�
				{
					System.out.println("The Cell is already busy by : "+realCell.getPlayer().getName());
					System.out.println(realCell.getPlayer().getName() + " and " + p.getName() + " have swap their cells");
					this.board.swapPlayer(p, realCell.getPlayer()); // �change des deux joueurs
				}
				else
				{
					
					realCell.welcome(p); // la case "accueille" le joueur
					p.setCell(realCell); // on affecte la case finale au joueur
					System.out.println(p.getName()+" is now in cell : "+ realCell.getIndex());
					
				}
			}
			else
			{
				System.out.println("Player can't move."); // ajouter temps d'attente etc
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
