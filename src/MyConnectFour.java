import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyConnectFour {

	/* Board works best for any height but widths up to and including 10. Game still works past widths of 10 but numbers
	at the bottom don't match the columns */
	static Board board = new Board(6, 7);
	HumanPlayer player1 = new HumanPlayer('r');
	ComputerPlayer player2 = new ComputerPlayer('y');

	public static void main(String[] args) {
		new MyConnectFour();
	}

	public MyConnectFour() {
		playGame();
	}

	// Methods
	public boolean checkVertical(boolean hasWon, char token) {
		int count = 0;
		for (int i = 0; i < board.getWidth(); i++) {
			for (int j = 0; j < board.getHeight(); j++) {
				if (board.getBoard()[j][i] == token) {
					count = count + 1;
					if (count >= 4) {
						hasWon = true;
					}
				} else {
					count = 0;
				}
			}
		}
		return hasWon;
	}

	public boolean checkHorizontal(boolean hasWon, char token) {
		int count = 0;
		for (int i = 0; i < board.getHeight(); i++) {
			for (int j = 0; j < board.getWidth(); j++) {
				if (board.getBoard()[i][j] == token) {
					count = count + 1;
					if (count >= 4) {
						hasWon = true;
					}
				} else {
					count = 0;
				}
			}
		}
		return hasWon;
	}

	public boolean checkNegativeDiagonal(boolean hasWon, char token) {
		int count = 0;
		for (int i = 0; i < board.getHeight(); i++) {
			for (int j = 0; j < board.getWidth(); j++) {
				if (board.getBoard()[i][j] == token && count == 0 &&
						i >= (Math.floorDiv(board.getHeight(), 2))  && j >= (Math.floorDiv(board.getWidth(), 2))) {
					count = count + 1;
					if (board.getBoard()[i-1][j-1] == token) {
						count = count + 1;
						if (board.getBoard()[i-2][j-2] == token) {
							count = count + 1;
							if (board.getBoard()[i-3][j-3] == token) {
								count = count + 1;
							}
						}
					}
					if (count >= 4) {
						hasWon = true;
					}
				} else {
					count = 0;
				}
			}
		}
		return hasWon;
	}

	public boolean checkPostiveDiagonal(boolean hasWon, char token) {
		int count = 0;
		for (int i = 0; i < board.getHeight(); i++) {
			for (int j = 0; j < board.getWidth(); j++) {
				if (board.getBoard()[i][j] == token && count == 0  &&
						i < (Math.floorDiv(board.getHeight(), 2))  && j >= (Math.floorDiv(board.getWidth(), 2))){
					count = count + 1;
					if (board.getBoard()[i+1][j-1] == token) {
						count = count + 1;
						if (board.getBoard()[i+2][j-2] == token) {
							count = count + 1;
							if (board.getBoard()[i+3][j-3] == token) {
								count = count + 1;
							}
						}
					}
					if (count >= 4) {
						hasWon = true;
					}
				} else {
					count = 0;
				}
			}
		}
		return hasWon;
	}

	private void placeCounter(char player, int column) {

		boolean placed = false;

		if (player == 'r') {
			boolean falsePlace = true;
			while(falsePlace) {
				if (board.getBoard()[0][column - 1] == 'r' || board.getBoard()[0][column - 1] == 'y' ) {
					System.out.println("Can't place counter in this column. You lose your turn.");
					break;
				} else {
					falsePlace = false;
				}
			}
			for (int i = board.getHeight() - 1; i >= 0; i--) {
				if (!placed) {
					if (board.getBoard()[i][column-1] != 'r' && board.getBoard()[i][column-1] !=
					 'y') {
						board.getBoard()[i][column-1] = 'r';
						placed = true;
					}
				}
			}
		} else {
			for (int i = board.getHeight() - 1; i >= 0; i--) {
				if (!placed) {
					if (board.getBoard()[i][column-1] != 'y' && board.getBoard()[i][column-1] != 'r') {
						board.getBoard()[i][column-1] = 'y';
						placed = true;
					}
				}
			}
		}
	}


	private void playGame() {
		System.out.println("Welcome to Connect 4");
		System.out.println("There are 2 players red and yellow");
		System.out.println("Player 1 is Red, Player 2 is Yellow");
		System.out.println("To play the game type in the number of the column you want to drop you counter in");
		System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
		board.printBoard();
		boolean win = false;
		boolean computerWin = false;
		while (!win && !computerWin) {
			// player 1
			int move = player1.getMove();
			char token = player1.getToken();
			placeCounter(token, move);
			boolean hasWon = false;

			// check vertical for red
			hasWon = checkVertical(hasWon, token);

			// check horizontal for red
			hasWon = checkHorizontal(hasWon, token);

			//check Negative diagonal for red
			hasWon = checkNegativeDiagonal(hasWon, token);

			// check positive diagonal for red
			hasWon = checkPostiveDiagonal(hasWon, token);

			board.printBoard();
			if (hasWon) {
				win = true;
			if (win){
				System.out.println("You Have Won!!!");
			}
			} else {
				//player 2
				move = player2.getMove();
				token = player2.getToken();
				placeCounter(token, move);
				hasWon = false;

				// check horizontal for yellow
				hasWon = checkHorizontal(hasWon, token);

				// check vertical for yellow
				hasWon = checkVertical(hasWon, token);

				//check Negative diagonal for yellow
				hasWon = checkNegativeDiagonal(hasWon, token);

				// check positive diagonal for yellow
				hasWon = checkPostiveDiagonal(hasWon, token);

				board.printBoard();
				if (hasWon) {
					computerWin = true;
				if (computerWin) {
					System.out.println("Computer has Won!!!");
				}
			}
			}

		}
	}
}


