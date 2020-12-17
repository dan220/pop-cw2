import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyConnectFour {

	Board board = new Board(6, 6);
	Player player1 = new Player('r');
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
			for (int j = 0; j < board.getWidth(); j++) {//board.getWidth() needs to be board.getHeight()
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

	public boolean checkHorizontal(boolean hasWon, char token) {
		int count = 0;
		for (int i = 0; i < board.getWidth(); i++) {
			for (int j = 0; j < board.getWidth(); j++) {//board.getWidth() needs to be board.getHeight()
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

	private void placeCounter(char player, int column) {

		boolean placed = false;

		if (player == 'r') {
			for (int i = board.getWidth() - 1; i >= 0; i--) {
				if (!placed) {
					if (board.getBoard()[column - 1][i] != 'r' && board.getBoard()[column - 1][i] != 'y') {
						board.getBoard()[column - 1][i] = 'r';
						placed = true;
					}
				}
			}
		} else {
			for (int i = board.getWidth() - 1; i >= 0; i--) {
				if (!placed) {
					if (board.getBoard()[column - 1][i] != 'y' && board.getBoard()[column - 1][i] != 'r') {
						board.getBoard()[column - 1][i] = 'y';
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
		while (!win) {
			// player 1
			int move = player1.getUserInput();
			char token = player1.getToken();
			placeCounter(token, move);
			boolean hasWon = false;

			// check vertical for red
			hasWon = checkVertical(hasWon, token);

			// check horizontal for red
			hasWon = checkHorizontal(hasWon, token);

			board.printBoard();
			if (hasWon) {
				win = true;
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
}


