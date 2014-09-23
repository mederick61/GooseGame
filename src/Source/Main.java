package Source;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		ArrayList<Player> PlayerList = Game.initialize();
		
		Board B = new Board(PlayerList,64);
		
		Game G = new Game(B);
		
		G.play();
		
		gyuo
		
		


	}
}
