package pl.sda.snake;

public class GameOverException extends RuntimeException {

    public GameOverException() {
        super("Gra Skonczona");
    }
}
