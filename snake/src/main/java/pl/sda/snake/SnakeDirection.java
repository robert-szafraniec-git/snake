package pl.sda.snake;

public enum SnakeDirection {
    LEFT, UP, DOWN, RIGHT;

    public boolean isOpposite(SnakeDirection direction) {
         switch (this) {
             case UP: return direction == DOWN;
             case DOWN: return direction == UP;
             case RIGHT: return direction == LEFT;
             case LEFT: return direction == RIGHT;
         }
         return false;
    }
}
