import java.util.Random;

public class ComputerPlayer extends Player {

    private Random random = new Random();

    public ComputerPlayer(char token) {
        super(token);
    }

    // Generates a random number for computer player between 1 and 6
    public int getMove() {
        return this.random.nextInt(5) + 1;
    }
}
