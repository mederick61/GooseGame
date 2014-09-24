package Source;
import java.io.Console;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



public class Game
{
	private Board board;
	private static int nbplayers;
	
	public Game(Board board)
	{
		this.board=board;
	}
	
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
	

	
	public void play()
	{
		while(!(this.isFinished()))
		{
			Player p= this.board.nextPlayer(); 
		
			Scanner sc = new Scanner(System.in);
			System.out.println("Appuyez sur une touche pour lancer les dés");
			String h = sc.nextLine();
			
			if(p.getCell().canBeLeftNow()) // si le joueur peut bouger
			{
				Cell oldCell = p.getCell();
				int diceResult= this.throwDie(); // Random entre 2 et 12
				
				System.out.println("Lancer de dés : "+diceResult);
				
				Cell reachedCell = this.board.getCell(this.board.normalize(p.getCell().getIndex()+diceResult)); // Case atteinte avant effet
				
				System.out.println("Case atteinte avant effet : "+reachedCell.getIndex());
				
				Cell realCell = this.board.getCell(this.board.normalize(reachedCell.handleMove(diceResult)));//Case atteinte après effet
				
				System.out.println("Case atteinte après effet : "+realCell.getIndex());
				
				if(realCell.isBusy()) // si la case est occupé
				{
					System.out.println("La case est déjà occupée par : "+realCell.getPlayer().getName());
					this.board.swapPlayer(p, realCell.getPlayer()); // échange des deux joueurs
				}
				else
				{
					realCell.welcome(p); // la case "accueille" le joueur
					p.setCell(realCell); // on affecte la case finale au joueur
					System.out.println(p.getName()+" est maintenant à  la case : "+ realCell.getIndex());
					board.getCell(oldCell.getIndex()).welcome(null);
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
		for (int i=0; i<Game.nbplayers; i++)
		if(this.board.getPlayerList().get(i).getCell().getIndex() == 63)
		{
			System.out.println(this.board.getPlayerList().get(i).getName()+" WIN !!!");
			return true;
		}
		return false;
	}
	
	public int throwDie()
	{
		Random rand = new Random();
	    return rand.nextInt((12 - 2) + 1) + 2;

	}
}
