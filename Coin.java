class Coin {
	boolean isPlayer = false;
	String ansiReset = "\u001b[0m";
	String ansiRed = "\u001b[31m";
	String ansiGreen = "\u001b[32m"; 
	public Coin(boolean player) {
		isPlayer = player;
	}
	

	public String GetCoinString ()	{
		if(isPlayer) {
			return ansiRed + " 0 " + ansiReset;
			
		} else {
			return ansiGreen + " 0 " + ansiReset;
		}
	}	
}