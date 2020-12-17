import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyConnectFour {

	private BufferedReader input;
	//private char[][] board;
	Board board = new Board(6,6);
	
	public static void main(String[] args){
		new MyConnectFour();
	}

	public MyConnectFour(){
		//board = new char[6][7];
		input = new BufferedReader(new InputStreamReader(System.in));
		playGame();
	}

	// Get user input of column number
	private String getUserInput(){
		String toReturn = null;
		try{
			toReturn = input.readLine();
		}
		catch(Exception e){
			System.out.println("Please enter a valid number");

		}
		return toReturn;
	}
	
	private void playGame() {
		System.out.println("Welcome to Connect 4");
		System.out.println("There are 2 players red and yellow");
		System.out.println("Player 1 is Red, Player 2 is Yellow");
		System.out.println("To play the game type in the number of the column you want to drop you counter in");
		System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
		board.printBoard();
		boolean win = false;
		while (!win) {
			// player 1
			String userInput = getUserInput();
			int move = Integer.parseInt(userInput);
			placeCounter('r', move);
			boolean hasWon = false;
			int count = 0;
			// check horizontal
			for (int i = 0; i < board.getWidth(); i++) {
				for (int j = 0; j < board.getWidth(); j++) {//board.getWidth() needs to be board.getHeight()
					if (board.getBoard()[i][j] == 'r') {
						count = count + 1;
						if (count >= 4) {
							hasWon = true;
						}
					} else {
						count = 0;
					}
				}

			}
			// check vertical 
			count = 0;
			for (int i = 0; i < board.getWidth(); i++) {
				for (int j = 0; j < board.getWidth(); j++) {
					if (board.getBoard()[j][i] == 'r') {
						count = count + 1;
						if (count >= 4) {
							hasWon = true;
						}
					} else {
						count = 0;
					}
				}

			}
			board.printBoard();
			if (hasWon) {
				win = true;
			} else {
				//player 2
				userInput = getUserInput();
				move = Integer.parseInt(userInput);
				placeCounter('y', move);
				hasWon = false;
				count = 0;
				// check horizontal
				for (int i = 0; i < board.getWidth(); i++) {
					for (int j = 0; j < board.getWidth(); j++) {
						if (board.getBoard()[i][j] == 'y') {
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
				for (int i = 0; i < board.getWidth(); i++) {
					for (int j = 0; j < board.getWidth(); j++) {
						if (board.getBoard()[j][i] == 'y') {
							count = count + 1;
							if (count >= 4) {
								hasWon = true;
							}
						} else {

						}
					}
					count = 0;
				}
				board.printBoard();
				if (hasWon) {
					win = true;
				}
			}
			if (win == true) {
				System.out.println("You Have Won!!!");
			}

		}
	}


	// Print the board
	/*
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
	*/

	
	private void placeCounter(char player, int column){

		boolean placed = false;;
		if(player == 'r'){
			for(int i= board.getWidth()-1; i>=0; i--){
				if(!placed){
					if(board.getBoard()[column-1][i] != 'r' && board.getBoard()[column-1][i] != 'y'){
						board.getBoard()[column-1][i] = 'r';
						placed = true;
					}
				}
			}
		}
		else{
			for(int i=board.getWidth()-1; i>=0; i--){
				if(!placed){
					if(board.getBoard()[column-1][i] != 'y' && board.getBoard()[column-1][i] != 'r'){
						board.getBoard()[column-1][i] = 'y';
						placed = true;
					} 
				}
			}
		}
	}
}
