import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyConnectFour {

	final BufferedReader input;
	final char[][] board;
	
	public static void main(String[] args){
		new MyConnectFour();
	}

	public MyConnectFour(){
		board = new char[6][7];
		input = new BufferedReader(new InputStreamReader(System.in));
		playGame();
	}

	private String getUserInput(){
		String toReturn = null;
		try{
			toReturn = input.readLine();
		}
		catch(Exception e){

		}
		return toReturn;
	}
	
	private void playGame(){
		System.out.println("Welcome to Connect 4");
		System.out.println("There are 2 players red and yellow");
		System.out.println("Player 1 is Red, Player 2 is Yellow");
		System.out.println("To play the game type in the number of the column you want to drop you counter in");
		System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
		printBoard();
		boolean win = false;
		while(!win){
			// player 1
			String userInput = getUserInput();
			int move = Integer.parseInt(userInput);
			placeCounter('r',move);
			boolean hasWon = false;
			int count = 0;
			// check horizontal
			for (char[] chars : board) {
				for (char aChar : chars) {
					if (aChar == 'r') {
						count = count + 1;
						if (count > 4) {
							hasWon = true;
						}
					} else {
						count = 0;
					}
				}

			}
			// check vertical 
			count = 0;
			for(int i=0; i<board[0].length; i++){
				for (char[] chars : board) {
					if (chars[i] == 'r') {
						count = count + 1;
						if (count > 4) {
							hasWon = true;
						}
					} else {
						count = 0;
					}
				}
				
			}
			printBoard();
			if(hasWon){
				win = true;
			}
			else{
				//player 2
				userInput = getUserInput();
				move = Integer.parseInt(userInput);
				placeCounter('y',move);
				hasWon = false;
				count = 0;
				// check horizontal
				for (char[] chars : board) {
					for (char aChar : chars) {
						if (aChar == 'y') {
							count = count + 1;
							if (count >= 4) {
								hasWon = true;
							}
						} else {

						}
					}
					count = 0;
				}
				// check vertical 
				count = 0;
				for(int i=0; i<board[0].length; i++){
					for (char[] chars : board) {
						if (chars[i] == 'y') {
							count = count + 1;
							if (count >= 4) {
								hasWon = true;
							}
						} else {

						}
					}
					count = 0;
				}
				printBoard();
				if(hasWon){
					win = true;
				}
			}
			System.out.println("You Have Won!!!");
		}
		
	}



	
	private void printBoard(){
		for(int i=0; i<board.length-1; i++){
			for(int j=0; j<board[i].length-1; j++){
				if(board[j][i] == 'r'){
					System.out.print("| r ");
				}
				else if(board[j][i] == 'y'){
					System.out.print("| y ");
				}
				else{
					System.out.print("|   ");
				}
			}
			System.out.println("|");
		}
		System.out.println("  1   2   3   4   5   6   7");
	}
	
	private void placeCounter(char player, int position){
		boolean placed = false;
		if(player == 'r'){
			for(int i=board.length-1; i>=0; i++){
				if(!placed){
					if(board[i][position] == 'y'){
						// skip
					}
					else if(board[i][position] != 'r'){
						board[i][position] = 'r';
						placed = true;
					}
				}
			}
		}
		else{
			for(int i=board.length-1; i>=0; i--){
				if(!placed){
					if(board[i][position-1] != 'y'){
						board[i][position-1] = 'y';
						placed = true;
					} 
				}
			}
		}
	}
}
