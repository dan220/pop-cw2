import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Player {
    private BufferedReader in;
    private char token;

    public Player(char token){
        this.token = token;
        this.in = new BufferedReader(new InputStreamReader(System.in));
    }

    public char getToken(){
        return this.token;
    }


    public int getUserInput(){
        try{
            return Integer.parseInt(this.in.readLine());
        }
        catch(Exception e){
            System.out.println("Please enter a valid number");
        }
        return 0;
    }

}
