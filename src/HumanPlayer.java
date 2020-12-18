import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HumanPlayer extends Player {

    private BufferedReader in;

    public HumanPlayer(char token) {
        super(token);
        this.in = new BufferedReader(new InputStreamReader(System.in));
    }

    public int getMove() {
        int number = 1;
        boolean acceptableInput = false;
        while (!acceptableInput) {
            try {
                number = Integer.parseInt(this.in.readLine());
                if(number <= MyConnectFour.board.getWidth()){
                    acceptableInput = true;
                }
                else{
                    System.out.println("Please enter a number which matches a column number");
                }
            } catch (Exception e) {
                System.out.println("Please enter a number");
            }
        }
        return number;
    }
}
