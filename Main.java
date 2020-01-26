import java.util.Scanner;
import java.util.*;

class Main {

	static boolean playerRed = false;
	static boolean playerGreen = false;

	public static Scanner input;
	public static Random rand;

	public static void main(String[] args){
		input = new Scanner(System.in);
		rand = new Random();
		new Game();
	}	

	public static int columnInput() {
		int columnInput = Integer.parseInt(Main.input.next());
		return columnInput;
		// game.enterCoin(columnInput, true);
	}


}

	

