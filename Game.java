import java.util.*;
class Game {
	public boolean victoryAchieved = false;

	public static Scanner enterColumn;

	Coin[][] board = new Coin[8][5];

	public Game() {
		// enterCoin(5, true);
		// enterCoin(Row, false);
		System.out.println("What colour would you like to be? (r/g)");
		String color = Main.input.next();
		if (color.equals ("r") || color.equals ("R")) { 
			color = "Red"; 
			System.out.println("player is " + color);
		} else if(color.equals ("g") || color.equals ("G")) {
			color = "Green";
			System.out.println("player is " + color);
	}

		while(true) {
			displayBoard();
			enterCoin(Main.columnInput(), true);
			AIinput();
		}
	}
	
	public void displayBoard() {
		for (int y = 0; y < board[0].length; y++) {
			for (int x = 0; x < board.length; x++) {
				// System.out.print(" 0 ");
				Coin c = board[x][y];
				if (c == null) {
					System.out.print(" 0 ");
				} else {
					System.out.print(c.GetCoinString());
				}
			}
			System.out.println("");
		}   
	}

	public void enterCoin (int column, boolean isPlayer) {
		Coin c = new Coin(isPlayer);

		for (int x = board[column].length -1; x >= 0; x--) {
			if (board[column][x] == null) {
				board[column][x] = c;
				// CheckForVictory(x, column);
				return;
			}	
		}
	}

	void CheckForVictory(int x, int y) {
		CheckNeighbour (1, x, y, 1, 0);
	}

	void CheckNeighbour(int nInRow, int posX, int posY, int dirX, int dirY) {
		Coin coin = board[posX][posY];
		posX += dirX;
		posY+= dirY;

		if (posX < 0 || posY < 0 || posX >= board.length || posY >= board[0].length) {
			return;
		}

		Coin neighbour = board[posX][posY];

		if (neighbour == null)
		return;
		if (coin.isPlayer != neighbour.isPlayer)
		return;


		nInRow++;

		if (nInRow == 3) {
			CheckNeighbour(nInRow, posX, posY, -dirX*3, -dirY*3);
			//if 3 in row check other opos side
		}

		if (nInRow == 4) {
			victoryAchieved = true;
			return;
			//if (iq > 1) {you better be able to read this}
		}
		CheckNeighbour(nInRow, posX, posY, dirX, dirY);

	}

	public void AIinput() {
		if (victoryAchieved) {
			displayBoard();
			System.out.println("Opponent Won");
			return;
		}
		 int aiColumn = Main.rand.nextInt(board.length);
		 enterCoin(aiColumn, false); 	 
		
	}

}