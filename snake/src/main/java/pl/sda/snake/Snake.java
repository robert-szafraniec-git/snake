package pl.sda.snake;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.LinkedList;

@ToString
@EqualsAndHashCode

public class Snake {
    public void setDirection(SnakeDirection direction) {
        if (!direction.isOpposite(this.direction)) {
            this.direction = direction;
        }
    }

    @Getter
    private SnakeDirection direction;
    @Getter
    private LinkedList<GameField> tail = new LinkedList<>();
    private boolean isEating;

    public Snake(SnakeDirection direction, GameField... gameFields) {
        this.direction = direction;
        tail.addAll(Arrays.asList(gameFields));
    }

    public void move() {
        GameField nextField = getNexField();
        tail.addFirst(nextField);
        if (!isEating) {
            tail.removeLast();
        } else {
            isEating = false;
        }
    }

    public GameField getNexField() {
        switch (direction) {
            case RIGHT:
                return getHead().getRight();
            case LEFT:
                return getHead().getLeft();
            case DOWN:
                return getHead().getDown();
            case UP:
                return getHead().getUp();
        }
        throw new IllegalArgumentException("brak kierunku węża");
    }

    private GameField getHead() {
        return tail.getFirst();
    }

    public void eatApple() {
        isEating = true;
    }
}
