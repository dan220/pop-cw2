
public abstract class Player {
    private char token;

    public Player(char token){
        this.token = token;
    }

    public char getToken(){
        return this.token;
    }

    abstract int getMove();


}
