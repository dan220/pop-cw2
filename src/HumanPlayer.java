import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HumanPlayer extends Player {

    private BufferedReader in;

    public HumanPlayer(char token){
        super(token);
        this.in = new BufferedReader(new InputStreamReader(System.in));
    }

    public int getMove(){
        try{
            return Integer.parseInt(this.in.readLine());
        }
        catch(Exception ArrayIndexOutOfBoundsException){
            System.out.println("Please enter a valid number");
        }
        return 0;
    }
}
