
public class Board {

    private char[][] board;

    // Constructor that creates board
    public Board(int height, int width) {
        board = new char[height][width];
    }

    // Getter that gets width
    public int getWidth(){
        return board.length;
    }

    // Getter that bets board
    public char[][] getBoard() {
        return board;
    }

    public void printBoard(){
        for(int i=0; i<board.length; i++){
            System.out.print("|");
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == 'r'){
                    System.out.print("r |");
                }
                else if(board[i][j] == 'y'){
                    System.out.print("y |");
                }
                else{
                    System.out.print("  |");
                }
            }
            System.out.println();
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++) {
                System.out.print(" " + (j + 1) + " ");
            }
            break;
        }
    System.out.println();
    }
}


