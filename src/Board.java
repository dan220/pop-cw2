
public class Board {

    private char[][] board;

    // Constructor that creates board
    public Board(int width, int height) {
        board = new char[width][height];
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
                if(board[j][i] == 'r'){
                    System.out.print("r |");
                }
                else if(board[j][i] == 'y'){
                    System.out.print("y |");
                }
                else{
                    System.out.print("  |");
                }
            }
            System.out.println();
        }
        for(int i=0; i<board.length; i++){
            System.out.print(" " + (i + 1) + " ");
        }
    }
}


