package Source;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



public class Game
{
	private Board board;
	
	public Game(Board board)
	{
		this.board=board;
	}
	
	public static ArrayList<Player> initialize()
	{
		ArrayList<Player> PlayerList = new ArrayList<Player>();
		Scanner sc = new Scanner(System.in);		
		
		System.out.println("How many players ?");
		
		int nbplayers = sc.nextInt();
		
		for(int i=1;i<=nbplayers;i++)
		{
			System.out.println("Player "+i+" Name :");
			String playerName = sc.next();
			PlayerList.add(new Player(playerName));
			
		}
		
		return PlayerList;
	}
	
	public void play()
	{
		while(!(this.isFinished()))
		{
			Player p= this.board.nextPlayer(); 
			
			if(p.getCell().canBeLeftNow()) // si le joueur peut bouger
			{
				int diceResult= this.throwDie(); // Random entre 2 et 12
				
				Cell reachedCell = this.board.getCell(this.board.normalize(p.getCell().getIndex()+diceResult)); // Case atteinte avant effet
				
				Cell realCell = this.board.getCell(this.board.normalize(reachedCell.handleMove(diceResult))); //Case atteinte après effet
				
				if(realCell.isBusy()) // si la case est occupée
				{
					this.board.swapPlayer(p, realCell.getPlayer()); // échange des deux joueurs
				}
				else
				{
					realCell.welcome(p); // la case "accueille" le joueur
					p.setCell(realCell); // on affecte la case finale au joueur
					
				}
			}
			else
			{
				System.out.println("Le joueur ne peut pas bouger"); // ajouter temps d'attente etc
			}
		}
		
	}
	
	public boolean isFinished()
	{
		return true;
	}
	
	public int throwDie()
	{
		Random rand = new Random();
	    return rand.nextInt((12 - 2) + 1) + 2;

	}
}
