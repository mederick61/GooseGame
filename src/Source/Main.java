package Source;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Player> PlayerList = new ArrayList<Player>();
		System.out.print("Please choose a Game Mode ( 1 : Automatic , 2 : Manual ) : ") ;
		
		int mode = sc.nextInt();
		if(mode == 2)
		{
		 PlayerList = Game.initialize();
		}
		else
		{
			Player p1 = new Player("toto");
			Player p2 = new Player("tata");
			Player p3 = new Player("titi");
			
			PlayerList.add(p1);
			PlayerList.add(p2);
			PlayerList.add(p3);
		}
		
		Board B = new Board(PlayerList,64);
		
		Game G = new Game(B);
		
		G.play(mode);
		


	}
}
